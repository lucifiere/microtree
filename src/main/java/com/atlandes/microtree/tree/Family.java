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
    private Integer self;
    private Integer parent;
    private List<Integer> ancestors;
    private List<Integer> son;
    private List<Integer> posterity;
    private List<Integer> family;

    public Family(Tree<T> tree) {
        this.tree = tree;
    }

    public void analysis(Node<T> curNode) {
        NodeCollector<T> collector = new DefaultNodeCollector<>(this.tree);
        self = curNode.getId();
        collector.setCollectType(Enums.CollectType.RELATION_ANCESTOR).process(curNode);
        ancestors = collector.get().orElse(new ArrayList<>());
        collector.setCollectType(Enums.CollectType.RELATION_POSTERITY).process(curNode);
        posterity = collector.get().orElse(new ArrayList<>());
        collector.setCollectType(Enums.CollectType.RELATION_PARENT).process(curNode);
        parent = collector.get().isPresent() && collector.get().get().size() > 0 ? collector.get().get().get(0) : null;
        collector.setCollectType(Enums.CollectType.RELATION_SON).process(curNode);
        son = collector.get().orElse(new ArrayList<>());
    }

    public Tree<T> getTree() {
        return tree;
    }

    public void setTree(Tree<T> tree) {
        this.tree = tree;
    }

    public Integer getSelf() {
        return self;
    }

    public void setSelf(Integer self) {
        this.self = self;
    }

    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }

    public List<Integer> getAncestors() {
        return ancestors;
    }

    public void setAncestors(List<Integer> ancestors) {
        this.ancestors = ancestors;
    }

    public List<Integer> getSon() {
        return son;
    }

    public void setSon(List<Integer> son) {
        this.son = son;
    }

    public List<Integer> getPosterity() {
        return posterity;
    }

    public void setPosterity(List<Integer> posterity) {
        this.posterity = posterity;
    }

    public List<Integer> getFamily() {
        return family;
    }

    public void setFamily(List<Integer> family) {
        this.family = family;
    }
}
