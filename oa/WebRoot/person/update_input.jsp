<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="person.do" method="post" target="dialog">
<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
	<p>
		<label>��������</label>
		<input type="text" id="orgNameId" disabled="disabled" value="${person.org.name }">
		<input type="hidden" name="orgId" id="orgIdId" value="${person.org.id }">
		<a target="dialog" href="org.do?select=true">ѡ��</a>
	</p>
	<p>
		<label>����</label>
		<input type="text" name="name" value="${person.name }">
	</p>
	<p>
		<label>�Ա�</label>
		<input type="text" name="sex" value="${person.sex }">
	</p>
	<p>
		<label>�绰</label>
		<input type="text" name="phone" value="${person.phone }">
	</p>
	<p>
		<label>��ַ</label>
		<input type="text" name="phone" value="${person.address }">
	</p>
	<p>
		<label>����</label>
		<input type="text" name="phone" value="${person.description }">
	</p>
</div>
<input type="hidden" name="method" value="update">
<input type="hidden" name="id" value="${person.id }">
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
