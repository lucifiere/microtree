package com.atlandes.microtree.processor;

import com.atlandes.microtree.tree.DefaultTree;

import java.util.List;

/**
 * Created by XD.Wang on 2017/10/14.
 * default pre processor impl
 */
public class DefaultPreProcessor<T> extends PreProcessor<T> {

    public DefaultPreProcessor(DefaultTree<T> tree, List<Integer> checkedIdList) {
        super(tree, checkedIdList);
    }

    @Override
    protected void handleSubCheck() {

    }

    @Override
    protected void handleSpread() {

    }

    @Override
    protected void handleDisplay() {

    }

}
