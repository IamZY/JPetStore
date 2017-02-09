<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<html>

<body>

<div id="Footer">

  <div id="PoweredBy">
    <a href="http://ibatis.apache.org"><img src="./images/poweredby.gif"/></a>
  </div>

	<%
		String favcategory = (String)session.getAttribute("favcategory");
		
		if(favcategory != null){
	%>	
		<div id="Banner">
   			<%=session.getAttribute("favcategory") %>
  		</div>
	<% 	
		}else{
	%>	
		<div id="Banner">
 
  		</div>
	<% 	
		}
	 %>



  

</div>

</body>
</html>