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

    public static List<BusinessData> getTestData() {
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

        TestPO po12 = new TestPO();
        po12.setId(12);
        po12.setName("雁塔区");
        po12.setParent(15);
        list.add(po12);

        TestPO po13 = new TestPO();
        po13.setId(13);
        po13.setName("未央区");
        po13.setParent(15);
        list.add(po13);

        TestPO po14 = new TestPO();
        po14.setId(14);
        po14.setName("碑林区");
        po14.setParent(15);
        list.add(po14);

        TestPO po15 = new TestPO();
        po15.setId(15);
        po15.setName("西安");
        po15.setParent(4);
        list.add(po15);

        TestPO po16 = new TestPO();
        po16.setId(16);
        po16.setName("关东地方");
        po16.setParent(3);
        list.add(po16);

        TestPO po17 = new TestPO();
        po17.setId(17);
        po17.setName("近畿地方");
        po17.setParent(3);
        list.add(po17);

        TestPO po18 = new TestPO();
        po18.setId(18);
        po18.setName("东京");
        po18.setParent(16);
        list.add(po18);

        TestPO po19 = new TestPO();
        po19.setId(19);
        po19.setName("神奈川");
        po19.setParent(16);
        list.add(po19);

        TestPO po20 = new TestPO();
        po20.setId(20);
        po20.setName("大阪");
        po20.setParent(17);
        list.add(po20);

        TestPO po21 = new TestPO();
        po21.setId(21);
        po21.setName("涩谷区");
        po21.setParent(18);
        list.add(po21);

        TestPO po22 = new TestPO();
        po22.setId(22);
        po22.setName("江户川区");
        po22.setParent(18);
        list.add(po22);

        return list;
    }

}
