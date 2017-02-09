<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ include file="../common/IncludeTop.jsp" %>

<head>
	<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	
	</script>

</head>

<div id="Welcome" style="background:white">
  <div id="WelcomeContent" >
   
       
        <%
        	String userid = (String)session.getAttribute("userid");
        	System.out.println(userid);
        	if(userid != null){
        %>
        	 欢迎 !&nbsp; <%=session.getAttribute("userid") %>
        	[<a href="exitAction.action?userid=<%=session.getAttribute("userid") %>">注销</a>]     
        <% 	
        	}else{
        %>	
        	欢迎 !&nbsp;
        <% 	
        	}
         %>
        
        <!-- 
    	<span id="showName" style="display: none"><%=session.getAttribute("userid") %></span>	
  	 	-->
  </div>
</div>
<div id="Main">


  <div id="Sidebar">
    <div id="SidebarContent">
  		<a href="findCategoryAction.action?category=FISH">
        <img src="<%=basePath%>/images/fish_icon.gif"/></a>
      <br>
      海水，淡水
      <br>
   		<a href="findCategoryAction.action?category=DOGS">
        <img src="<%=basePath%>/images/dogs_icon.gif"/></a>
      <br>
      狗
      <br>
        <a href="findCategoryAction.action?category=CATS">
        <img src="<%=basePath%>/images/cats_icon.gif"/></a>
      <br>
     猫
      <br>
      	<a href="findCategoryAction.action?category=REPTILES">
        <img src="<%=basePath%>/images/reptiles_icon.gif"/></a>
      <br/>
   	 蜥蜴，龟，蛇
      <br>
        <a href="findCategoryAction.action?category=BIRDS">
        <img src="<%=basePath%>/images/birds_icon.gif"/></a>
      <br>
     鸟
    </div>
  </div>

  <div id="MainImage">
    <div id="MainImageContent">
      <map name="estoremap"><area alt="Birds" coords="72,2,280,250" href="findCategoryAction.action?category=BIRDS" shape="RECT"/>
        <area alt="Fish" coords="2,180,72,250" href="findCategoryAction.action?category=FISH"/>
        <area alt="Dogs" coords="60,250,130,320" href="findCategoryAction.action?category=DOGS" shape="RECT"/>
        <area alt="Reptiles" coords="140,270,210,340" href="findCategoryAction.action?category=REPTILES"
              shape="RECT"/>
        <area alt="Cats" coords="225,240,295,310" href="findCategoryAction.action?category=CATS" shape="RECT"/>
        <area alt="Birds" coords="280,180,350,250" href="findCategoryAction.action?category=BIRDS" shape="RECT"/>
      </map>
      <img height="355" src="<%=basePath%>/images/splash.gif" align="center" usemap="#estoremap" width="350"/>
    </div>
  </div>

  <div id="Separator">&nbsp;</div>
</div>


<%@ include file="../common/IncludeBottom.jsp" %>

