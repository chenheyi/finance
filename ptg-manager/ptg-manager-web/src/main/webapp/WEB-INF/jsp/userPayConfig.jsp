<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div id="toolbar1">
    <div style="padding: 5px; background-color: #fff;">
        <label>用户名：</label>
        <input class="easyui-textbox" type="text" id="userName">

        <label>支付产品名称：</label>
        <input class="easyui-textbox" type="text" id="title">
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">查询</button>
    </div>
</div>

<table id="dg1"></table>

<script>
    function searchForm(){
        $('#dg1').datagrid('load',{
            userName:$('#userName').val(),
            title: $('#title').val()
        });
    }

    $('#dg1').datagrid({
        fit:true,
        pagination:true,
        pageList:[2,10,20,30],
        toolbar:'#toolbar1',
        url:'ListUserPayConfig',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'序号',width:50},
            {field:'productCode',title:'支付产品编号',width:80},
            {field:'productName',title:'支付产品名称',width:100},
            {field:'userName',title:'用户名',width:80},
            {field:'paySecret',title:'支付密钥',width:300},
            {field:'payKey',title:'支付key',width:300},
            {field:'fundIntoType',title:'收款方式',width:80},
            {field:'createTime',title:'创建时间',formatter:function(value,row,index){
                return moment(value).format('dddd, MMMM Do YYYY, h:mm:ss a');
            }}

           /* { field: 'operation', title: '操作', width: 600, formatter: function (value, rowData, rowIndex) {
                return "<a href='pay_way'>查看支付方式</a>";
            }}*/
        ]]
    });

</script>