<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<bean:define id="product" name="catalogBean" property="product"/>
<bean:define id="item" name="catalogBean" property="item"/>

<%@ taglib prefix ="s" uri="/struts-tags"%>

<div id="Catalog">
<div id="BackLink">
<a href="findItemAction.action?productid=${productid }&name=${name }&category=${category }">返回到${name }</a>

</div>
  <table>
	    <tr>
	      	<td>${desn }</td>
	    </tr>
  	<s:iterator value="goodsList" var="g">
	    <tr>
	      	<td><b>${g.itemid }</b></td>
	    </tr>
	    <tr>
	    	<td><b><font size="4">${g.attr1 }${name }</font></b></td>
	    </tr>
	    <tr>
	    	<td>${name }</td>
	    </tr>
	    <tr>
	    	<td>${qty }库存</td>
	    </tr>
	    <tr>
	    	<td>$ ${g.listprice }</td>
	    </tr>
	    <tr>
	    <td><a class="Button" href="addCartAction.action?userid=<%=session.getAttribute("userid") %>&itemid=${g.itemid }">添加到购物车</a></td>
	    </tr>
    </s:iterator>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>



