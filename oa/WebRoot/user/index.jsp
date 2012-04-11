<%@ page language="java" contentType="text/html; charset=GB18030" pageEncoding="GB18030"%>
<%@include file="/common/common.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户管理</title>
<link href="style/oa.css" rel="stylesheet" type="text/css">
<script language="javascript" src="script/public.js"></script>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE4 {
	font-size: 12px;
	color: #1F4A65;
	font-weight: bold;
}

a:link {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;

}
a:visited {
	font-size: 12px;
	color: #06482a;
	text-decoration: none;
}
a:hover {
	font-size: 12px;
	color: #FF0000;
	text-decoration: underline;
}
a:active {
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.STYLE7 {font-size: 12}

-->
</style>

<script>
var  highlightcolor='#eafcd5';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';
function  changeto(event){
	var event = window.event || event;
	var source=event.srcElement;
	if(source.tagName=="TR"||source.tagName=="TABLE")
		return;
	while(source.tagName!="TD")
		source=source.parentElement;
	source=source.parentElement;
	cs  =  source.children;
	//alert(cs.length);
	if(cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
	for(i=0;i<cs.length;i++){
		cs[i].style.backgroundColor=highlightcolor;
	}
}

function  changeback(event){
	var event = window.event || event;
	source=event.srcElement;
	if(event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
		return;
	if(event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
	for(i=0;i<cs.length;i++){
		cs[i].style.backgroundColor="";
	}
}


</script>
</head>

<body>
<form id="orgForm">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="images/tab_05.gif"><img src="images/311.gif" width="16" height="16" /> <span class="STYLE4">用户管理</span></td>
        <td width="281" background="images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1">
                    <div align="center">
                        <input type="checkbox" name="ifAll" value="checkbox" onclick="checkAll()"/>
                    </div>
                    </td>
                    <td class="STYLE1"><div align="center">全选</div></td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
        <td width="14"><img src="images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3"><table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" onmouseover="changeto(event)"  onmouseout="changeback(event)">
          <tr>
            <td width="4%" height="26" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">选择</div></td>
            <td width="4%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">序号</div></td>
            <td width="8%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">姓名</div></td>
            <td width="4%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">性别</div></td>
            <td width="12%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">所属机构</div></td>
           	<td width="8%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">登录账号</div></td>
            <td width="14%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2 STYLE1">失效时间</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">绑定邮箱</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">分配账号</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">删除账号</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">修改账号</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">分配角色</div></td>
            <td width="7%" height="18" background="images/tab_14.gif" class="STYLE1"><div align="center" class="STYLE2">用户授权</div></td>
          </tr>
          <c:if test="${!empty pm.datas}">
          <c:forEach items="${pm.datas}" var="person">
          <tr>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE1">
              <input name="selectFlag" type="checkbox" class="STYLE2" value="${person.id}" />
            </div></td>
            <td height="18" bgcolor="#FFFFFF" class="STYLE2"><div align="center" class="STYLE2 STYLE1">${person.id}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${person.name}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${person.sex}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${person.org.name}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1">${person.user.username}</div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center" class="STYLE2 STYLE1"><fmt:formatDate value="${person.user.expireTime}" pattern="yyyy-MM-dd"/></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><img src="images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="#" onclick="openWin('user.do?method=bindingInput&id=${person.user.id}','bindingMailAddr',600,200);">绑定邮箱</a><span class="STYLE1">]</span></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><img src="images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="#" onclick="openWin('user.do?method=addInput&personId=${person.id}','assignUser',600,200);">分配账号</a><span class="STYLE1">]</span></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><span class="STYLE2"><img src="images/010.gif" width="9" height="9" /> </span><span class="STYLE1">[</span><a href="#" onclick="del('user.do?method=delUser&id=${person.user.id}');">删除账号</a><span class="STYLE1">]</span></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><img src="images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="#" onclick="openWin('user.do?method=updateInput&id=${person.user.id}','chgpsw',600,200);">修改账号</a><span class="STYLE1">]</span></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><img src="images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="#" onclick="openWin('user.do?method=userRoleList&id=${person.user.id}','assignRole',600,200);">分配角色</a><span class="STYLE1">]</span></div></td>
            <td height="18" bgcolor="#FFFFFF"><div align="center"><img src="images/037.gif" width="9" height="9" /><span class="STYLE1"> [</span><a href="#" onclick="openWin('acl.do?principalType=User&principalSn=${person.user.id}','roleAuth',700,600,1);">用户授权</a><span class="STYLE1">]</span></div></td>
          </tr>
          </c:forEach>
          </c:if>
           <!-- 在列表数据为空的时候，要显示的提示信息 -->
		   <c:if test="${empty pm.datas}">
		   <tr>
		   	<td height="18" bgcolor="#FFFFFF" colspan="7"><div align="center" class="STYLE2 STYLE1">没有找到相应的记录</div></td>
		   </tr>
		   </c:if>
        </table></td>
        <td width="9" background="images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="images/tab_20.gif" width="15" height="29" /></td>
        <td background="images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
          	<pg:pager url="user.do" items="${pm.total}" export="currentPageNumber=pageNumber">
            	<pg:param name="parentId"/>
            	
            <td width="25%" height="29" nowrap="nowrap">
            	<span class="STYLE1">
            		共${pm.total}条纪录，当前第
            		<pg:pages>
            			<c:choose>
            				<c:when test="${currentPageNumber eq pageNumber}">
            					<font color="red">${pageNumber}</font>
            				</c:when>
            			</c:choose>
            		</pg:pages>
            		页，每页10条纪录
            	</span>
            </td>
            <td width="75%" valign="top" class="STYLE1"><div align="right">
              <table width="352" height="20" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="62" height="22" valign="middle">
                  	<div align="right">
                  		<pg:first>
            				<a href="${pageUrl}"><img src="images/first.gif" width="37" height="15" /></a>
            			</pg:first>
                  	</div>
                  </td>
                  <td width="50" height="22" valign="middle">
                  	<div align="right">
                  		<pg:prev>
            				<a href="${pageUrl}"><img src="images/back.gif" width="43" height="15" /></a>
            			</pg:prev>
                  	</div>
                  </td>
                  <td width="54" height="22" valign="middle">
                  	<div align="right">
                  		<pg:next>
            				<a href="${pageUrl}"><img src="images/next.gif" width="43" height="15" /></a>
            			</pg:next>
                  	</div>
                  </td>
                  <td width="49" height="22" valign="middle">
                  	<div align="right">
                  		<pg:last>
            				<a href="${pageUrl}"><img src="images/last.gif" width="37" height="15" /></a>
            			</pg:last>
                  	</div>
                  </td>
                </tr>
              </table>
            </div>
            </td>
            </pg:pager>
          </tr>
        </table></td>
        <td width="14"><img src="images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
</body>
</html>
