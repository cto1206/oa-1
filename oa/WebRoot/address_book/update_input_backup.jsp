<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>�޸�ͨ��¼��Ϣ</title>
</head>
<body>
<center>
<form action="addresslist.do" method="post">
<input type="hidden" name="method" value="update">
<input type="hidden" name="id" value="${addressBook.id }">
<input type="hidden" name="userId" value="${login.id}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">�޸�ͨ��¼</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
			<table width="100%" border="0" cellspacing="0" cellpadding="4"
			class="settingtable">
			<tbody>
				<tr class="normal black">
					<td width="120" style="text-align: right;">
						������
						<input type="hidden" name="UseFreq" value="">
					</td>
					<td align="left">
						<input type="text"  class="txt" size="28"
							name="name" value="${addressBook.name}" />
						&nbsp;
						<font color="#FF0000">(*����)</font>
					</td>
				</tr>
				<tr class="normal black">
					<td align="right">
						�����ʼ���
					</td>
					<td align="left">
						<input type="text"  name="email"
							class="txt noime" size="28" value="${addressBook.email}" />
						&nbsp;
						<font color="#FF0000">(*����)</font>
						<input type="hidden" name="USEREMAILNAME" value="">
					</td>
				</tr>

			</tbody>

			<tbody id="extendInfo">
				<tr class="normal black">
					<td align="right">
						�ֻ����룺
					</td>
					<td align="left">
						<input type="text"  name="mobilePhone"
							class="txt noime" size="28" value="${addressBook.mobilePhone}" />
					</td>
				</tr>
				<tr class="normal black">
					<td align="right">
						�̶��绰��
					</td>
					<td align="left">
						<input type="text"  name="phs"
							class="txt noime" size="28" value="${addressBook.phs}" />
					</td>
				</tr>
				<tr class="normal black">
					<td align="right">
						������
					</td>
					<td align="left">
						<input type="text"  name="nickName"
							class="txt" size="28" value="${addressBook.nickName}" />
					</td>
				</tr>
				<tr class="normal black">
					<td align="right">
						���գ�
					</td>
					<td align="left">
						<input type="text"  name="birthday"
							class="txt" size="28" value="<fmt:formatDate value="${addressBook.birthday}" pattern="yyyy-MM-dd"/>" />
					</td>
				</tr>
				<tr class="normal black">
					<td align="right">
						��ͥסַ��
					</td>
					<td align="left">
						<input type="text"  name="street"
							class="txt" size="28" value="${addressBook.street}" />
					</td>
				</tr>
				<tr class="normal black">
					<td align="right">
						��˾���ƣ�
					</td>
					<td align="left">
						<input type="text"  name="company"
							class="txt" size="28" value="${addressBook.company}" />
					</td>
				</tr>
				<tr class="normal black">
					<td align="right">
						��ע��
					</td>
					<td align="left">
						<input type="text"  name="notes"
							class="txt" size="28" value="${addressBook.notes}" />
					</td>
				</tr>
			</tbody>
		</table>
			<!-- ����������� -->
			</td>
		</TR>
	</TBODY>
</TABLE>

<TABLE>
		<TR align="center">
			<TD colspan="3" bgcolor="#EFF3F7">
			<input type="submit" name="saveButton"
				class="MyButton" value="����"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>