/**
 * Created by XD.Wang on 2017/10/20.
 * microtree v1.0.0
 */
$(document).ready(function () {
    tree.init();
});

var CONFIG = {};

/**
 * HTML templates
 */
var HTML = {
    /**
     * setting
     */
    inputSetting: {
        type: "radio"
    },
    nameSetting: {
        halfChoiceType: 1,
        halfChoiceNameColor: "#66FF66"
    },
    iconSetting: {
        spreadClass: "glyphicon glyphicon-chevron-down",
        shrinkClass: "glyphicon glyphicon-chevron-right",
        noPosterityTransparency: 0.0
    },
    spanSetting: {
        multiple: 2,
        blankType: "&emsp;"
    },
    brSetting: {
        multiple: 1
    },
    /**
     * generate radio HTML from setting
     */
    genInputHTML: function (node) {
        return $("<input>").attr({
            "onclick": "node.selectCATG(this)",
            "spread": node.spread,
            "type": HTML.inputSetting.type,
            "check": node.check,
            "parent": node.parent,
            "nodeID": node.id,
            "display": node.display,
            "level": node.level,
            "halfChoice": node.halfChoice,
            "name": "nodeInput_" + node.level
        });
    },
    /**
     * generate icon HTML from setting
     */
    genIconHTML: function (node) {
        return $("<i></i>").attr({
            "onclick": "node.toggleCATG(this)",
            "spread": node.spread,
            "check": node.check,
            "display": node.display,
            "parent": node.parent,
            "class": HTML.iconSetting.shrinkClass,
            "opacity": HTML.iconSetting.noPosterityTransparency,
            "nodeID": node.id,
            "level": node.level,
            "halfChoice": node.halfChoice,
            "name": "nodeIcon_" + node.level
        });
    },
    /**
     * generate name HTML from setting
     */
    genNameHTML: function (node) {
        return $("<label></label>").attr({
            "onclick": "node.selectCATG(this)",
            "spread": node.spread,
            "check": node.check,
            "display": node.display,
            "parent": node.parent,
            "nodeID": node.id,
            "level": node.level,
            "halfChoice": node.halfChoice,
            "name": "nodeName_" + node.level
        }).text(node.name);
    },
    /**
     * generate span HTML from setting
     */
    genSpanHTML: function (node) {
        var blankContent = "";
        var blankType = HTML.spanSetting.blankType;
        for (var i = 0; i < HTML.spanSetting.multiple * node.level; i++) {
            blankContent += blankType;
        }
        return $("<span></span>").attr({
            "onclick": "node.selectCATG(this)",
            "spread": node.spread,
            "display": node.display,
            "check": node.check,
            "parent": node.parent,
            "nodeID": node.id,
            "level": node.level,
            "halfChoice": node.halfChoice,
            "name": "nodeSpan_" + node.level
        }).append(blankContent);
    },
    /**
     * generate br HTML from setting
     */
    genBrHTML: function (node) {
        return $("<br>").attr({
            "nodeID": node.id,
            "display": node.display,
            "name": "nodeBr_" + node.level
        });
    }

};

/**
 * handle node select
 * @type {{checkboxLinkageType: string, radioLinkageType: string, selectCATG: nodeSelector.selectCATG}}
 */
var nodeSelector = {
    /**
     * the way to influencing other node when selecting a checkbox node
     * @enum [string]
     *
     * 1. "down": the node with high level do lead to the node with lower level be checked.
     * 2. "up": the node with low level do lead to the node with higher level be checked, and only when the latter one has
     *          direct relation to the former.
     * 3. "none": without any linkage relation.
     */
    checkboxLinkageType: "down",
    /**
     * the way to select a radio node
     * @enum [string]
     *
     * 1. "unique": only one data can be checked
     * 2. "level-unique": within the same level, only one data can be checked
     */
    radioLinkageType: "level-unique",
    /**
     * function after selecting a category
     */
    selectCATG: function (_this) {

    }
};

/**
 * handle node toggle including spread and shrink
 * @type {{toggleCATG: nodeToggle.toggleCATG}}
 */
var nodeToggle = {
    /**
     * function when toggling a category
     */
    toggleCATG: function (_this) {

    }
};


var tree = {
    /**
     * container of the tree
     */
    container: null,
    /**
     * tree data
     */
    tree: null,
    /**
     * base tree setting
     */
    setting: {
        checkedIDList: []
    },
    /**
     * init a tree with default setting
     */
    init: function () {
        tree.customizedInit(tree.setting);
    },
    /**
     * init a tree with customized tree
     */
    customizedInit: function (setting) {
        if (tree.initContainer()) {
            $.ajax({
                type: "post",
                url: "/microtree/getTree.do?ids=" + setting.checkedIDList.join(","),
                dataType: 'json',
                async: false,
                success: function (root) {
                    if (!utils.isNull(root)) {
                        tree.container.html(tree.buildTree(root.children));
                    } else {
                        alert("load tree failed！");
                    }
                }
            });
        }
    },
    /**
     * check and init container
     */
    initContainer: function () {
        var container = $("#microtreeContainer");
        if (container.length == 0) {
            alert("init micro tree failed ! cannot find a HTML element with id called 'microtreeContainer' !");
            return false;
        }
        tree.container = container;
        var checkedID = container.attr("checkedID");
        if (!utils.isNull(checkedID)) {
            checkedID.split(",").forEach(function (v) {
                tree.setting.checkedIDList.push(v);
            });
        }
        container.addClass("microtreeContainer");
        return true;
    },
    /**
     * load tree from HTML setting
     */
    buildTree: function (list) {
        var nodeHTML = "";
        for (var i = 0; i < list.length; i++) {
            var node = list[i];
            if (HTML.genSpanHTML(node) != null) {
                nodeHTML += HTML.genSpanHTML(node).prop("outerHTML");
            }
            nodeHTML += HTML.genIconHTML(node).prop("outerHTML");
            nodeHTML += HTML.genInputHTML(node).prop("outerHTML");
            nodeHTML += HTML.genNameHTML(node).prop("outerHTML");
            for (var k = 0; k < HTML.brSetting.multiple; k++) {
                nodeHTML += HTML.genBrHTML(node).prop("outerHTML");
            }

            var children = node.children;
            if (!utils.isNull(children)) {
                nodeHTML += tree.buildTree(children);
            }
        }
        return nodeHTML;
    }
};
/**
 * some utils
 * @type {{isNull: utils.isNull}}
 */
var utils = {
    /**
     *  confirm whether null
     * @param value
     * @returns {boolean}
     */
    isNull: function (value) {
        return value == null || $.trim(value) == '' || $.trim(value) == 'null' ||
            $.trim(value) == 'NULL' || typeof(value) == 'undefined';
    }
};