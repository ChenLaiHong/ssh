<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add('01',-1,'系统菜单树');
		d.add('0101','01','用户管理');
		d.add('010101','0101','用户管理','${pageContext.request.contextPath}/userAdmin_findAll.action?page=1','','mainFrame');
		d.add('0102','01','一级分类管理');
		d.add('010201','0102','一级分类管理','${pageContext.request.contextPath}/adminCategory_findAll.action','','mainFrame');
		d.add('0103','01','二级分类管理');
		d.add('010301','0103','二级分类管理','${pageContext.request.contextPath}/adminCategorySecond_findAll.action?page=1','','mainFrame');
		d.add('0104','01','话题管理');
		d.add('010401','0104','话题管理','${pageContext.request.contextPath}/adminTopic_findAll.action','','mainFrame');
		d.add('0105','01','图片管理');
		d.add('010501','0105','图片管理','${pageContext.request.contextPath}/adminPicture_findAll.action?page=1','','mainFrame');
		d.add('0106','01','贴吧信息管理');
		d.add('010601','0106','贴吧信息管理','${pageContext.request.contextPath}/adminInformations_findAll.action?page=1','','mainFrame');
		d.add('0107','01','群组管理');
		d.add('010701','0107','群组管理','${pageContext.request.contextPath}/adminGroup_findAll.action?page=1','','mainFrame');
		
		document.write(d);
		//-->
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
