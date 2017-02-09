<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>





<div id="Catalog">
<div id="BackLink">

  <a href="<%=basePath %>/catalog/Main.jsp">返回主菜单</a>

</div>
  <table>
    <tr><th>&nbsp;</th>  <th>产品编号</th>  <th>产品名称</th></tr>

      <tr>
        <td> <image src="<%=basePath %>/images/dog2.gif">
        <a href="<%=basePath %>/catalog/Product.jsp">Friendly dog from England</a></td>
        <td><a href="<%=basePath %>/catalog/Product.jsp"><b>   K9-BD-01</b></a></td>
        <td>Bulldog</td>
      </tr>

    <tr>
      <td>
       
          <a href="">&lt;&lt; 上一页</a>
      
          <a href="">下一页 &gt;&gt;</a>
   
      </td>
    </tr>

  </table>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>




