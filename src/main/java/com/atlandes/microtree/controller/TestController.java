package com.atlandes.microtree.controller;

import com.atlandes.microtree.processor.DefaultPreProcessor;
import com.atlandes.microtree.test.Test;
import com.atlandes.microtree.tree.DefaultTree;
import com.atlandes.microtree.tree.Tree;
import com.atlandes.microtree.tree.SerializedTree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XD.Wang on 2017/10/15.
 * for show
 */
@Controller
@RequestMapping("microtree")
@SuppressWarnings("unchecked")
public class TestController {

    @RequestMapping("show")
    public String show() {
        return "/microtree";
    }

    @RequestMapping("getTree")
    @ResponseBody
    public SerializedTree getTree(String ids) {
        Tree tree = new DefaultTree(Test.getTestData());
        tree.downwardTravel(new DefaultPreProcessor(tree, ids));
        SerializedTree ser = new SerializedTree();
        ser.setRoot(tree.getRoot());
        ser.setDict(tree.dict());
        return ser;
    }

}
