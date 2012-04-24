<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>

<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageHeader">
	<form rel="pagerForm" onsubmit="return navTabSearch(this);" action="w_removeSelected.html" method="post">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>������</label>
				<input type="text" name="keywords" value=""/>
			</li>
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">����</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" href="demo_page4.html?uid={sid_user}" target="navTab" warn="��ѡ��һ���û�"><span>�޸�</span></a></li>
			<li><a class="delete" title="ȷʵҪɾ����Щ��¼��?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html"><span>����ɾ��</span></a></li>
		</ul>
	</div>
	<table class="table" width="80%" layoutH="138">
		<thead>
			<tr>
			<th width="5%"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
            <th width="5%" height="18">���</th>
            <th width="8%" height="18">����</th>
            <th width="5%" height="18">�Ա�</th>
           	<th width="20%" height="18">��������</th>
           	<th width="6%" height="18">��¼�˺�</th>
            <th width="8%" height="18">ʧЧʱ��</th>
           	<th width="8%" height="18">������</th>
           	<th width="8%" height="18">�����˺�</th>
           	<th width="8%" height="18">ɾ���˺�</th>
            <th width="8%" height="18">�޸��˺�</th>
           	<th width="8%" height="18">�����ɫ</th>
            <th width="8%" height="18">�û���Ȩ</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty pm.datas}">
				<c:forEach items="${pm.datas}" var="person">
					<tr>
			            <td>
			              <input name="selectFlag" type="checkbox" value="${person.id}" />
			            </td>
			            <td>${person.id}</td>
			            <td>${person.name}</td>
			            <td>${person.sex}</td>
			            <td>${person.org.name}</td>
			            <td>${person.user.username}</td>
			            <td><fmt:formatDate value="${person.user.expireTime}" pattern="yyyy-MM-dd"/></td>
			            <td><a href="user.do?method=bindingInput&id=${person.user.id}" title="�༭" target="dialog" class="btnEdit">������</a></td>
			            <td><a href="user.do?method=addInput&personId=${person.id}" title="�༭" target="dialog" class="btnEdit">�����˺�</td>
			            <td><a onclick="del('user.do?method=delUser&id=${person.user.id}');" title="ɾ��" target="ajaxTodo" class="btnDel">ɾ���˺�</td>
			            <td><a href="user.do?method=updateInput&id=${person.user.id}" title="�༭" target="dialog" class="btnEdit">�޸��˺�</td>
			            <td><a href="user.do?method=userRoleList&id=${person.user.id}" title="�༭" target="dialog" class="btnEdit">�����ɫ</td>
			            <td><a href="acl.do?principalType=User&principalSn=${person.user.id}" title="�༭" target="dialog" class="btnEdit">�û���Ȩ</td>
          			</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty pm.datas}">
			   <tr>
			   	<td height="18" bgcolor="#FFFFFF" colspan="13">û���ҵ���Ӧ�ļ�¼</td>
			   </tr>
			</c:if>
		</tbody>
	</table>
	<div class="panelBar">
		<pg:pager url="person.do" items="${pm.total}" export="currentPageNumber=pageNumber">
		<pg:param name="parentId"/>
		<div class="pages">
			<span>��ʾ</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>������${pm.total}��</span>
		</div>
		<div class="pagination" targetType="navTab" totalCount="200" numPerPage="20" pageNumShown="10" currentPage="${currentPageNumber}"></div>
		</pg:pager>
	</div>
</div>
