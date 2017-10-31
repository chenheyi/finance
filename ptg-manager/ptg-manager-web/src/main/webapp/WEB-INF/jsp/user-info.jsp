<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div id="toolbar9">
    <div style="padding: 5px; background-color: #fff;">
        <label>用户名称：</label>
        <input class="easyui-textbox" type="text" id="title">

        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">搜索</button>
    </div>
   <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>

   </div>
</div>

<table id="dg5"></table>

<script>
    function searchForm(){
        $('#dg5').datagrid('load',{
            title:$('#title').val()
        });
    }
    function  add() {
        ttshop.addTabs('新增用户','user-add');
    }


    //初始化数据表格
    $('#dg5').datagrid({
        multiSort:true,
        pageSize:20,
        pageList:[20,40,50],
        toolbar:'#toolbar',
        fit:true,
        pagination:true,
        url:'users',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'序号',width:100,sortable:true},
            {field:'userNo',title:'用户编号',width:100,sortable:true},
            {field:'userName',title:'用户名称',width:100},
            {field:'accountNo',title:'账户编号'},
            {field:'status',title:'状态',formatter:function(value,row,index){
//                console.group();
//                console.log(value);
//                console.log(row);
//                console.log(index);
//                console.groupEnd();
                switch (value){
                    case "1":
                        return '正常';
                        break;
                    case "2":
                        return '下架';
                        break;
                    case "3":
                        return '删除';
                        break;
                    default:
                        return '未知';
                        break;
                }
            }},
            {field:'createTime',title:'创建时间',formatter:function(value,row,index){
                return moment(value).format('dddd, MMMM Do YYYY, h:mm:ss a');
            }}
        ]]
    });

</script>