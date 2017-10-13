package com.atlandes.microtree.test;

import com.alibaba.fastjson.JSON;
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
        TestPO po1 = new TestPO();
        po1.setId(1);
        po1.setName("大类1");
        list.add(po1);

        TestPO po2 = new TestPO();
        po2.setId(2);
        po2.setName("大类2");
        list.add(po2);

        TestPO po3 = new TestPO();
        po3.setId(3);
        po3.setName("大类3");
        list.add(po3);

        TestPO po4 = new TestPO();
        po4.setId(4);
        po4.setName("中类1");
        po4.setParent(1);
        list.add(po4);

        TestPO po5 = new TestPO();
        po5.setId(5);
        po5.setName("中类2");
        po5.setParent(1);
        list.add(po5);

        TestPO po6 = new TestPO();
        po6.setId(6);
        po6.setName("小类2");
        po6.setParent(5);
        list.add(po6);

        TestPO po7 = new TestPO();
        po7.setId(7);
        po7.setName("小类1");
        po7.setParent(5);
        list.add(po7);

        TestPO po8 = new TestPO();
        po8.setId(8);
        po8.setName("超小类1");
        po8.setParent(7);
        list.add(po8);

        TestPO po9 = new TestPO();
        po9.setId(9);
        po9.setName("超小类2");
        po9.setParent(7);
        list.add(po9);

        Node node = tree.build(list);
        System.out.println(JSON.toJSONString(node));
    }
}
