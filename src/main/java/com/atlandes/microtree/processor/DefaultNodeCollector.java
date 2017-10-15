package com.atlandes.microtree.processor;

import com.atlandes.microtree.constants.Enums;
import com.atlandes.microtree.tree.Node;
import com.atlandes.microtree.tree.Tree;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by XD.Wang on 2017/10/15.
 * node collector to gather the qualified node
 */
public class DefaultNodeCollector<T> implements NodeCollector<T> {

    private Node<T> cursor;
    private Node<T> origin;
    private Tree<T> tree;
    private Enums.CollectType collectType;
    private List<Node<T>> nodes;

    public DefaultNodeCollector(Tree<T> tree) {
        this.tree = tree;
    }

    public DefaultNodeCollector(Tree<T> tree, Enums.CollectType collectType) {
        this.tree = tree;
        this.collectType = collectType;
    }

    @Override
    public Enums.CollectType getCollectType() {
        return collectType;
    }

    @Override
    public DefaultNodeCollector<T> setCollectType(Enums.CollectType collectType) {
        this.collectType = collectType;
        return this;
    }

    @Override
    public Optional<List<Node<T>>> get() {
        return Optional.ofNullable(nodes);
    }

    private void resetCursor() {
        this.cursor = this.origin;
    }

    @Override
    public void process(Node<T> node) {
        if (collectType != null) {
            nodes.clear();
            this.origin = node;
            this.cursor = node;
            switch (collectType) {
                case RELATION_SON:
                    collectSon();
                    break;
                case RELATION_PARENT:
                    collectParent();
                    break;
                case RELATION_ANCESTOR:
                    collectAncestors();
                    break;
                case RELATION_GRANDSON:
                    collectGrandson();
                    break;
                case RELATION_POSTERITY:
                    collectPosterity();
                    break;
                case RELATION_GRANDPARENT:
                    collectGrandparent();
                    break;
                default:
                    nodes = new ArrayList<>();
            }
        }
    }

    private void collectAncestors() {
        if (this.cursor != null) {
            Node<T> parent = tree.dict().get(cursor.getParent());
            if (parent != null) {
                nodes.add(parent);
                cursor = parent;
                collectAncestors();
            }
        }
    }

    private void collectPosterity() {
        if (this.cursor != null) {
            List<Node<T>> children = tree.dict().get(cursor.getId()).getChildren();
            if (!CollectionUtils.isEmpty(children)) {
                nodes.addAll(children);
                for (Node<T> child : children) {
                    cursor = child;
                    collectPosterity();
                }
            }
        }
    }

    private void collectSon() {

    }

    private void collectParent() {

    }

    private void collectGrandson() {

    }

    private void collectGrandparent() {

    }

}
