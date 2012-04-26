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
				<label>�������ƣ�</label>
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

<form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" href="workflow.do?method=addInput"><span>����</span></a></li>
			<li><a class="delete" title="ȷʵҪɾ����Щ��¼��?" target="selectedTodo" rel="ids" href="demo/common/ajaxDone.html"><span>����ɾ��</span></a></li>
		</ul>
	</div>
	<table class="table" width="80%" layoutH="138">
		<thead>
			<tr>
			<th width="8%"><input type="checkbox" group="selectFlag" class="checkboxCtrl"></th>
            <th width="8%" height="18">���</th>
            <th width="30%" height="18">��������</th>
            <th width="10%" height="18">����</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${!empty workflows}">
				<c:forEach items="${workflows}" var="workflow">
					<tr>
			            <td>
			              <input name="selectFlag" type="checkbox" value="${workflow.id}" />
			            </td>
			            <td>${workflow.id}</td>
			            <td>${workflow.name}</td>
			            <td>
							<a href="workflow.do?method=del&id=${workflow.id }" title="ȷ��Ҫɾ����?" target="ajaxTodo" class="btnDel">ɾ��</a>
						</td>
          			</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty workflows}">
			   <tr>
			   	<td height="18" bgcolor="#FFFFFF" colspan="13">û���ҵ���Ӧ�ļ�¼</td>
			   </tr>
			</c:if>
		</tbody>
	</table>
	<div class="panelBar">
		<pg:pager url="workflow.do" items="${pm.total}" export="currentPageNumber=pageNumber">
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
</form>