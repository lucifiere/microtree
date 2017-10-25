package com.atlandes.microtree.tree;

import java.util.Map;

/**
 * Created by XD.Wang on 2017/10/24.
 * use for font page
 */
public class TreeVO<T> {

    private Node<T> root;

    private Map<Integer, Node<T>> dict;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Map<Integer, Node<T>> getDict() {
        return dict;
    }

    public void setDict(Map<Integer, Node<T>> dict) {
        this.dict = dict;
    }

}
