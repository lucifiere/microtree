package com.atlandes.microtree.test;

import com.atlandes.microtree.pojo.BusinessData;
import com.atlandes.microtree.pojo.Node;
import com.atlandes.microtree.service.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XD.Wang on 2017/10/12.
 * to test it
 */
public class Test {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Tree tree = new Tree();
        List<BusinessData> list = new ArrayList<>();
        Node node = tree.build(list);
    }
}
