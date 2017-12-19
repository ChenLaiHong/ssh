<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#FFC0CB">
							<strong>贴吧信息列表</strong>
						</TD>
					</tr>
					
					<tr>
						<td class="ta_01" align="center" bgColor="#FFC0CB">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #FFC0CB">

									<td align="center" width="10%">
										序号
									</td>
									<td align="center" width="17%">
										内容
									</td>
									<td align="center" width="17%">
										话题
									</td>
									<td align="center" width="17%">
										图片
									</td>
									<td align="center" width="17%">
										作者
									</td>
									<td align="center" width="17%">
										时间
									</td>
									
									<td width="7%" align="center">
										删除
									</td>
								</tr>
									<s:iterator var="i" value="pageBean.list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="10%">
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#i.contents"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#i.topic"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<img width="50" height="50" src="${ pageContext.request.contextPath }/<s:property value="#i.image"/>">
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#i.author"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												width="17%">
												<s:property value="#i.idate"/>
											</td>
											
											<td align="center" style="HEIGHT: 22px">
												<a href="${ pageContext.request.contextPath }/adminInformations_delete.action?inid=<s:property value="#i.inid"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</s:iterator>	
							</table>
						</td>
						
					</tr>
					<tr align="center">
						<td colspan="4">
							第<s:property value="pageBean.page"/>/<s:property value="pageBean.totalPage"/>页  
							<s:if test="pageBean.page != 1">
								<a href="${pageContext.request.contextPath }/adminInformations_findAll.action?page=1">首页</a> |
								<a href="${pageContext.request.contextPath }/adminInformations_findAll.action?page=<s:property value="pageBean.page-1"/>">上一页</a> |
							</s:if>
							<s:if test="pageBean.page != pageBean.totalPage">
							<a href="${pageContext.request.contextPath }/adminInformations_findAll.action?page=<s:property value="pageBean.page+1"/>">下一页</a> |
							<a href="${pageContext.request.contextPath }/adminInformations_findAll.action?page=<s:property value="pageBean.totalPage"/>">尾页</a> 
							</s:if>
						</td>
					</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

