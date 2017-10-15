package com.atlandes.microtree.controller;

import com.atlandes.microtree.data.BusinessData;
import com.atlandes.microtree.tree.DefaultTree;
import com.atlandes.microtree.tree.Node;
import com.atlandes.microtree.tree.Tree;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Node getTree(List<BusinessData> data) {
        Tree tree = new DefaultTree(data);
        return tree.getRoot();
    }

}
