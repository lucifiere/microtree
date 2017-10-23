/**
 * Created by XD.Wang on 2017/10/20.
 * microtree v1.0.0
 */
var CONFIG = {};

/**
 * HTML templates
 */
var HTML = {
    /**
     * setting
     */
    radioSetting: {
        type: "radio"
    },
    nameSetting: {
        halfChoiceType: 1,
        halfChoiceNameColor: "#66FF66"
    },
    iconSetting: {
        spreadClass: "ace-icon fa fa-minus-square",
        shrinkClass: "ace-icon fa fa-plus-square",
        noPosterityTransparency: 0.0
    },
    spanSetting: {
        multiple: 2
    },
    /**
     * generate radio HTML from setting
     */
    genInputHTML: function (node) {
        return $("<input>").attr({
            "onclick": "node.selectCATG(this)",
            "spread": node.spread,
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
        });
    },
    /**
     * generate span HTML from setting
     */
    genSpanHTML: function () {
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
        });
    }
};

var node = {
    /**
     * function after selecting a category
     */
    selectCATG: function (_this) {

    },
    /**
     * function when toggling a category
     */
    toggleCATG: function (_this) {

    }
};

var tree = {
    /**
     * base tree setting
     */
    setting: {
        checked: []
    },
    /**
     * init a tree with default setting
     */
    init: function () {
        tree.customizedInit(tree.setting);
    },
    /**
     * init a tree with  customized tree
     */
    customizedInit: function (setting) {

    }
};
/**
 * some utils
 * @type {{joinCheckedId: utils.joinCheckedId}}
 */
var utils = {
    joinCheckedId: function () {

    }
};
