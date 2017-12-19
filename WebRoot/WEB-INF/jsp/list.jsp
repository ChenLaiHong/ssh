<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>贴吧</title>
<link href="${pageContext.request.contextPath}/css/slider.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
</head>
	<body>
<div align="center">
	<div class="container header">
	
	<%@ include file ="menu.jsp" %>
</div>
<div class="container index">
		<div class="span24">
			
				
						
						
									<s:iterator var="i" value="pageBean.list">
								<ul>
									<li>
									<div>
										<span style='color:red'>
								             # <s:property value="#i.topic" />
								            </span>
								            	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
								            <a href=""><img src="${pageContext.request.contextPath}/image/tx.png"
								            width="20" height="20" style="display: inline-block;" > 	&nbsp;	&nbsp;	<s:property value="#i.author" /> 
									</div>
									<div>       
								            <span style='color:green'>
								        <s:property value="#i.contents" /> 
								            </span>
								       </div>      
									<div>
										 <a href=""><img src="${pageContext.request.contextPath}/<s:property value="#i.image"/>"
								width="60" height="60" style="display: inline-block;" > 
								            <span style='color:red'>
								                <s:property value="#i.idate" /> 
								            </span>
							        </div>
							
								 
								  
								          
									</li>
									</ul>	
									</s:iterator>
								
							
				</div>
						
					
							<span>第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页 </span>
							<s:if test="pageBean.page != 1">
								<a href="${ pageContext.request.contextPath }/informations_findAll.action?page=1">首页</a>|
								<a href="${ pageContext.request.contextPath }/informations_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a>|
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
								<a href="${ pageContext.request.contextPath }/informations_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a>|
								<a href="${ pageContext.request.contextPath }/informations_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a>|
							</s:if>
					
			</div>
		
		</div>
		
		<div class="container footer">
		<div class="span24"></div>
		<div class="span24">
		
	<%@ include file="last.jsp"%>
		</div>
	</div>

	</body>
</html>

