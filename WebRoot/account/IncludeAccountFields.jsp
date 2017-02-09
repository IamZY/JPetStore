

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<h3>客户基本信息</h3>

<table>
  	<tr>
    	<td>姓名:</td>
    	<td><input type=text name="account.firstname" value="${account.firstname }"/></td>
  	</tr>
	<tr>
  		<td>邮箱:</td>
  		<td><input type=text  size="40" name="account.email" value="${account.email }"></td>
	</tr>
	<tr>
  		<td>联系电话:</td>
  		<td><input type=text  size="40" name="account.phone" value="${account.phone }"/></td>
	</tr>
	<tr>
  	  	<td>地址1:</td>
  	  	<td><input type=text size="40"  name="account.addr1" value="${account.addr1 }"/></td>
	</tr>
	<tr>
	  	<td>地址2:</td>
	  	<td><input type=text  size="40" name="account.addr2" value="${account.addr2 }"></td>
	</tr>
	<tr>
	  	<td>城市:</td>
	  	<td><input type=text  name="account.city" value="${account.city }"/></td>
	</tr>
	<tr>
		<td>区、县</td>
		<td><input type=text size="4"  name="account.state" value="${account.state }"/></td>
	</tr>
	<tr>
	  	<td>邮政编码:</td>
	  	<td><input type=text size="10" name="account.zip" value="${account.zip }"/></td>
	</tr>
	<tr>
	  	<td>国籍:</td>
	  	<td><input type=text  size="15" name="account.country" value="${account.country }"/></td>
	</tr>
</table>

<h3>个人喜好</h3>

<table>
  <tr>
    <td>喜爱的语言:</td>
    <td>
      <select name="profile.langpref">
       	<option value="ENGLISH">ENGLISH</option>
        <option value="CHINESE">CHINESE</option>
      </select>
    </td>
  </tr><tr>
  <td>喜欢的动物类别:</td>
  <td>
     <select name="profile.favcategory">
         <option value="CATS">CATS</option>
         <option value="DOGS">DOGS</option>
         <option value="FISH">FISH</option>
         <option value="REPTILES">REPTILES</option>
         <option value="BIRDS">BIRDS</option>
     </select>
  </td>
</tr>
<tr>
  <td>根据喜爱动物类别为您推荐</td>
  <td><input type="checkbox" name="profile.mylistopt" value="1" /></td>
</tr>
<tr>
  <td>是否植入广告</td>
  <td><input type="checkbox" name="profile.banneropt" value="1"/></td>
</tr>

</table>
