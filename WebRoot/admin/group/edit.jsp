<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<!--  -->
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminGroup_update.action" method="post" enctype="multipart/form-data">
			<!-- 因为pid不做修改所以把他做成隐藏字段传过去 -->
			<input type="hidden" name="gid" value="<s:property value="model.gid"/>"/>
			<!-- 因为图片也有可能没有做修改，所以也做成隐藏字段 -->
			<input type="hidden" name="image" value="<s:property value="model.image"/>"/>
			
			&nbsp;
			
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #FFC0CB" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#FFC0CB" colSpan="4"
						height="26">
						<strong><STRONG>编辑群组</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						群组名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="gname" value="<s:property value="model.gname"/>" class="bg"/>
					</td>
					
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						头像：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="upload" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						群组成员个数：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="gmember" value="<s:property value="model.gmember"/>" class="bg"/>
					</td>
					
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						群组描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="gdesc" rows="5" cols="30"><s:property value="model.gdesc"/></textarea>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>