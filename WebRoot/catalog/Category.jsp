<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<%@ taglib prefix ="s" uri="/struts-tags"%>

<div id="Catalog">

<div id="BackLink">

  <a href="<%=basePath%>catalog/Main.jsp?userid=<%=session.getAttribute("userid") %>">返回主菜单</a>

</div>
  <h2>${category }</h2>
	
  <table>
    <tr>
    	<th>产品编号</th> 
    	<th>产品名称</th>
    </tr>
    <s:iterator value="proList" var="p">
	   	<tr>
	   		<td><a href="findItemAction.action?productid=${p.productid }&name=${p.name }&category=${category }">${p.productid }</a></td>
	   		<td>${p.name }</td>
	   	</tr>
	</s:iterator>   	
   	<tr>
   		<td> 
        	<a class="Button" href="findCategoryAction.action?category=${category }&currentpages=${currentpages-1 }">&lt;&lt;上一页</a>
        	<a class="Button" href="findCategoryAction.action?category=${category }&currentpages=${currentpages+1 }">下一页&gt;&gt;</a>
    	</td>
    </tr>
    
  </table>
  

</div>

<%@ include file="../common/IncludeBottom.jsp" %>


