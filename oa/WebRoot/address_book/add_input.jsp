<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="addresslist.do" method="post" target="dialog">

<input type="hidden" name="method" value="add">
<input type="hidden" name="userId" value="${login.id}">

<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
	<p>
		<label>����</label>
		<input type="hidden" name="UseFreq" value="">
		<input class="required valid" size="28" type="text" name="name">
	</p>
	<p>
		<label>�����ʼ�</label>
		<input type="hidden" name="USEREMAILNAME" value="">
		<input class="required valid" size="28" type="text" name="email">
	</p>
	<p>
		<label>�ֻ�����</label>
		<input type="text" size="28" name="mobilePhone">
	</p>
	<p>
		<label>�̶��绰</label>
		<input type="text" size="28" name="phs">
	</p>
	<p>
		<label>����</label>
		<input type="text" size="28" name="nickName">
	</p>
	<p>
		<label>����</label>
		<input type="text" class="date" size="28" name="birthday"><a class="inputDateButton" href="javascript:;">ѡ��</a>
	</p>
	<p>
		<label>��ͥסַ</label>
		<input type="text" size="28" name="street">
	</p>
	<p>
		<label>��˾����</label>
		<input type="text" size="28" name="company">
	</p>
	<p>
		<label>��ע</label>
		<input type="text" size="28" name="notes">
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
