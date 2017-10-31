<%--
  User: zhangpeng
  Date: 2017/10/24
  Time: 21:31
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="toolbar3">
    <div style="padding: 5px; background-color: #fff;">
        <label>商品编号：</label>
        <input class="easyui-textbox" type="text" id="merchantNo">
        <label>商户名称：</label>
        <input class="easyui-textbox" type="text" id="merchantName">
        <label>商户订单号：</label>
        <input class="easyui-textbox" type="text" id="merchantOrderNo">
        <label>状态：</label>
        <select id="status" class="easyui-combobox">
            <option value="0">请选择</option>
            <option value="1">交易成功</option>
            <option value="2">等待支付</option>
            <option value="3">订单已创建</option>
            <option value="4">交易失败</option>
            <option value="5">订单已取消</option>
        </select>
        <br/>
        <%--<label>下单开始日期:</label>
        <input  id="orderDate"  type= "text" class= "easyui-datebox" required ="required"> </input>--%>
        <%--       <input class="easyui-datetimebox" name="orderDate" id="orderDate"
                      data-options="required:true,showSeconds:false" value="3/4/2010 2:3" style="width:150px">--%>
        <%-- <label>下单结束日期:</label>
             <input  id="expireTime"  type= "text" class= "easyui-datebox" required ="required"> </input>
             <br/>--%>
        <label>支付方式：</label>
        <select id="payWayName" class="easyui-combobox">
            <option value="0">请选择</option>
            <option value="1">支付宝</option>
            <option value="2">微信</option>
        </select>
        <label>支付类型：</label>
        <select id="payTypeName" class="easyui-combobox">
            <option value="0">请选择</option>
            <option value="1">即时到账</option>
            <option value="2">H5支付</option>
            <option value="3">支付宝测试</option>
            <option value="4">扫码支付</option>
        </select>
        <label>资金流入类型：</label>
        <select id="fundIntoType" class="easyui-combobox">
            <option value="0">请选择</option>
            <option value="1">商家收款</option>
            <option value="2">平台收款</option>
        </select>
        <!--http://www.cnblogs.com/wisdomoon/p/3330856.html-->
        <!--注意：要加上type="button",默认行为是submit-->
        <button onclick="searchForm()" type="button" class="easyui-linkbutton">查询</button>
    </div>
    <div>
        <button onclick="add()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</button>
        <button onclick="edit()" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</button>
        <button onclick="remove()" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</button>
        <button onclick="down()" class="easyui-linkbutton" data-options="iconCls:'icon-down',plain:true">下架</button>
        <button onclick="up()" class="easyui-linkbutton" data-options="iconCls:'icon-up',plain:true">上架</button>
    </div>
</div>

<table id="sa"></table>

<script>
    function searchForm() {
        $('#sa').datagrid('reload', {
            merchantNo: $('#merchantNo').val(),
            merchantName: $('#merchantName').val(),
            merchantOrderNo: $('#merchantOrderNo').val(),
            //orderDate: $('#orderDate').val(),
            //expireTime: $('#expireTime').val(),
            payWayName: $('#payWayName').combobox('getValue'),
            status: $('#status').combobox('getValue'),

            payTypeName: $('#payTypeName').combobox('getValue'),
            fundIntoType: $('#fundIntoType').combobox('getValue')
        });
    }

    function add() {
        ttshop.addTabs('新增商品', 'item-add');
    }

    function edit() {
        console.log('edit');
    }

    function down() {
        console.log('down');
    }

    function up() {
        console.log('up');
    }

    function remove() {
        //获取选中的行
        var selectRows = $('#sa').datagrid('getSelections');
        //没有选中任何行
        if (selectRows.length == 0) {
            $.messager.alert('提示', '未选中记录', 'warning');
            return;
        }
        //选中至少一行记录
        $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
            if (r) {
                //点击了消息窗口上的确认按钮
                //将选中记录的编号写进一个数组中
                var ids = [];
                for (var i = 0; i < selectRows.length; i++) {
                    ids.push(selectRows[i].id);
                }
                //ajax提交数组给后台
                $.post(
                    //url:提交给后台的哪个动作去处理，只有第一个参数是必选的，其余的都是可选项
                    'items/batch',
                    //data:提交哪些数据给后台进行处理
                    {'ids[]': ids},
                    //function:处理后成功回调的函数
                    function (data) {
                        $('#sa').datagrid('reload');
                    },
                    //datatype:返回的数据类型
                    'json'
                );

            }
        });
    }

    //初始化数据表格
    $('#sa').datagrid({
        multiSort: true,
        pageSize: 20,
        pageList: [20, 40, 50],
        toolbar: '#toolbar2',
        fit: true,
        pagination: true,
        url: 'record',
        columns: [[
            {field: 'ck', checkbox: true},
            {field: 'id', title: '序号', width: 100, sortable: true},
            {field: 'merchantNo', title: '商家编号'},
            {field: 'merchantName', title: '商家名称'},
            {field: 'merchantOrderNo', title: '商户订单号'},
            {
                field: 'createTime', title: '创建时间', formatter: function (value, row, index) {
                return moment(value).format('dddd, MMMM Do YYYY, h:mm:ss a');
            }
            },
            {
                field: 'trxType', title: '交易业务类型', width: 100, formatter: function (value, row, index) {
                if (value == "1") {
                    return '消费';
                } else{
                    return '充值';
                }
            }
            },
            {
                field: 'payWayName', title: '支付方式', width: 100, formatter: function (value, row, index) {
                if (value == "1") {
                    return '支付宝';
                } else{
                    return '微信';
                }
            }
            },
            {
                field: 'payTypeName', title: '支付类型名称', width: 100, formatter: function (value, row, index) {
                if (value == "1") {
                    return '即时到账';
                } else if (value == "2") {
                    return 'H5支付';
                } else if (value == "3") {
                    return '支付宝测试';
                } else{
                    return '扫码支付';
                }
            }
            },
            {field: 'trxNo', title: '支付流水号'},
            {field: 'bank0rderNo', title: '银行订单号'},
            {field: 'orderAmount', title: '订单金额'},
            {
                field: 'status', title: '状态', width: 100, formatter: function (value, row, index) {
                if (value == "1") {
                    return '交易成功';
                } else  if(value == "2"){
                    return '等待支付';
                }else  if(value == "3"){
                    return '订单已创建';
                }else  if(value == "4"){
                    return '交易失败';
                }else{
                    return '订单已取消';
                }
            }
            },
            {
                field: 'paySuccessTime', title: '支付成功时间', formatter: function (value, row, index) {
                return moment(value).format('dddd, MMMM Do YYYY, h:mm:ss a');
            }
            },
            {field: 'version', title: '版本号', width: 100, sortable: true},
            {field: 'editor', title: '修改者'},
            {field: 'creater', title: '创建者'},
            {
                field: 'editTime', title: '最后修改时间', formatter: function (value, row, index) {
                return moment(value).format('dddd, MMMM Do YYYY, h:mm:ss a');
            }
            },
            {field: 'bankTrxNo', title: '银行流水号'},
            {field: 'payerUserNo', title: '付款人编号'},
            {field: 'payerName', title: '付款人名称'},
            {field: 'payerPayAmount', title: '付款方支付金额'},
            {field: 'payerFee', title: '付款方手续费'},
            {field: 'payerAccountType', title: '付款方账户类型(参考账户类型枚举:accounttypeenum)'},
            {field: 'receiverUserNo', title: '收款人编号'},
            {field: 'receiverName', title: '收款人名称'},
            {field: 'receiverPayAmount', title: '收款方支付金额'},
            {field: 'receiverFee', title: '收款方手续费'},
            {field: 'receiverAccountType', title: '收款方账户类型(参考账户类型枚举:accounttypeenum)'},
            {field: 'orderIp', title: '下单ip(客户端ip,从网关中获取)'},
            {field: 'orderRefererUrl', title: '从哪个页面链接过来的(可用于防诈骗)'},
            {field: 'platIncome', title: '平台收入'},
            {field: 'feeRate', title: '费率'},
            {field: 'platCost', title: '平台成本'},
            {field: 'platProfit', title: '平台利润'},
            {field: 'returnUrl', title: '页面回调通知url'},
            {field: 'notifyUrl', title: '后台异步通知url'},
            {field: 'payWayCode', title: '支付方式编号'},
            {field: 'completeTime', title: '完成时间'},
            {field: 'isRefund', title: '是否退款(100:是,101:否,默认值为:101)'},
            {field: 'refundTimes', title: '退款次数(默认值为:0)'},
            {field: 'successRefund_Amount', title: '成功退款总金额'},
            {field: 'orderFrom', title: '订单来源'},
            {field: 'payTypeCode', title: '支付类型编号'},
            {
                field: 'fundIntoType', title: '资金流入类型', width: 100, formatter: function (value, row, index) {
                if (value == "1") {
                    return '商家收款';
                } else {
                    return '平台收款';
                }
            }
            },
            {field: 'remark', title: '备注'},
            {field: 'bankReturnMsg', title: '银行返回信息'}

        ]]
    });

</script>
