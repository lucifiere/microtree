package com.atlandes.microtree.tree;

import com.atlandes.microtree.pojo.Node;

import java.util.List;

/**
 * Created by XD.Wang on 2017/10/14.
 * tree's family relation
 */
public class Family<T> {

    private Node<T> self;
    private Node<T> parent;
    private List<Node<T>> grandparents;
    private List<Node<T>> son;
    private List<Node<T>> grandsons;
    private List<Node<T>> family;

    public void analysis(Node<T> curNode) {
    }

    public Node<T> getSelf() {
        return self;
    }

    public void setSelf(Node<T> self) {
        this.self = self;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getGrandparents() {
        return grandparents;
    }

    public void setGrandparents(List<Node<T>> grandparents) {
        this.grandparents = grandparents;
    }

    public List<Node<T>> getSon() {
        return son;
    }

    public void setSon(List<Node<T>> son) {
        this.son = son;
    }

    public List<Node<T>> getGrandsons() {
        return grandsons;
    }

    public void setGrandsons(List<Node<T>> grandsons) {
        this.grandsons = grandsons;
    }

    public List<Node<T>> getFamily() {
        return family;
    }

    public void setFamily(List<Node<T>> family) {
        this.family = family;
    }
}
