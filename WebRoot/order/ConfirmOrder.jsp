<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<div id="Catalog">

<div id="BackLink">
  <a href="<%=basePath%>catalog/Main.jsp">返回主菜单</a>
</div>

请确认以下信息，然后按"继续"...

  <table>
    <tr><th align="center" colspan="2">
      <font size="4"><b>订单</b></font>
      <br/><font size="3"><b>2013/02/21 11:13:31</b></font>
    </th></tr>

    <tr><th colspan="2">
    账单地址
    </th></tr>
    <tr><td>
    姓名:</td><td>	ABC 
    </td></tr>
    <tr><td>
      姓:</td><td>	XYX 
    </td></tr>
    <tr><td>
      地址 1:</td><td>901 San Antonio Road 
    </td></tr>
    <tr><td>
      地址 2:</td><td>MS UCUP02-206    </td></tr>
    <tr><td>
      城市: </td><td>	Palo Alto 
    </td></tr>
    <tr><td>
      州 、邦:</td><td>CA 
    </td></tr>
    <tr><td>
     邮政编号:</td><td>94303 
    </td></tr>
    <tr><td>
      国家: </td><td>USA 
    </td></tr>
    <tr><th colspan="2">
  寄运地址
    </th></tr><tr><td>
    姓名:</td><td>ABC 
  </td></tr>
    <tr><td>
      姓:</td><td>XYX
    </td></tr>
    <tr><td>
     地址1:</td><td>901 San Antonio Road 
    </td></tr>
    <tr><td>
      地址 2:</td><td>MS UCUP02-206 
    </td></tr>
    <tr><td>
   城市: </td><td>Palo Alto 
    </td></tr>
    <tr><td>
      州、邦:</td><td>CA
    </td></tr>
    <tr><td>
     邮政编码:</td><td>94303 
    </td></tr>
    <tr><td>
     国家: </td><td>USA 
    </td></tr>

  </table>


  <a href="<%=basePath %>/order/ConfirmOrder.jsp">确认</a>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





