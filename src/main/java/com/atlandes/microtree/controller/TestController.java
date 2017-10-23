package com.atlandes.microtree.controller;

import com.atlandes.microtree.constants.Config;
import com.atlandes.microtree.data.BusinessData;
import com.atlandes.microtree.processor.DefaultPreProcessor;
import com.atlandes.microtree.test.Test;
import com.atlandes.microtree.tree.DefaultTree;
import com.atlandes.microtree.tree.Node;
import com.atlandes.microtree.tree.Tree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

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
    public Node getTree(String ids) {
        Tree tree = new DefaultTree(Test.getTestData());
        tree.downwardTravel(new DefaultPreProcessor(tree, ids));
        return tree.getRoot();
    }

}
