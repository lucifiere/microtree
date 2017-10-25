package com.atlandes.microtree.tree;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by XD.Wang on 2017/10/24.
 * use for font page
 */
public class SerializedTree<T> {

    private Node<T> root;

    private Map<String, Node<T>> dict;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Map<String, Node<T>> getDict() {
        return dict;
    }

    public void setDict(Map<Integer, Node<T>> dict) {
        Map<String, Node<T>> adaptor = new HashMap<>();
        for (Integer key : dict.keySet()) {
            adaptor.put(String.valueOf(key), dict.get(key));
        }
        this.dict = adaptor;
    }

    public static String getJSON(SerializedTree tree) {
        return JSON.toJSONString(tree);
    }

}
