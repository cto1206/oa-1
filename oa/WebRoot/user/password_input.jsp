<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="user.do" method="post" enctype="multipart/form-data" target="dialog"  onsubmit="return iframeCallback(this,dialogAjaxDone)">

<input type="hidden" name="method" value="updatePassword">
<input type="hidden" name="id" value="${user.id}">

<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
	<p>
		<label>ԭ���룺</label>
		<input type="password" name="oldPassword" value=""  class="required valid" size="28">
	</p>
	<p>
		<label>�����룺</label>
		<input type="password" name="password" value=""  class="required valid" size="28">
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
