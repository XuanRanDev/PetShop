
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开发中</title>
</head>
<body>
该功能正在开发中，敬请期待。。。
<p><span id = "time">3</span>秒后跳转至上一页</p>
<script>
    var t = setInterval("jump()", 1000);
    var second = 3;
    function jump() {
        second --;
        document.getElementById("time").innerText = second;
        if(second == 0){
            clearInterval(t);
            window.history.back();
        }
    }
</script>
</body>
</html>
