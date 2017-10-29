<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Custom Login Form Styling</title>
    <meta name="description" content="Custom Login Form Styling with CSS3" />
    <meta name="keywords" content="css3, login, form, custom, input, submit, button, html5, placeholder" />
    <meta name="author" content="Codrops" />
    <link rel="shortcut icon" href="images/timg.jpg">
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script src="js/modernizr.custom.63321.js"></script>

    <style>
        @import url(http://fonts.googleapis.com/css?family=Raleway:400,700);
        body {
            background: url(images/finance.jpeg);
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
        }
        .container > header h1,
        .container > header h2 {
            color: #fff;
            text-shadow: 0 1px 1px rgba(0,0,0,0.7);
        }
    </style>
</head>
<body>
<div class="container">

    <div class="codrops-top">
        <a href="http://www.xuekai.me/">
            <strong>&laquo; 公司域名:陈波 </strong>
        </a>
        <span class="right">
                	<a href="http://www.baidu.com"><strong>百度</strong></a>
                    <a href="http://www.alibaba.com">
                        <strong>阿里巴巴</strong>
                    </a>
                </span>
    </div>

    <header>

        <h1><strong><strong>ptg支付管理系统</strong></strong></h1>
        <h2>In the field of the Pay, we can do the best for you</h2>
        <div class="support-note">
            <span class="note-ie">Sorry, only modern browsers.</span>
        </div>

    </header>

    <section class="main">
        <form class="form-4" id="loginForm" method="post">
            <p>
                <label for="aName">Username </label>
                <input type="text" name="aName" id="aName" placeholder="Username" required><span id="sp1"></span>
            </p>
            <p>
                <label for="aPassword">Password</label>
                <input type="password" id="aPassword" name='aPassword' placeholder="Password" required><span id="sp2"></span>
            </p>

            <p>
                <input type="submit" name="submit" value="登录系统" />
            </p>
        </form>​
    </section>

</div>

<!-- jquery -->
<script src="js/jquery-easyui-1.5/jquery.min.js"></script>

<script type="text/javascript">
    //jquery用法
    $(function(){
        //前端验证用户和密码是否非空
        $("#loginForm").submit(function(e){

            var un = $("#aName").val();
            var pw = $("#aPassword").val();

            //阻止表单提交
            e.preventDefault();
            //进行Ajax提交
            var jsonstr = {"aName": un, "aPassword": pw};
            $.ajax({
                url: "${pageContext.request.contextPath}/check",
                type: "post",
                data: jsonstr,
                dataType: "text",
                success: function (rec) {
                    alert(rec);
                    if (rec == 1) {
                        $("#sp1").html("用户名或密码错误");
                    } else {
                        location.href = "${pageContext.request.contextPath}/index";
                    }

                },
                error: function () {
                    alert("error");
                }
            });

        });

    })
</script>
</body>
</html>