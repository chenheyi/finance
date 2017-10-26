<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>


<div id="toolbar">
    <div style="padding: 5px; background-color: #fff;">
        <label>支付产品名称：</label>
        <input class="easyui-textbox" type="text" id="title">
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">查询</button>
    </div>

    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加支付产品</button>
        <%--<button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>--%>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>




<table id="dg"></table>


<script>
    function searchForm(){
        $('#dg').datagrid('load',{
            title: $('#title').val()
        });
    }


    function  add() {
        ttshop.addTabs('新增商品','item-add');
    }


    function  up() {
        //获取选中的行
        var selectRows = $('#dg').datagrid('getSelections');
        //没有选中任何行
        if(selectRows.length == 0){
            $.messager.alert('提示','未选中记录','warning');
            return;
        }
        //选中至少一行记录
        $.messager.confirm('确认','您确认上架？',function(r){
            if (r){
                //点击了消息窗口上的确认按钮
                //将选中记录的序号写进一个数组中
                var ids = [];
                for(var i=0;i<selectRows.length;i++){
                    ids.push(selectRows[i].id);
                }
                //ajax提交数组给后台
                $.post(
                    //url:提交给后台的哪个动作去处理，只有第一个参数是必选的，其余的都是可选项
                    'upProducts/batch',
                    //data:提交哪些数据给后台进行处理
                    {'ids[]':ids},
                    //function:处理后成功回调的函数
                    function(data){
                        $('#dg').datagrid('reload');
                    },
                    //datatype:返回的数据类型
                    'json'
                );

            }
        });
    }
    function  down() {
        //获取选中的行
        var selectRows = $('#dg').datagrid('getSelections');
        //没有选中任何行
        if(selectRows.length == 0){
            $.messager.alert('提示','未选中记录','warning');
            return;
        }
        //选中至少一行记录
        $.messager.confirm('确认','您确认想要下架？',function(r){
            if (r){
                //点击了消息窗口上的确认按钮
                //将选中记录的序号写进一个数组中
                var ids = [];
                for(var i=0;i<selectRows.length;i++){
                    ids.push(selectRows[i].id);
                }
                //ajax提交数组给后台
                $.post(
                    //url:提交给后台的哪个动作去处理，只有第一个参数是必选的，其余的都是可选项
                    'downProducts/batch',
                    //data:提交哪些数据给后台进行处理
                    {'ids[]':ids},
                    //function:处理后成功回调的函数
                    function(data){
                        $('#dg').datagrid('reload');
                    },
                    //datatype:返回的数据类型
                    'json'
                );

            }
        });
    }

    $('#dg').datagrid({
        fit:true,
        pagination:true,
        pageList:[2,10,20,30],
        toolbar:'#toolbar',
        url:'productInfo',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'序号',width:100},
            {field:'productCode',title:'支付产品编号',width:200},
            {field:'productName',title:'支付产品名称',width:200},
            {field:'status',title:'是否上架',width:200},
            {field:'createTime',title:'创建时间',formatter:function(value,row,index){
                return moment(value).format('dddd, MMMM Do YYYY, h:mm:ss a');
            }},

           { field: 'operation', title: '操作', width: 600, formatter: function (value, rowData, rowIndex) {
                return "<a href='pay_way'>查看支付方式</a>";
            }}
        ]]
    });

</script>