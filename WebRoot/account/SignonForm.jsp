<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/IncludeTop.jsp" %>

<html>
	<head>
		<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
		
		<script type="text/javascript">
			$(function(){
				//检验用户名是否为空
				$("#username").bind({
					"focus":function(){
						$("#userMsg").show();
					},
					"blur":function(){
						$("#userMsg").hide();
					}
				});
			
				//检验密码是否为空
				$("#pwd").bind({
					"focus":function(){
						$("#pwdMsg").show();
					},
					"blur":function(){
						$("#pwdMsg").hide();
					}
				});
				
				
				$("#submit").click(function(){
					var params = $("#form1").serialize();
					alert(params);
		
					$.ajax({
					url:"SignOnAction.action",
					data:params,
					dataType:"text",
					success:function(data){
						console.log(data);
						if(data == "true"){
							location.href="catalog/Main.jsp?userid="+$("#username").val();
						}else{
							$("#errMsg").show();
						}

					},
					error:function(){
						alert("出错了");
					}
				});//$("ajax")
				
				}); //$("submit")
				
			})//$()S
		
		
		</script>
	</head>

	<body>
		<div id="Catalog">
			<form method="POST" id="form1">
			
			    <p>请输入您的用户名和密码.</p>
			    <p>
			     用户名:<input type="text" id="username" name="signon.userid" value="j2ee"/>
			      <span id="userMsg" style="display: none;color: red">用户名不能为空</span>
			      <br> 
			     密&nbsp; 码:<input type="password" id="pwd" name="signon.password" value="j2ee"/>
			    <span id="pwdMsg" style="display: none;color: red">密码不能为空</span>
			    </p>
			    <input type="button" id="submit" name="submit" value="登录"/>
				 <span id="errMsg" style="display: none;color: red">用户名或密码错误</span>
			</form>
			
				需要用户名和密码？
			    <a href="<%=basePath %>/account/NewAccountForm.jsp">立即注册!</a>
			
			</div>
			
			<%@ include file="../common/IncludeBottom.jsp" %>
	
	</body>
</html>

