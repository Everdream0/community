// 页面加载完后调用这个函数
$(function () {
    $("#uploadForm").submit(upload);         // 当点击提交按钮触发表单的提交事件时，这个事件由upload函数处理
});

function upload() {
    $.ajax({
        url: "http://upload.qiniup.com",
        method: "post",
        processData: false,  // 不要把表单内容转换成字符串
        contentType: false,   // 不让JQuery设置上传的类型
        data: new FormData($("#uploadForm")[0]),
        success: function (data) {
            if (data && data.code == 0) {
                // 更新头像访问路径
                $.post(
                    CONTEXT_PATH + "/user/header/url",
                    {"fileName":$("input[name='key']").val()},
                    function (data) {
                        data = $.parseJSON(data);
                        if (data.code == 0) {
                            window.location.reload();
                        } else {
                            alert(data.msg);
                        }
                    }
                );
            } else {
                alert("上传失败！");
            }
        }
    });
    return false;                           // 不要再往下提交了，上面处理了
}