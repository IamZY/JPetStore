<%@ include file="../common/IncludeTop.jsp" %>
  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix ="s" uri="/struts-tags"%>


<div id="Catalog">
<div id="BackLink">
  <a href="<%=basePath%>catalog/Main.jsp?userid=<%=session.getAttribute("userid") %>">返回主菜单</a>
</div>
<table>
	<tr>
		<th align="center" colspan="2">订单号${orders.orderid } ${orders.orderdate }</th>
	</tr>
	<tr>
		<th colspan="2">付款详情</th>
	</tr>
	<tr>
		<td>信用卡类型:</td>
		<td>${orders.cardtype }</td>
	</tr>
	<tr>
		<td>信用卡号码:</td>
		<td>${orders.creditcard }</td>
	</tr>
	<tr>
		<td>有效日期 (MM/YYYY):</td>
		<td>${orders.exprdate }</td>
	</tr>
	<tr>
		<th colspan="2">账单地址</th>
	</tr>
	<tr>
		<td>姓名:</td>
		<td>${orders.billtofirstname }</td>
	</tr>
	
	<tr>
		<td>地址 1:</td>
		<td>${orders.billaddr1 }</td>
	</tr>
	<tr>
		<td>地址 2:</td>
		<td>${orders.billaddr2 }</td>
	</tr>
	<tr>
		<td>城市: </td>
		<td>${orders.billcity }</td>
	</tr>
	<tr>
		<td>区、县:</td>
		<td>${orders.billstate }</td>
	</tr>
	<tr>
		<td>邮政编码:</td>
		<td>${orders.billzip } </td>
	</tr>
	<tr>
		<td>国籍: </td>
		<td>${orders.billcountry }</td>
	</tr>
	<tr>
		<th colspan="2">收货地址</th>
	</tr>
	<tr>
		<td>姓名:</td>
		<td>${orders.shiptofirstname }</td>
	</tr>
	<tr>
		<td>地址1:</td>
		<td>${orders.shipaddr1 }</td>
	</tr>
	<tr>
		<td>地址2:</td>
		<td>${orders.shipaddr2 }</td>
	</tr>
	<tr>
		<td>城市: </td>
		<td>${orders.shipcity }</td>
	</tr>
	<tr>
		<td>区、县:</td>
		<td>${orders.shipstate }</td>
	</tr>
	<tr>
		<td>邮政编码:</td>
		<td>${orders.shipzip }</td>
	</tr>
	<tr>
		<td>国籍: </td>
		<td>${orders.shipcountry }</td>
	</tr>
	<tr>
		<td>邮政公司: </td>
		<td>${orders.courier }</td>
	</tr>
	<tr>
		<td colspan="2">状态:已付款</td>
	</tr>
	
	<tr>
		<td colspan="2">
	<table>
	    <tr>
	      <th>商品编号</th>
	      <th>产品描述</th>
	      <th>数量</th>
	      <th>价格</th>
	      <th>总金额</th>
	    </tr>
	   
	   <s:iterator value="myCartList" var="m">
	      <tr>
	        <td>${m.itemid }</td>
	        <td>${m.attr }${m.name }</td>
	        <td>${m.quantity }</td>
	        <td>$${m.price }</td>
	        <td>$${m.totalprice }</td>
	      </tr>
	   </s:iterator>
	   
	    <tr>
	      <th colspan="5">总金额: ${orders.totalprice }</th>
	    </tr>
	  </table>
	</td>
	
	</tr>

</table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>



