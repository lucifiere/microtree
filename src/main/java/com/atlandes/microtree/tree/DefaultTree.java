package com.atlandes.microtree.tree;

import com.atlandes.microtree.constants.Config;
import com.atlandes.microtree.pojo.BusinessData;
import com.atlandes.microtree.pojo.Node;
import com.atlandes.microtree.processor.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by XD.Wang on 2017/10/11.
 * tree common impl
 */
public class DefaultTree<T> implements Tree<T> {

    private Node<T> root;

    public DefaultTree() {
    }

    public Node<T> getRoot() {
        return root;
    }

    @Override
    public Node<T> build(List<BusinessData<T>> businessData) {
        List<Node<T>> nodeList = convertBusinessData2Node(businessData);
        this.root = getRootNode(nodeList);
        return recursiveRoot(this.root, nodeList);
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

    private Node<T> recursiveRoot(Node<T> rootNode, List<Node<T>> allNode) {
        List<Node<T>> heightLevelNodes = new ArrayList<>();
        for (Node<T> node : allNode) {
            if (node.getParent() == null) {
                node.setLevel(Config.HIGHEST_LEVEL);
                heightLevelNodes.add(node);
            }
        }
        for (Node<T> heightLevelNode : heightLevelNodes) {
            recursiveNode(heightLevelNode, allNode);
        }
        rootNode.setChildren(heightLevelNodes);
        return rootNode;
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

    @Override
    public void travel(Node<T> curNode, Processor<T> processor) {
        if (curNode == null) return;
        processor.process(curNode);
        for (Node<T> child : curNode.getChildren()) {
            travel(child, processor);
        }
    }

    @Override
    public void travel(Processor<T> processor) {
        travel(root, processor);
    }

}
