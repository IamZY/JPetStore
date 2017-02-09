<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="Catalog">

<form method="post" action="updateAccAction">

    <h3>账户信息</h3>

    <table>
      <tr>
        <td>账户:</td>
        <td><input type="text" name="signon.userid" value="${signon.userid }" readonly="readonly"></td>
      </tr>
      <tr>
      	<td>新密码:</td>
      	<td><input type="password" name="signon.password" value="${signon.password }"></td>
      </tr>
      <tr>
      	<td>重复密码:</td>
      	<td><input  type="password"></td>
      </tr>
    </table>
    <%@ include file="IncludeAccountFields.jsp" %>

    <input type="submit" name="submit" value="保存账户资料"/>



</form>
  <a href="findMyOrdersAction.action?userid=<%=session.getAttribute("userid") %>">我的订单</a>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


