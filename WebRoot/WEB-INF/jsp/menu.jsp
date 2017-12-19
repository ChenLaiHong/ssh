<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
				<s:if test="#session.existUser == null">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/user_loginPage.action">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/user_registPage.action">注册</a>|
				</li>
				</s:if>
				<s:else>
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<s:property value="#session.existUser.name"/>|</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath}/informations_findByUid.action?page=1">我的贴</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/user_quit.action">退出</a>|
				</li>
				
				</s:else>
				
						<li><a>会员中心</a>|</li>
						<li><a>贴吧指南</a>|</li>
						<li><a>关于我们</a></li>
			</ul>
		</div>
		
	</div>
	<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo1.png" width="951" height="159" alt="贴吧"/>
	<div class="span24">
		<ul class="mainNav">
					<li><a href="${pageContext.request.contextPath }/index.action">首页</a>|</li>
					<li><a href="${pageContext.request.contextPath }/informations_findAll.action?page=1">看帖</a>|</li>
					<s:iterator var="c" value="#session.cList">
					<li><a href="${pageContext.request.contextPath }/picture_findByCid.action?cid=<s:property value="#c.cid"/>&page=1"><s:property value="#c.cname"/></a>|</li>
					</s:iterator>
					<li><a href="${pageContext.request.contextPath }/index.action">精品</a>|</li>
					<li><a href="${pageContext.request.contextPath }/group_findAll.action?page=1">群组</a>|</li>
					
		</ul>
	</div>	