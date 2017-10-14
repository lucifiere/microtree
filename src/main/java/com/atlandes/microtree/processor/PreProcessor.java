package com.atlandes.microtree.processor;

import com.atlandes.microtree.exception.TreeStateException;
import com.atlandes.microtree.pojo.Node;
import com.atlandes.microtree.tree.DefaultTree;

import java.util.List;

/**
 * Created by XD.Wang on 2017/10/13.
 * pre processor interface, impl with Template Method Pattern
 */
public abstract class PreProcessor<T> implements Processor<T> {

    protected DefaultTree<T> tree;
    protected Node<T> currentNode;
    protected List<Integer> checkedIdList;

    public PreProcessor(DefaultTree<T> tree, List<Integer> checkedIdList) {
        this.tree = tree;
        this.checkedIdList = checkedIdList;
    }

    abstract void handleCheck();

    abstract void handleSubCheck();

    abstract void handleSpread();

    abstract void handleDisplay();

    @Override
    public void process(Node<T> node) {
        currentNode = node;
        if (isNormalState()) {
            handleCheck();
            handleSpread();
            handleSubCheck();
            handleDisplay();
        } else {
            throw new TreeStateException("tree state not correct! do build method of tree before using it!");
        }
    }

    private boolean isNormalState() {
        return tree != null && tree.getRoot() != null && currentNode != null;
    }

}
