<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<%@ taglib prefix ="s" uri="/struts-tags"%>

<div id="Catalog">
<div id="BackLink">
<a href="<%=basePath %>/cart/Cart.jsp">返回到购物车</a>
</div>

  <table>
    <tr>
      <td>
        <h2>核对信息</h2>

        <table>

          <tr>
            <td><b>商品编号</b></td> 
            <td><b>产品编号</b></td> 
            <td><b>产品描述</b></td> 
            <td><b>In Stock?</b></td>
            <td><b>产品数量</b></td>  
            <td><b>定价</b></td> 
            <td><b>总成本</b></td>
          </tr>
          
            <s:iterator var="c" value="cartList">
	        <tr>
	          <td><a href="findGoodsAction.action?itemid=${c.itemid }&name=${c.name }&productid=${c.productid }&category=${c.category }">${c.itemid }</a></td>
	          <td>${c.productid }</td>
	          <td>${c.attr }${c.name }</td>
	          <td>有</td>
	          <td><input type="text" name="quantity" size="5" value="${c.quantity }"/></td>
	          <td>$${c.price }</td>
	          <td>$${c.totalprice }</td>
	        </tr>
		</s:iterator> 
        
          <tr>
            <td colspan="7">
              总金额:$${sum }
            </td>
          </tr>
        </table>
        
          <a href="showAccountAction.action?userid=<%=session.getAttribute("userid") %>&itemid=${i.itemid }&category=${category }&currentpages=${currentpages-1 }" class="Button">&lt;&lt; 上一页</a>
       
          <a href="showAccountAction.action?userid=<%=session.getAttribute("userid") %>&itemid=${i.itemid }&category=${category }&currentpages=${currentpages+1 }" class="Button">下一页&gt;&gt;</a>
        
        <a class="Button" href="showOrderAction.action?userid=<%=session.getAttribute("userid") %>&totalprice=${totalprice }">继续</a>
      </td>
  

    </tr>
  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>





