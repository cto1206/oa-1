<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML><HEAD><TITLE>�ռ���</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<LINK href="css/globle_v1.css" type=text/css rel=stylesheet>
<LINK href="css/inbox.css" type=text/css rel=stylesheet>
<link href="css/skin_blue.css" rel="stylesheet" type="text/css" id="lnkSkin">

<META content="MSHTML 6.00.6000.16809" name=GENERATOR></HEAD>
<BODY class="All_C_Page Inbox">
<FORM id=oFormMessage 
action=#
method=post><INPUT id=oFormAction type=hidden>
<DIV class=ContentWp>
<DIV class=ContentThemeWp>
<DIV class=gTitle><B class=mTT>�ռ���</B>&nbsp;&nbsp;(��&nbsp;<B 
id=oTotal></B>&nbsp;��)</DIV>
<DIV class="gToolbar gTbrTop">
<INPUT class="Btn BtnNml" hideFocus type=button value="ɾ ��" outClass="Btn BtnNml ImpBtn" overClass="Btn BtnHv ImpBtn" action="move">
<INPUT class="Btn BtnNml" hideFocus type=button value=�ٱ������ʼ� outClass="Btn BtnNml" overClass="Btn BtnHv" action="reportYes">
<SELECT class=Sel action="mark">
	<OPTION value=none selected>���Ϊ...</OPTION>
	<OPTION value=read:true>&nbsp;&nbsp;�Ѷ��ʼ�</OPTION>
	<OPTION value=read:false>&nbsp;&nbsp;δ���ʼ�</OPTION>
</SELECT>
  
<SELECT class=Sel action="move">
  	<OPTION value=none selected>�ƶ���...</OPTION>
	<OPTION value=2>&nbsp;&nbsp;�ݸ���</OPTION>
	<OPTION value=3>&nbsp;&nbsp;�ѷ���</OPTION>
</SELECT>

<SELECT class=Sel action="view" url="#">
	<OPTION value=none selected>�鿴...</OPTION>
	<OPTION value=null>&nbsp;&nbsp;ȫ���ʼ�</OPTION>
	<OPTION class=SelOptLine value=none>-------------</OPTION>
	<OPTION value=read:false>&nbsp;&nbsp;δ���ʼ�</OPTION>
	<OPTION value=read:true>&nbsp;&nbsp;�Ѷ��ʼ�</OPTION>
</SELECT>
<DIV class=Extra><SPAN class=Txt><SPAN class=Unable>��ҳ</SPAN>&nbsp;&nbsp;<SPAN 
class=Unable>��ҳ</SPAN>&nbsp;&nbsp;<A 
href="#">��ҳ</A>&nbsp;&nbsp;<A 
href="#">ĩҳ</A></SPAN><SELECT 
class=SelA style="MARGIN-RIGHT: 0px" action="page" 
url="#"><OPTION value=1 
  selected>&nbsp;&nbsp;1/2</OPTION></SELECT></DIV></DIV>
<DIV class=Ibx_Main_Wp>
<TABLE class="Ibx_gTable F2Img Ibx_gTable_TT" id=oTableHead>
  <TBODY>
  <TR>
    <TH class=Ibx_Th_F></TH>
    <TH class=Ibx_Th_Chkbx><INPUT id=oFormCheckAll title=ȫѡ/��ѡ����ҳ�����ʼ� 
      type=checkbox></TH>
    <TH class=Ibx_Th_icoInfo><B class=icoIbx title=�ʼ�����></B></TH>
    <TH class=Ibx_Th_From>������</TH>
    <TH class=Ibx_Th_icoFlag><B class=icoIbx title=�ʼ���ǩ></B></TH>
    <TH class=Ibx_Th_Subject>����</TH>
    <TH class=Ibx_Th_Date>����</TH>
    <TH class=Ibx_Th_icoATCM><B class=icoIbx title=������ʶ></B></TH>
    <TH class=Ibx_Th_Size>��С</TH></TR>
  <TBODY></TBODY></TABLE>
<DIV class="Ibx_Lst_dWp dWpOpen">

<TABLE class="Ibx_gTable Ibx_gTable_Con" id=oTableCOUNT0 action="list">
  <TBODY>

  <TR class="I_Mark0 I_UnRd">
    <TD class=Ibx_Td_F>&nbsp;</TD>
    <TD class=Ibx_Td_Chkbx>
	    <INPUT title=ѡ��/��ѡ type=checkbox 
	      value=379:xtbBew0ktUT-x2efHAAAs- name=mid time="1236940782000" index="0" 
	      read="false">
    </TD>
    <TD class=Ibx_Td_icoInfo>
    	<B class="icoIbx " title=δ��(�����Ϊ�Ѷ�) type="markread"></B>
    </TD>
    <TD class=Ibx_Td_From title="">
    	<A href="#"></A>
    </TD>
    <TD class=Ibx_Td_icoFlag title=δ����><B class=icoIbx></B></TD>
    <TD class=Ibx_Td_Subject title="">
    	<A href="ShowHeaderAndContent?msgnum="></A>
    </TD>
    <TD class=Ibx_Td_Date title=""></TD>
    <TD class=Ibx_Td_icoATCM></TD>
    <TD class=Ibx_Td_Size><SPAN title="�ֽ�"> K</SPAN>
    </TD>
  </TR>
 
  <TBODY></TBODY></TABLE></DIV>

<H4 class=Ibx_Lst_bExtra id=oH4Check>ѡ��<A href="#" 
type=all>ȫ��</A>&nbsp;-&nbsp;<A href="#" 
type=unread>δ��</A>&nbsp;-&nbsp;<A href="#" 
type=read>�Ѷ�</A>&nbsp;-&nbsp;<A href="#" 
type=reverse>��ѡ</A>&nbsp;-&nbsp;<A href="#" 
type=no>��ѡ</A></H4></DIV>
<DIV class="gToolbar gTbrBtm">

<INPUT class="Btn BtnNml" hideFocus type=button value="ɾ ��" outClass="Btn BtnNml ImpBtn" overClass="Btn BtnHv ImpBtn" action="move">
<INPUT class="Btn BtnNml" hideFocus type=button value=�ٱ������ʼ� outClass="Btn BtnNml" overClass="Btn BtnHv" action="reportYes">
<SELECT class=Sel action="mark">
	<OPTION value=none selected>���Ϊ...</OPTION>
	<OPTION value=read:true>&nbsp;&nbsp;�Ѷ��ʼ�</OPTION>
	<OPTION value=read:false>&nbsp;&nbsp;δ���ʼ�</OPTION>
</SELECT>
  
<SELECT class=Sel action="move">
  	<OPTION value=none selected>�ƶ���...</OPTION>
	<OPTION value=2>&nbsp;&nbsp;�ݸ���</OPTION>
	<OPTION value=3>&nbsp;&nbsp;�ѷ���</OPTION>
</SELECT>

<SELECT class=Sel action="view" url="#">
	<OPTION value=none selected>�鿴...</OPTION>
	<OPTION value=null>&nbsp;&nbsp;ȫ���ʼ�</OPTION>
	<OPTION class=SelOptLine value=none>-------------</OPTION>
	<OPTION value=read:false>&nbsp;&nbsp;δ���ʼ�</OPTION>
	<OPTION value=read:true>&nbsp;&nbsp;�Ѷ��ʼ�</OPTION>
</SELECT>
<DIV class=Extra><SPAN class=Txt><SPAN class=Unable>��ҳ</SPAN>&nbsp;&nbsp;<SPAN 
class=Unable>��ҳ</SPAN>&nbsp;&nbsp;<A 
href="#">��ҳ</A>&nbsp;&nbsp;<A 
href="#">ĩҳ</A></SPAN><SELECT 
class=SelA style="MARGIN-RIGHT: 0px" action="page" 
url="list.jsp?sid=tBwkXRlgpHiyOGUAWsggoLGzpKgcUEYi&amp;fid=1"><OPTION value=1 
  selected>&nbsp;&nbsp;1/2</OPTION></SELECT></DIV></DIV></DIV></DIV></FORM><!-- Surj 2008.08.08 list.js -->
</BODY></HTML>