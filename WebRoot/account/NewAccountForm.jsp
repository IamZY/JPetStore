<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="Catalog">

  <form action="AccountAction" method="post">

    <h3>账户信息</h3>

    <table>
      <tr>
        <td>账户:</td>
        <td><input type="text" name="signon.userid"/></td>
      </tr>
      <tr>
      	<td>新密码:</td>
      	<td><input type="password" name="signon.password"/></td>
      </tr>
    <tr>
        <td>重复密码:</td>
        <td><input type="password"/></td>
    </tr>
    
    </table>

    <%@ include file="IncludeAccountFields.jsp" %>

    <input type="submit" name="submit" value="创建账户" class="Button" />

  </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>