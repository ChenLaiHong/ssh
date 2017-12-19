<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<body bgcolor=" ＃ 00FFFF">

	<div class="container header">

		<%@ include file="menu.jsp"%>
	</div>
	<div class="container index">


		<div class="span24">
			<div class="title">
						<strong>最新贴</strong>
						<a  target="_blank"></a>
					</div>
				
				<s:iterator var="i" value="nList">
								<ul>
									<li>
									
									<div>
										<span style='color:red'>
								             # <s:property value="#i.topic" />
								            </span>
								            	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
								            	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
								            <img src="${pageContext.request.contextPath}/image/tx.png"
								            width="20" height="20" alt="主题作者" title="主题作者" /> 	&nbsp;	&nbsp;	<s:property value="#i.author" /> 
									</div>
									<div>       
								            <span style='color:green'>
								            <a href="${pageContext.request.contextPath}/replies_findByInid.action?inid=<s:property value="#i.inid"/>&page=1">
								        <s:property value="#i.contents" /> 
								        </a>
								            </span>
								       </div>      
									<div>
										<img src="${pageContext.request.contextPath}/<s:property value="#i.image"/>"
								width="80" height="80" style="display: inline-block;" /> 
								&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
								            	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;
								            <span style='color:red'>
								                <s:property value="#i.idate" /> 
								            </span>
							        </div>
											          
									</li>
									</ul>	
									</s:iterator>
		
		</div>
<%@ include file="/WEB-INF/information/add.jsp"%>	
	</div>
	
	<div class="container footer">
		<div class="span24"></div>
		<div class="span24">
			<%@ include file="last.jsp"%>
		</div>
	</div>
</body>
</html>