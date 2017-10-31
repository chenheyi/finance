<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>无标题文档</title>

    <style type="text/css">
        table.hovertable {
            font-family: verdana,arial,sans-serif;
            font-size:14px;
            color:#333333;
            border-collapse: collapse;
            margin-top:15px;


        }
        table.hovertable th {
            padding: 8px;
            text-align:right;
        }
        table.hovertable td:nth-child(1) {
        }
        table.hovertable tr {

        }
        table.hovertable td {
            padding: 8px;
            padding-right:160px;
        }
        .tab-box{
            border:#0CF 1px dashed;
            padding:10px;
            margin:10px;
            margin-top:50px;
            position:relative;
        }
        .top-box{
            position:absolute;
            padding:10px;
            top:-30px;
            background:#FFF;
            font-size:18px;
            font-weight:bold;
            left:0px;
        }
    </style>
</head>

<body>
<!-- CSS goes in the document HEAD or added to your external stylesheet -->


<!-- Table goes in the document BODY -->
<div class="tab-box">
    <div class="top-box">结算详情</div>
    <table class="hovertable" cellspacing="10">
        <tr style="margin-top:30px;">
            <th>创建日期:</th><td><fmt:formatDate value="${rsr.createTime}" pattern="yyyy-MM-dd hh:mm" /></td><th >用户编号:</th><td>${rsr.userNo}</td>
        </tr>
        <tr>
            <th>用户名:</th><td>${rsr.userName}</td><th>结算金额:</th><td>${rsr.settAmount}</td>
        </tr>
        <tr >
            <th>状态:</th><td>${rsr.settStatus}</td><th>备注:</th><td>${rsr.remark}</td>
        </tr>
        <tr>
            <th>银行名称:</th><td>${rsr.bankName}</td><th>开户名:</th><td>${rsr.bankAccountName}</td>
        </tr>
        <tr>
            <th>开户账户:</th><td>${rsr.bankAccountNo}</td><th>打款金额:</th><td>${rsr.remitAmount}</td>
        </tr>
        <tr>
            <th>打款备注:</th><td>${rsr.remitRemark}</td><th>打款时间:</th><td>${rsr.remitConfirmTime}</td>
        </tr>
    </table>
</div>
<!-- 导入moment.js-->
<script src="js/moment/moment-with-locales.js"></script>
<!--使用中文格式-->
<script>
    moment.locale('zh-cn');
</script>
</body>
</html>
