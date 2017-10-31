<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div id="toolbar4">
    <div style="padding: 5px; background-color: #fff;">
        <label>账户编号：</label>
        <input class="easyui-textbox" type="text" id="accountId2">
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm4()" type="button" class="easyui-linkbutton">查询</button>
    </div>
    <div>

    </div>
</div>
<table id="table4"></table>
<script>
    function searchForm4(){
        $("#table4").datagrid('load',{
            accountNo:$('#accountId2').val()
        })
    }


    $("#table4").datagrid({
        multiSort:true,
        pageSize:10,
        pageList:[1,10,15,20,25,30,40,50],
        toolbar:'#toolbar4',
        fit:true,
        pagination:true,
        url:'accountHistory',
        columns:[[
            {field:'id',title:'序号',width:100,sortable:true},
            {field:'accountNo',title:'账户编号',width:100},
            {field:'userNo',title:'用户编号',width:100},
            {field:'username',title:'用户名',width:100},
            {field:'amount',title:'变动金额',width:100},
            {field:'fundDirection',title:'变动方向',width:100,formatter:function(value,row,index){
                switch (value){
                    case '1':
                        return '加款';
                        break;
                    case '2':
                        return '减款';
                        break;
                    default:
                        return '未知';
                        break;
                }
            }},
            {field:'balance',title:'余额',width:100},
            {field:'requestNo',title:'请求号',width:100},
            {field:'trxType',title:'业务类型',width:100},
            {field:'createTime',title:'创建时间',formatter:function(value,row,index){
                return moment(value).format('dddd,MMMM Do YYYY, h:mm:ss a');
            }}
        ]]
    });
</script>