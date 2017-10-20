package com.atlandes.microtree.tree;

import com.atlandes.microtree.constants.Config;
import com.atlandes.microtree.constants.Enums;
import com.atlandes.microtree.data.BusinessData;
import com.atlandes.microtree.processor.DefaultNodeCollector;
import com.atlandes.microtree.processor.NodeCollector;
import com.atlandes.microtree.processor.Processor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by XD.Wang on 2017/10/11.
 * tree common impl
 */
public class DefaultTree<T> implements Tree<T> {

    private Tree<T> tree;

    private Node<T> root;

    private Map<Integer, Node<T>> nodeDict;

    private List<Node<T>> nodeList;

    private NodeCollector<T> collector;

    public DefaultTree(List<BusinessData<T>> businessData) {
        rebuild(businessData);
    }

    @Override
    public Map<Integer, Node<T>> dict() {
        if (nodeDict == null && !CollectionUtils.isEmpty(nodeList)) {
            nodeDict = new HashMap<>();
            for (Node<T> node : nodeList) {
                nodeDict.put(node.getId(), node);
            }
            return nodeDict;
        }
        return new HashMap<>();
    }

    @Override
    public List<Node<T>> getNodeList() {
        return nodeList;
    }

    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    @Override
    public List<Node<T>> getAncestors(Node<T> origin) {
        collector.setCollectType(Enums.CollectType.RELATION_ANCESTOR).process(origin);
        return collector.get().orElse(new ArrayList<>());
    }

    @Override
    public List<Node<T>> getPosterity(Node<T> origin) {
        collector.setCollectType(Enums.CollectType.RELATION_POSTERITY).process(origin);
        return collector.get().orElse(new ArrayList<>());
    }

    @Override
    public void rebuild(List<BusinessData<T>> businessData) {
        this.nodeList = convertBusinessData2Node(businessData);
        this.root = getRootNode(this.nodeList);
        recursiveRoot();
        this.collector = new DefaultNodeCollector<>(this);
        setNodeRelation();
    }

    @Override
    public void downwardTravel(Node<T> curNode, Processor<T> processor) {
        if (curNode == null) return;
        if (processor == null) throw new IllegalArgumentException("processor can not be null!");
        processor.process(curNode);
        for (Node<T> child : curNode.getChildren()) {
            downwardTravel(child, processor);
        }
    }

    @Override
    public void downwardTravel(Processor<T> processor) {
        downwardTravel(root, processor);
    }

    @Override
    public void ancestorSearch(Node<T> curNode, Processor<T> processor) {
        if (curNode == null) return;
        if (processor == null) throw new IllegalArgumentException("processor can not be null!");
        processor.process(curNode);
        if (curNode.getParent() != null) {
            downwardTravel(nodeDict.get(curNode.getParent()), processor);
        }
    }

    private List<Node<T>> convertBusinessData2Node(List<BusinessData<T>> businessDataList) {
        List<Node<T>> nodeList = new ArrayList<>();
        for (BusinessData<T> businessData : businessDataList) {
            Node<T> node = new Node<>();
            node.setData(businessData.getData());
            node.setId(businessData.getId());
            node.setName(businessData.getName());
            node.setParent(businessData.getParent());
            nodeList.add(node);
        }
        return nodeList;
    }

    private Node<T> getRootNode(List<Node<T>> nodeList) {
        Node<T> root = new Node<>();
        root.setLevel(Config.ROOT_LEVEL);
        List<Node<T>> children = root.getChildren();
        for (Node<T> node : nodeList) {
            if (Objects.equals(node.getLevel(), Config.HIGHEST_LEVEL)) {
                children.add(node);
            }
        }
        return root;
    }

    private Node<T> recursiveRoot() {
        List<Node<T>> heightLevelNodes = new ArrayList<>();
        for (Node<T> node : this.nodeList) {
            if (node.getParent() == null) {
                node.setLevel(Config.HIGHEST_LEVEL);
                heightLevelNodes.add(node);
            }
        }
        for (Node<T> heightLevelNode : heightLevelNodes) {
            recursiveNode(heightLevelNode, this.nodeList);
        }
        this.root.setChildren(heightLevelNodes);
        return this.root;
    }

    private Node<T> recursiveNode(Node<T> curNode, List<Node<T>> allNode) {
        List<Node<T>> childNodeList = new ArrayList<>();
        for (Node<T> node : allNode) {
            if (Objects.equals(node.getParent(), curNode.getId())) {
                node.setLevel(curNode.getLevel() + 1);
                childNodeList.add(node);
            }
        }
        for (Node<T> child : childNodeList) {
            recursiveNode(child, allNode);
            curNode.getChildren().add(child);
        }
        return curNode;
    }

    private void setNodeRelation() {
        for (Node<T> node : this.nodeList) {
            this.collector.setCollectType(Enums.CollectType.RELATION_ANCESTOR).process(node);
            node.setAncestor(this.collector.get().orElse(null));
            this.collector.setCollectType(Enums.CollectType.RELATION_POSTERITY).process(node);
            node.setPosterity(this.collector.get().orElse(null));
        }
    }

}
