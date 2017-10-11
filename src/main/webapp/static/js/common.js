/**
 * Created by XD.Wang on 2017/6/14.
 * 通用
 */

// 清空控件值
function setEmpty(id) {
    $("#" + id).val("");
}

// 非空判断
function isNull(value) {
    return (value === null || $.trim(value) === '' || $.trim(value) === 'null' || $.trim(value) === 'undefined'
    || $.trim(value) === 'NULL' || typeof(value) === 'undefined');
}

// 是否正整数
function isPositiveIntegralNumber(content) {
    var re = /^\+?[1-9][0-9]*$/;
    return re.test(content);
}

// 是否0或正整数
function isPositiveIntegralNumberOrZero(content) {
    var re = /^\+?[0-9][0-9]*$/;
    return re.test(content);
}

// 是否正数
function isPositiveNumber(content) {
    var re = /^([1-9]\d*\.\d*|0\.\d+|[1-9]\d*|0)$/;
    return re.test(content);
}

/**
 * d1是否在d2之前
 * @return {boolean}
 */
function CompareDate(d1, d2) {
    return ((new Date(d1.replace(/-/g, "\/"))) > (new Date(d2.replace(/-/g, "\/"))));
}

// d1是否在d2不在d2之后
function compareDate(d1, d2) {
    return ((new Date(d1.replace(/-/g, "\/"))) >= (new Date(d2.replace(/-/g, "\/"))));
}

function getIdChecked() {
    var id = $("input[name='rid']:checked").val();
    if (isNull(id)) {
        alert("请选择需要操作的项目！");
        return null;
    }
    return id;
}