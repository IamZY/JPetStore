<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%@ include file="../common/IncludeTop.jsp" %>

<%@ taglib prefix ="s" uri="/struts-tags"%>


<div id="Catalog">

<div id="BackLink" >
  <a href="<%=basePath%>catalog/Main.jsp?userid=<%=session.getAttribute("userid") %>">返回主菜单</a>
</div>
  <div id="Cart">

    <h2>购物车</h2>
    <form action="" method="post">
      <table>
        <tr>
          <th><b>商品编号</b></th> 
          <th><b>产品编号</b></th>
          <th><b>产品描述</b></th> 
          <th><b>有库存?</b></th>
          <th><b>产品数量</b></th> 
          <th><b>定价</b></th>
          <th><b>总成本</b></th> 
          <th>&nbsp;</th>
        </tr>
        
        <%
        	List list = (List)request.getAttribute("cartList");
        	
        	if(list == null){
        	
        %>
        <tr>
        	<td colspan="8"><b>你的购物车是空的.</b></td>
        </tr>
        <%	
        	}
         %>
        
   		<s:iterator var="c" value="cartList">
	        <tr>
	          <td><a href="findGoodsAction.action?itemid=${c.itemid }&name=${c.name }&productid=${c.productid }&category=${c.category }">${c.itemid }</a></td>
	          <td>${c.productid }</td>
	          <td>${c.attr }${c.name }</td>
	          <td>有</td>
	          <td><input type="text" name="quantity" size="5" value="${c.quantity }"/></td>
	          <td>$${c.price }</td>
	          <td>$${c.totalprice }</td>
	          <td><a Class="Button" href="delCartAction.action?userid=<%=session.getAttribute("userid") %>&itemid=${c.itemid }&quantity=${c.quantity } ">取消</a></td>
	        </tr>
		</s:iterator>      
      	<tr>
	        <td colspan="7">
	          总金额:${sum } 
	          <input type="button" name="update" value="更新购物车" class="Button" />
	        </td>
	        <td>&nbsp;</td>
      	</tr>
      </table>
      
        <a class="Button" href="findCartAction.action?userid=<%=session.getAttribute("userid") %>&itemid=${i.itemid }&category=${category }&currentpages=${currentpages-1 }">&lt;&lt; 上一页</a>
      
      
        <a class="Button" href="findCartAction.action?userid=<%=session.getAttribute("userid") %>&itemid=${i.itemid }&category=${category }&currentpages=${currentpages+1 }">下一页 &gt;&gt;</a>


    </form>

  <a class="Button" href="showAccountAction?userid=<%=session.getAttribute("userid") %> " >付款</a>


  </div>
    <div id="MyList" style="margin-top:10px;">
    <%@ include file="IncludeMyList.jsp" %>
    </div>
  <div id="Separator">&nbsp;</div>

</div>


<%@ include file="../common/IncludeBottom.jsp" %>



