<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ include file="/common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>����������ʷ</title>
</head>
<body>
<logic:empty name="historys">
<font color="red" size="15">û��������ʷ��¼��</font>
</logic:empty>
<logic:notEmpty name="historys">
<logic:iterate id="history" name="historys">
<hr>
<font color="red" size="5">&nbsp;&nbsp;�����ˣ�<c:out value="${history.approver.person.name }"/></font><br>
<font color="red" size="5">����ʱ�䣺<fmt:formatDate value="${history.approveTime}" pattern="yyyy��MM��dd��  HH:mm:ss"/></font><br>
<font color="red" size="5">���������<c:out value="${history.comment }"/></font><br>
<br>
</logic:iterate>
</logic:notEmpty>
</body>
</html>