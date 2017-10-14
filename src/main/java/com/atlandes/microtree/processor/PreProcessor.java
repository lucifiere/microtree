package com.atlandes.microtree.processor;

import com.atlandes.microtree.tree.DefaultTree;

import java.util.List;

/**
 * Created by XD.Wang on 2017/10/13.
 * pre processor interface, impl with Template Method Pattern
 */
public abstract class PreProcessor<T> implements Processor {

    protected DefaultTree<T> tree;
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
    public void process() {
        handleCheck();
        handleSpread();
        handleSubCheck();
        handleDisplay();
    }

}
