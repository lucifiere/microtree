package com.atlandes.microtree.tree;

import com.atlandes.microtree.constants.Enums;
import com.atlandes.microtree.processor.DefaultNodeCollector;
import com.atlandes.microtree.processor.NodeCollector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XD.Wang on 2017/10/14.
 * tree's family relation
 */
public class Family<T> {

    private Tree<T> tree;
    private Node<T> self;
    private Node<T> parent;
    private List<Node<T>> ancestors;
    private List<Node<T>> son;
    private List<Node<T>> posterity;
    private List<Node<T>> family;

    public Family(Tree<T> tree) {
        this.tree = tree;
    }

    public void analysis(Node<T> curNode) {
        NodeCollector<T> collector = new DefaultNodeCollector<>(this.tree);
        self = curNode;
        collector.setCollectType(Enums.CollectType.RELATION_ANCESTOR).process(curNode);
        ancestors = collector.get().orElse(new ArrayList<>());
        collector.setCollectType(Enums.CollectType.RELATION_POSTERITY).process(curNode);
        posterity = collector.get().orElse(new ArrayList<>());
        collector.setCollectType(Enums.CollectType.RELATION_PARENT).process(curNode);
        parent = collector.get().isPresent() ? collector.get().get().get(0) : null;
        collector.setCollectType(Enums.CollectType.RELATION_SON).process(curNode);
        son = collector.get().orElse(new ArrayList<>());
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

    public List<Node<T>> getAncestors() {
        return ancestors;
    }

    public void setAncestors(List<Node<T>> ancestors) {
        this.ancestors = ancestors;
    }

    public List<Node<T>> getSon() {
        return son;
    }

    public void setSon(List<Node<T>> son) {
        this.son = son;
    }

    public List<Node<T>> getPosterity() {
        return posterity;
    }

    public void setPosterity(List<Node<T>> posterity) {
        this.posterity = posterity;
    }

    public List<Node<T>> getFamily() {
        return family;
    }

    public void setFamily(List<Node<T>> family) {
        this.family = family;
    }
}
