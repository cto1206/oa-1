<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<form action="addresslist.do" method="post" onsubmit="return iframeCallback(this,dialogAjaxDone);">

<input type="hidden" name="method" value="update">
<input type="hidden" name="id" value="${addressBook.id }">
<input type="hidden" name="userId" value="${login.id}">

<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
	<p>
		<label>����</label>
		<input type="hidden" name="UseFreq" value="">
		<input class="required valid" size="28" type="text" name="name" value="${addressBook.name}">
	</p>
	<p>
		<label>�����ʼ�</label>
		<input type="hidden" name="USEREMAILNAME" value="">
		<input class="required valid" size="28" type="text" name="email" value="${addressBook.email}">
	</p>
	<p>
		<label>�ֻ�����</label>
		<input type="text" size="28" name="mobilePhone" value="${addressBook.mobilePhone}">
	</p>
	<p>
		<label>�̶��绰</label>
		<input type="text" size="28" name="phs" value="${addressBook.phs}">
	</p>
	<p>
		<label>����</label>
		<input type="text" size="28" name="nickName" value="${addressBook.nickName}">
	</p>
	<p>
		<label>����</label>
		<input type="text" class="date" size="28" name="birthday" value="<fmt:formatDate value="${addressBook.birthday}" pattern="yyyy-MM-dd"/>"><a class="inputDateButton" href="javascript:;">ѡ��</a>
	</p>
	<p>
		<label>��ͥסַ</label>
		<input type="text" size="28" name="street" value="${addressBook.street}">
	</p>
	<p>
		<label>��˾����</label>
		<input type="text" size="28" name="company" value="${addressBook.company}">
	</p>
	<p>
		<label>��ע</label>
		<input type="text" size="28" name="notes" value="${addressBook.notes}">
	</p>
</div>
<div class="formBar">
	<ul>
		<li>
			<div class="buttonActive">
				<div class="buttonContent">
					<button type="submit">�ύ</button>
				</div>
			</div>
		</li>
		<li>
			<div class="button">
				<div class="buttonContent">
					<button class="close" type="button">ȡ��</button>
				</div>
			</div>
		</li>
	</ul>
</div>
</form>
