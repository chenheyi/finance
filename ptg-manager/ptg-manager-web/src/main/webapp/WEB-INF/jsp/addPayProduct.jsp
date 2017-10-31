<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="支付产品详情" data-options="fit:true">
    <form class="PayProductForm" id="PayProductForm" name="PayProductForm" method="post">
        <table style="width:100%;" >

            <tr>
                <td class="label">序号：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="id" name="id"
                           data-options="required:true" style="width: 10%;">
                </td>
            </tr>
          <%--  <tr>
                <td class="label">创建时间：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="createTime" name="createTime"
                           data-options="required:true" style="width: 30%;">
                </td>
            </tr>--%>
            <tr>
                <td class="label">是否上架：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="status" name="status"
                           data-options="required:true" style="width: 10%;">
                </td>
            </tr>

            <tr>
                <td class="label">支付产品编号：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="productCode" name="productCode"
                           data-options="required:true">
                </td>
            </tr>
            <tr>
                <td class="label">支付产品名称：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="productName" name="productName"
                           data-options="required:true">
                </td>
            </tr>

            <tr>
                <td colspan="2"  style="padding-left: 200px">
                    <button onclick="submitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="clearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>

        </table>
    </form>
</div>



<script>
    //用来提交表单的操作
    function submitForm() {
        $('#PayProductForm').form('submit', {
            //提交给后台处理的URL地址
            url: 'addPayProduction',
            //提交前的动作，提交前会进行表单中的数据进行校验，如果校验不通过，返回false阻止提交，否则提交成功
            //校验全写下onsubmit方法中，由于框架的好处，form('validate')这个组件会对表单自动进行校验
            onSubmit: function () {
                //this:DOM对象
                //$(this)：jquery对象
                return $(this).form('validate');
            },
            //提交处理成功后的动作
            success: function (data) {
                console.log('success');
                if(data > 0){
                    $.messager.alert('消息','保存成功', 'info');
                    ttshop.addTabs('支付产品信息', 'payProduct-info');
                }
            }
        });
    }
</script>