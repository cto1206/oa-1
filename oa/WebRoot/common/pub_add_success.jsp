<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<link href="style/oa.css" rel="stylesheet" type="text/css">
		<link href="style/win.css" rel="stylesheet" type="text/css">
		<script language="javascript">
			function closewindow(){
				if(window.opener){
					window.opener.location.reload(true);
					window.close();
				}
			}
			
			function clock(){
				i=i-1;
				if(document.getElementById("info")){
					document.getElementById("info").innerHTML="�����ڽ���"+i+"����Զ��ر�";
				}
				if(i>0){
					setTimeout("clock();",1000);
				}else{
					closewindow();
				}
			}
			
			var i=4;
			clock();
		
		</script>
		<title>��Ӽ�¼�ɹ�</title>
	</head>

	<body>
		<center>
			<font color="red" size="5">��ӳɹ�</font>
			<br />
			<div id="info">�����ڽ���3����Զ��ر�</div>
			<input type="button" value="�رմ���" onclick="window.close();">
		</center>
	</body>
</html>
