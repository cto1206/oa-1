<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='style/reset.css' />
	<link rel='stylesheet' type='text/css' href='http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/themes/start/jquery-ui.css' />
	<link rel='stylesheet' type='text/css' href='style/jquery.weekcalendar.css' />
	<link rel='stylesheet' type='text/css' href='style/demo.css' />
	
	<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js'></script>
	<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.7.2/jquery-ui.min.js'></script>
	<script type='text/javascript' src='script/jquery.weekcalendar.js'></script>
	<script type='text/javascript' src='script/demo.js'></script>

</head>
<body> 
	<center>
	<h1><font color="red">�ҵĹ����ճ�</font></h1>
	</center>
	<div id='calendar'></div>
	<div id="event_edit_container">
		<form>
			<input type="hidden" />
			<ul>
				<li>
					<span>����: </span><span class="date_holder"></span> 
				</li>
				<li>
					<label for="start">��ʼʱ��: </label><select name="start"><option value="">ѡ��ʼʱ��</option></select>
				</li>
				<li>
					<label for="end">����ʱ��: </label><select name="end"><option value="">ѡ�����ʱ��</option></select>
				</li>
				<li>
					<label for="title">����: </label><input type="text" name="title" />
				</li>
				<li>
					<label for="body">����: </label><textarea name="body"></textarea>
				</li>
			</ul>
		</form>
	</div>
</body>
</html>
