package com.atlandes.microtree.service;

import com.atlandes.microtree.constants.Config;
import com.atlandes.microtree.pojo.BusinessData;
import com.atlandes.microtree.pojo.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by XD.Wang on 2017/10/11.
 * tree common impl
 */
public class Tree<T> {

    private Node<T> root;

    private Tree() {
    }

    public Tree<T> build(List<BusinessData<T>> businessData) {
        List<Node<T>> nodeList = convertBusinessData2Node(businessData);
        this.root = getRootNode(nodeList);
        recursiveTree(this.root, nodeList);
        return this;
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
        List<Node<T>> children = root.getChildren();
        for (Node<T> node : nodeList) {
            if (Objects.equals(node.getLevel(), Config.HEGHEST_LEVEL)) {
                children.add(node);
            }
        }
        return root;
    }

    private Node<T> recursiveTree(Node<T> rootNode, List<Node<T>> allNode) {
//        List<Node<T>> children = rootNode.getParent() != nulrootNode.getChildren();
//        for (Node<T> child : children) {
//            recursiveTree(child, allNode);
//            child.getChildren()
//        }
//        return curNode;
        return null;
    }

}
