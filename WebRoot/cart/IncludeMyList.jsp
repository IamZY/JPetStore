<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix ="s" uri="/struts-tags"%>

  <p>
   宠物的最爱
    <br/>
     为你最喜欢的宠物店在这里
  </p>
  <s:iterator value="#session.cateMap">
  	<ul>
      	<li><a href="findItemAction.action?productid=<s:property value="key"/>&name=<s:property value="value.name"/>&category=<s:property value="value.category"/>"><s:property value="value.name"/></a>(<s:property value="key"/>)</li>
  	</ul>
  </s:iterator>	
  <p>
   
      <a href="javascript:void(0)" class="Button">&lt;&lt;上一页</a>
  
    
        <a href="javascript:void(0)" class="Button">下一页 &gt;&gt;</a>
  
  </p>




