<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="Catalog">

<%@ taglib prefix ="s" uri="/struts-tags"%>

<h2>我的订单</h2>

<table>
  <tr>
  	<th>订单编号</th>  
  	<th>日期</th>  
  	<th>总金额</th></tr>


	<s:iterator value="myorderList" var="o">
	    <tr>		
	      <td><a href="findOnesOrderAction.action?orders.orderid=${o.orderid }">${o.orderid }</a></td>
	      <td>${o.date }</td>
	      <td>$${o.totalprice }</td>
	    </tr>
  	</s:iterator>
</table>


  <a href="findMyOrdersAction.action?userid=<%=session.getAttribute("userid") %>&currentpages=${currentpages-1 }" class="Button">&lt;&lt; 上一页</a>

  <a href="findMyOrdersAction.action?userid=<%=session.getAttribute("userid") %>&currentpages=${currentpages+1 }" Class="Button">下一页 &gt;&gt;</a>

</div>
<%@ include file="../common/IncludeBottom.jsp" %>


