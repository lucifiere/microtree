package com.atlandes.microtree.processor;

import com.atlandes.microtree.constants.Config;
import com.atlandes.microtree.constants.Enums;
import com.atlandes.microtree.exception.TreeStateException;
import com.atlandes.microtree.tree.Family;
import com.atlandes.microtree.tree.Node;
import com.atlandes.microtree.tree.Tree;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XD.Wang on 2017/10/13.
 * pre processor interface, impl with Template Method Pattern
 */
public abstract class PreProcessor<T> implements Processor<T> {

    protected Tree<T> tree;
    protected List<Integer> checkedIdList;

    protected Node<T> currentNode;
    protected Family<T> family;

    public PreProcessor(Tree<T> tree, List<Integer> checkedIdList) {
        this.tree = tree;
        this.family = new Family<>(tree);
        this.checkedIdList = checkedIdList;
    }

    public PreProcessor(Tree<T> tree, String checkedIdListStr) {
        List<Integer> checkedIdList = null;
        if (StringUtils.isNotBlank(checkedIdListStr)) {
            checkedIdList = new ArrayList<>();
            String[] idArray = checkedIdListStr.split(Config.ID_SEP);
            for (String id : idArray) {
                checkedIdList.add(Integer.valueOf(id));
            }
        }
        this.tree = tree;
        this.family = new Family<>(tree);
        this.checkedIdList = checkedIdList;
    }

    protected void handleCheck() {
        if (checkedIdList != null && checkedIdList.contains(currentNode.getId())) {
            currentNode.setCheck(Enums.Checked.YES.ordinal());
        }
    }

    protected abstract void handleSubCheck();

    protected abstract void handleSpread();

    protected abstract void handleDisplay();

    @Override
    public void process(Node<T> node) {
        currentNode = node;
        family.analysis(currentNode);
        if (isNormalState()) {
            handleCheck();
            handleSpread();
            handleSubCheck();
            handleDisplay();
        } else {
            throw new TreeStateException("tree state not correct! do rebuild method of tree before using it!");
        }
    }

    private boolean isNormalState() {
        return tree != null && tree.getRoot() != null && currentNode != null;
    }

}
