/**
 *  Created by XD.Wang on 2016/10/20.
 */

var res = $("#msg").val();
if (!isNull(res)) {
    alert(res);
}

function login() {
    var pw = $("#password").val();
    var nick = $("#nickname").val();
    var user = {};
    user.nickname = nick;
    user.password = pw;
    $.ajax({
        type: "post",
        url: "/auth/login",
        dataType: 'json',
        contentType: "application/json",
        async: false,
        data: JSON.stringify(user),
        success: function (data) {
            if (data.code === 0) {
                alert(data.msg);
            }
        },
        error: function () {
            alert("登录失败 - 400");
        }
    });
}
