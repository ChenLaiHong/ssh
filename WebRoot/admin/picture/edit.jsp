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
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminPicture_update.action" method="post" enctype="multipart/form-data">
			<!-- 因为pid不做修改所以把他做成隐藏字段传过去 -->
			<input type="hidden" name="pid" value="<s:property value="model.pid"/>"/>
			<!-- 因为图片也有可能没有做修改，所以也做成隐藏字段 -->
			<input type="hidden" name="image" value="<s:property value="model.image"/>"/>
			
			&nbsp;
			
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #FFC0CB" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#FFC0CB" colSpan="4"
						height="26">
						<strong><STRONG>编辑图片</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图片名称：
					</td>
					<td class="ta_01" bgColor="#ffffff">
						<input type="text" name="pname" value="<s:property value="model.pname"/>" class="bg"/>
					</td>
					
				</tr>
				
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图片：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="file" name="upload" />
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属的二级分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select name="categorySecond.csid">
							<s:iterator var="cs" value="csList">
							
								<option value="<s:property value="#cs.csid"/>"<s:if test="#cs.csid==model.categorySecond.csid">selected</s:if>><s:property value="#cs.csname"/></option>
							</s:iterator>
						</select>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						图片描述：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="pdesc" rows="5" cols="30"><s:property value="model.pdesc"/></textarea>
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