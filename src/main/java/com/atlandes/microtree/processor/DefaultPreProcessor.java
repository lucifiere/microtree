package com.atlandes.microtree.processor;

import com.atlandes.microtree.constants.Config;
import com.atlandes.microtree.tree.DefaultTree;
import com.atlandes.microtree.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by XD.Wang on 2017/10/14.
 * default pre processor impl
 */
public class DefaultPreProcessor<T> extends PreProcessor<T> {

    public DefaultPreProcessor(Tree<T> tree, List<Integer> checkedIdList) {
        super(tree, checkedIdList);
    }

    public DefaultPreProcessor(Tree<T> tree, String checkedIdListStr) {
        super(tree, checkedIdListStr);
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
