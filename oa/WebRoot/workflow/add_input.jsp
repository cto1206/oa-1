<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="workflow.do" method="post" enctype="multipart/form-data" target="dialog" onsubmit="return iframeCallback(this,dialogAjaxDone)">
<input type="hidden" name="method" value="add">
<input type="hidden" name="userId" value="${login.id}">

<div class="pageFormContent" layouth="56" style="height: 205px; overflow: auto;">
	<p>
		<label>��ӻ������ϴ����̶����ļ���ͼƬ</label>
	</p>
	<p>
	<p>
		<label>��ѡ���ϴ������̶����ļ���</label>
		<input type="file" name="processDefinition">
	</p>
	<p>
	<p>
		<label>��ѡ���ϴ������̶���ͼƬ��</label>
		<input type="file" name="processImage">
	</p>
</div>
<div class="formBar">
	<ul>
		<li>
			<div class="buttonActive">
				<div class="buttonContent">
					<button type="submit">�ϴ�</button>
				</div>
			</div>
		</li>
		<li>
			<div class="button">
				<div class="buttonContent">
					<button class="close" type="button">�ر�</button>
				</div>
			</div>
		</li>
	</ul>
</div>
</form>
