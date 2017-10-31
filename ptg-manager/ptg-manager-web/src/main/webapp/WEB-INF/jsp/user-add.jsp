<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="easyui-panel" title="商品详情" data-options="fit:true">
    <form class="itemForm" id="itemAddForm" name="itemAddForm" method="post">
        <table style="width:100%;">
            <tr>
                <td class="label">用户编号：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="userNo" name="userNo"
                           style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">用户名称：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="userName" name="userName"
                           style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">账户编号：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="accountNo" name="accountNo"
                           style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">电话：</td>
                <td>
                    <input class="easyui-textbox" type="text" id="mobile" name="mobile"
                           style="width:200px;">
                </td>
            </tr>
            <tr>
                <td class="label">密码：</td>
                <td>
                    <input class="easyui-textbox" type="password" id="password" name="password"
                           >
                </td>
            </tr>
            <tr>
                <td class="label">支付密码：</td>
                <td>
                    <input class="easyui-textbox" type="password" id="payPwd" name="payPwd"
                           >
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button onclick="submitForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-ok'">保存
                    </button>
                    <button onclick="clearForm()" class="easyui-linkbutton" type="button"
                            data-options="iconCls:'icon-undo'">重置
                    </button>
                </td>
            </tr>
        </table>
        <input name="paramData" id="paramData" style="display:none;">
    </form>
</div>

<script>



    //用来提交表单的操作
    function submitForm() {
        $('#itemAddForm').form('submit', {
            //提交给后台处理的URL地址
            url: 'user',
            //提交前的动作，如果返回false阻止提交
          //  onSubmit: function () {
                //给商品价格隐藏域设值

                //this:DOM对象
                //$(this)：jquery对象
          //      return $(this).form('validate');
         //   },
            //提交处理成功后的动作
            success: function (data) {
                console.log('success');
                if(data>0){
                    $.messager.alert('消息','保存成功','info');
                    ttshop.addTabs('用户信息','user-info');
              }
            }
        })
    }
</script>