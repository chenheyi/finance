<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar11">
    <div style="padding: 5px; background-color: #fff;">
        <label>账户编号：</label>
        <input class="easyui-textbox" type="text" id="accountId">
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm3()" type="button" class="easyui-linkbutton">查询</button>
    </div>

</div>
<table id="table11"></table>
<script>
    function searchForm3(){
        $("#table11").datagrid('load',{
            accountNo:$('#accountId').val()
        })
    }


    $("#table11").datagrid({
        multiSort:true,
        pageSize:10,
        pageList:[1,10,15,20,25,30,40,50],
        toolbar:'#toolbar11',
        fit:true,
        pagination:true,
        url:'accountInfo',
        columns:[[
            {field:'id',title:'序号',width:100,sortable:true},
            {field:'accountNo',title:'账户编号',width:100},
            {field:'userNo',title:'用户编号',width:100},
            {field:'username',title:'用户名',width:100},
            {field:'balance',title:'账户余额',width:100},
            {field:'availableBalance',title:'可用余额',width:100},
            {field:'settAmount',title:'可结算金额',width:100},
            {field:'todayIncome',title:'今日收益',width:100},
            {field:'todayExpend',title:'今日支出',width:100},
            {field:'editTime',title:'更新时间',formatter:function(value,row,index){
                return moment(value).format('dddd,MMMM Do YYYY, h:mm:ss a');
            }}
        ]]
    });
</script>