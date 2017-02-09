<%@ include file="../common/IncludeTop.jsp" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix ="s" uri="/struts-tags"%>

<head>
	<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function(){
			console.log("function...");
			//console.log($("input[type='checkbox']").is(':checked'));
			
			$("#clear").click(function(){
				if($("input[type='checkbox']").is(':checked')){
					//console.log("checkbox is checked..");
					//所有的文本框都被清空
					$("input[type='text']").val("");
				}
			})
			
		})
		
	</script>

</head>




<div id="Catalog">

  <form action="addOrderAction"  method="post">
	<input type="hidden" name="orders.userid" value="<%=session.getAttribute("userid") %>">
	<input type="hidden" name="orders.totalprice" value="${totalprice }">
    <table>
      <tr>
      	<th colspan=2>付款详情</th>
      </tr>
      <tr>
      	<td>付款方式:</td>
      	<td>
          	<select name="orders.cardtype">
       			<option value="维萨信用卡">维萨信用卡</option>
        		<option value="万事达信用卡">万事达信用卡</option>
         		<option value="美国运通信用卡">美国运通信用卡</option>
      	  	</select>
      	</td>
 	 </tr>
 	 
  	<tr>
      <tr>
      	<td>信用卡号码:</td>
        <td><input type="text" name="orders.creditcard" value="9999 9999 9999"/></td>
      </tr>
      <tr>
      	<td>终止日期 (MM/YYYY):</td>
      	<td><input type="text" name="orders.exprdate" value="12/03" /></td>
      </tr>
      <tr>
      	<th colspan=2>账单地址</th>
      </tr>
	
	  <s:iterator value="accList" var="a">	
	      <tr>
	      	<td>姓名:</td>
	      	<td><input type="text" name="orders.billtofirstname" value="${a.firstname }" /></td>
	      </tr>
	      <tr>
	      	<td>地址1:</td>
	      	<td><input type="text" name="orders.billaddr1" size="40" value="${a.addr1 }" /></td>
	      </tr>
	      <tr>
	      	<td>地址2:</td>
	      	<td><input type="text" name="orders.billaddr2" size="40" value="${a.addr2 }" /></td>
	      </tr>
	      <tr>
	      	<td>城市: </td>
	      	<td><input type="text" name="orders.billcity" size="10" value="${a.city }" /></td>
	      </tr>
	      <tr>
	      	<td>区、县:</td>
	      	<td><input type="text" name="orders.billstate" size="4" value="${a.state }" /></td>
	      </tr>
	      <tr>
	      	<td>邮政编码:</td>
	      	<td><input type="text" name="orders.billzip" value="${a.zip }" /></td>
	      </tr>
	      <tr>
	      	<td>国籍: </td>
	      	<td><input type="text" name="orders.billcountry" size="15" value="${a.country }" /></td>
	      </tr>

	  </s:iterator>

      <tr>
      	<td colspan=2><input type="checkbox" id="clear"/> 不同的送货地址...</td>
      </tr>

    </table>

    <input type="submit" name="submit" value="继续">

  </form>

</div>

<%@ include file="../common/IncludeBottom.jsp" %>