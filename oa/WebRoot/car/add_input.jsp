<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<title>��ӳ�����Ϣ</title>
</head>
<body>
<center>
<form action="car.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="method" value="add">
<input type="hidden" name="userId" value="${login.id}">
<TABLE class="tableEdit" border="0" cellspacing="1" cellpadding="0" style="width:580px;">
	<TBODY>
		<TR>
			<!-- ��������ӡ��༭����ı��� -->
			<td align="center" class="tdEditTitle">
			��Ҫ��ӵĳ���
			</TD>
		</TR>
		<TR>
			<td>
			<!-- ��������ʼ -->
			
			<table width="100%" border="0" cellspacing="0" cellpadding="4"
			class="settingtable">
			<tbody>
				<tr class="normal black">
					<td width="120" style="text-align: right;">
						�������ƣ�
						<input type="hidden" name="UseFreq" value="">
					</td>
					<td align="left">
						<input type="text"  class="txt" size="28"
							name="name" value="" />
						&nbsp;
						<font color="#FF0000">(*����)</font>
					</td>
				</tr>
				<tr class="normal black">
					<td align="right">
						���ƺ��룺
					</td>
					<td align="left">
						<input type="text"  name="carNumber"
							class="txt noime" size="28" value="" />
						&nbsp;
						<font color="#FF0000">(*����)</font>
						<input type="hidden" name="USEREMAILNAME" value="">
					</td>
				</tr>

			</tbody>

			<tbody id="extendInfo">
				<tr class="normal black">
					<td align="right">
						�ؿ�������
					</td>
					<td align="left">
						<input type="text"  name="carLoad"
							class="txt noime" size="28" value="" />
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
				class="MyButton" value="���泵����Ϣ"> 
			<input type="button" class="MyButton"
				value="�رմ���" onclick="window.close()">
			</TD>
		</TR>
</TABLE>
</form>
</center>
</body>
</html>