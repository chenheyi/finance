<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar6">
    <div style="padding: 5px; background-color: #fff;">
        <label>用户名：</label>
        <input class="easyui-textbox" type="text" id="username">
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
    <div>
    </div>
</div>
<link rel="stylesheet" href="js/jquery-easyui-1.5/themes/bootstrap/easyui.css">
<link rel="stylesheet" href="js/jquery-easyui-1.5/themes/icon.css">
<link rel="stylesheet" href="css/common.css">
<table id="ta"></table>
<script>
    function searchForm(){
        $("#ta").datagrid('load',{
            username:$('#username').val()
        })
    }
    function toView(id){
        if ($('#tab').tabs('exists','查看')){
            $('#tab').tabs('select','查看')
        }else{
            $('#tab').tabs('add',{
                //选项卡的标题
                title:'查看',
                //就是选项卡的内容的链接地址（请求地址）
                href:"viewInfo?id="+id,
                //该选项卡可以被关闭
                closable:true,
            });
        }

    }

    $("#ta").datagrid({
        multiSort:true,
        pageSize:10,
        pageList:[1,10,15,20,25,30,40,50],
        toolbar:'#toolbar',
        fit:true,
        pagination:true,
        url:'items',
        columns:[[
            {field:'id',title:'序号',width:100,sortable:true},
            {field:'userName',title:'用户名',width:100},
            {field:'settAmount',title:'结算金额',width:100},
            {field:'bankName',title:'银行名称',width:100},
            {field:'bankAccountName',title:'开户名',width:100},
            {field:'bankAccountNo',title:'开户账户',width:100},
            {field:'mobileNo',title:'收款手机号',width:100},
            {field:'settStatus',title:'结算状态',width:100},
            {field:'createTime',title:'创建时间',width:100,formatter:function(value,row,index){
                return moment(value).format('dddd,MMMM Do YYYY, h:mm:ss a');
           }},
            { field: '        ',title: '操作', width:100, formatter:function(value,rowData,rowIndex){
                //function里面的三个参数代表当前字段值，当前行数据对象，行号（行号从0开始）
                var str = "<a href='javascript:void(0)' onclick='toView(&apos;" + rowData.id + "&apos;)'>查看</a>";
                //return "<a href='javascript:void(0)' onclick='javascript:$('#read_start').dialog('open');'>开始阅读</a>";
                return str;
            }}//上面的'是表示的单引号，这是html的转义表示方式。

        ]]
    });
</script>
