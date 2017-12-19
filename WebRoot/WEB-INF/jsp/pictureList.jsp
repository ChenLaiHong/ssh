<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://localhost:8080/mango/product/list/1.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>贴吧</title>
	<link href="${pageContext.request.contextPath}/css/common.css"
		rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/product.css"
		rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container header">

		<%@ include file="menu.jsp"%>
	</div>

	<div class="container pictureList">
		<div class="span6">
			<div class="hotProductCategory">
				<s:iterator var="c" value="#session.cList">
					<dl>
                        <dt>
								<a href="${pageContext.request.contextPath}/picture_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>
							</dt>
						<s:iterator var="cs" value="#c.categorySeconds">
							<dd>
										<a href="${ pageContext.request.contextPath }/picture_findByCsid.action?csid=<s:property value="#cs.csid"/>&page=1"><s:property value="#cs.csname"/></a>
									</dd>
						</s:iterator>
					</dl>
				</s:iterator>
			</div>
		</div>

		<div class="span18 last">

	<form id="productForm"action="${pageContext.request.contextPath}/image/ Powered By Mango Team.htm"method="get" >


			<div id="result" class="result table clearfix">
				<ul>
					<s:iterator var="p" value="pageBean.list">
						<li>
						    <a href=""> <img src="${pageContext.request.contextPath}/<s:property value="#p.image"/>"
								width="670" height="370" style="display: inline-block;" > 
								<dd>
								<span style='color:green'>
								 <s:property value="#p.pname" /> 
								</span>
								</dd>
								<dd>
								  <span class="pdate"> 
								  上传时间：<s:property value="#p.pdate" />
								  </span> 
								  </dd>
								 
								   <span class="pdesc"> 
								  描述：<s:property value="#p.pdesc" />
								  </span> 
								
							</a>
					</li>
					
					</s:iterator>
				</ul>
			</div>
<div class="pagination">
			<span>第 <s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/> 页</span>
		<s:if test="cid != null">
			<s:if test="pageBean.page != 1">
				<a href="${ pageContext.request.contextPath }/picture_findByCid.action?cid=<s:property value="cid"/>&page=1" class="firstPage">&nbsp;</a>
				<a href="${ pageContext.request.contextPath }/picture_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
			</s:if>
			
			<s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page != #i">
					<a href="${ pageContext.request.contextPath }/picture_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				</s:if>
				<s:else>
					<span class="currentPage"><s:property value="#i"/></span>
				</s:else>
			</s:iterator>
			
			<s:if test="pageBean.page != pageBean.totalPage">	
				<a class="nextPage" href="${ pageContext.request.contextPath }/picture_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
				<a class="lastPage" href="${ pageContext.request.contextPath }/picture_findByCid.action?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
			</s:if>
		</s:if>	
		<s:if test="csid != null">
			<s:if test="pageBean.page != 1">
				<a href="${ pageContext.request.contextPath }/picture_findByCsid.action?csid=<s:property value="csid"/>&page=1" class="firstPage">&nbsp;</a>
				<a href="${ pageContext.request.contextPath }/picture_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page-1"/>" class="previousPage">&nbsp;</a>
			</s:if>
			
			<s:iterator var="i" begin="1" end="pageBean.totalPage">
				<s:if test="pageBean.page != #i">
					<a href="${ pageContext.request.contextPath }/picture_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="#i"/>"><s:property value="#i"/></a>
				</s:if>
				<s:else>
					<span class="currentPage"><s:property value="#i"/></span>
				</s:else>
			</s:iterator>
			
			<s:if test="pageBean.page != pageBean.totalPage">	
				<a class="nextPage" href="${ pageContext.request.contextPath }/picture_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page+1"/>">&nbsp;</a>
				<a class="lastPage" href="${ pageContext.request.contextPath }/picture_findByCsid.action?csid=<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/>">&nbsp;</a>
			</s:if>
		</s:if>	
	</div>
			</form>
		</div>
		</div>
<div class="container footer">
			<%@ include file="last.jsp"%>
		</div>
</body>
</html>