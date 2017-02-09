<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<%@ taglib prefix ="s" uri="/struts-tags"%>

<div id="Catalog">
<div id="BackLink">

  <a href="findCategoryAction.action?category=${category }">
  返回 ${category }</a>

</div>
  <h2>${name }</h2>

  <table>
    <tr>
    	<th>商品编号</th> 
     	<th>产品编号</th> 
      	<th>产品描述</th> 
       	<th>定价</th> 
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="itemList" var="i">
	    <tr>
	        <td><a href="findGoodsAction.action?itemid=${i.itemid }&name=${name }&productid=${i.productid }&category=${category }">${i.itemid }</a></td>
	        <td>${i.productid }</td>
	        <td>${i.attr1 }${name }</td>
	        <td>${i.listprice }</td>
	        <td><a href="addCartAction.action?userid=<%=session.getAttribute("userid") %>&itemid=${i.itemid }&category=${category }" class="Button"> 添加到购物车</a></td>
	    </tr>
   </s:iterator>
    <tr>
    	<td>
    		<a class="Button" href="findItemAction.action?category=${category }&productid=${productid }&name=${name }&currentpages=${currentpages-1 }">&lt;&lt; 上一页</a>
        	<a class="Button" href="findItemAction.action?category=${category }&productid=${productid }&name=${name }&currentpages=${currentpages+1 }">下一页 &gt;&gt;</a>
    	</td>
   </tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





