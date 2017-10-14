package com.atlandes.microtree.test;

import com.alibaba.fastjson.JSON;
import com.atlandes.microtree.data.BusinessData;
import com.atlandes.microtree.processor.DefaultPreProcessor;
import com.atlandes.microtree.tree.DefaultTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by XD.Wang on 2017/10/12.
 * to test it
 */
@SuppressWarnings("unchecked")
public class Test {

    public static void main(String[] args) {
        List<BusinessData> testData = getTestData();
        DefaultTree tree = new DefaultTree(testData);
        tree.downwardTravel(new DefaultPreProcessor(tree, Arrays.asList(1, 2, 3, 8, 11, 55)));
        System.out.println(JSON.toJSONString(tree.getRoot()));
    }

    private static List<BusinessData> getTestData() {
        List<BusinessData> list = new ArrayList<>();
        TestPO po1 = new TestPO();
        po1.setId(1);
        po1.setName("中国");
        list.add(po1);

        TestPO po2 = new TestPO();
        po2.setId(2);
        po2.setName("美国");
        list.add(po2);

        TestPO po3 = new TestPO();
        po3.setId(3);
        po3.setName("日本");
        list.add(po3);

        TestPO po4 = new TestPO();
        po4.setId(4);
        po4.setName("陕西");
        po4.setParent(1);
        list.add(po4);

        TestPO po5 = new TestPO();
        po5.setId(5);
        po5.setName("广东");
        po5.setParent(1);
        list.add(po5);

        TestPO po6 = new TestPO();
        po6.setId(6);
        po6.setName("深圳");
        po6.setParent(5);
        list.add(po6);

        TestPO po7 = new TestPO();
        po7.setId(7);
        po7.setName("广州");
        po7.setParent(5);
        list.add(po7);

        TestPO po8 = new TestPO();
        po8.setId(8);
        po8.setName("天河区");
        po8.setParent(7);
        list.add(po8);

        TestPO po9 = new TestPO();
        po9.setId(9);
        po9.setName("越秀区");
        po9.setParent(7);
        list.add(po9);

        TestPO po10 = new TestPO();
        po10.setId(10);
        po10.setName("海珠区");
        po10.setParent(7);
        list.add(po10);

        TestPO po11 = new TestPO();
        po11.setId(11);
        po11.setName("番禺区");
        po11.setParent(7);
        list.add(po11);
        return list;
    }

}
