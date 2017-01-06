<%@page language="java" import="java.util.Date"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="zh">
	<head>
		<base href=" <%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
		<meta http-equiv="Cache-Control" content="no-transform" />
		<!--[if lt IE 9]>
		<script type="text/javascript" src="js/html5shiv.min.js"></script>
		<![endif]-->
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="lib/ztree/css/metroStyle/metroStyle.css" />
		<style type="text/css">
			</style>
		<title>菜单管理</title>
	</head>

	<body>
		<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 菜单列表
		</nav>
		<div class="page-container">
			<div class="cl pd-5 bg-1 bk-gray"> <span class="l"><a class="btn btn-primary radius" data-title="添加角色" onclick="role_add('添加角色', 'sys/role/toAdd', '80%', '80%')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加角色</a></span></div>
			<div class="mt-10">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="15%">角色ID</th>
							<th width="20%">角色名称</th>
							<th width="25%">角色备注</th>
							<th width="15%">状态</th>
							<th width="25%">创建时间</th>
							<th width="20%">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="role">
							<tr class="text-c">
								<td>${role.roleId}</td>
			            		<td>${role.roleName}</td>
			                	<td>${role.remark}</td>
			                	<th>${role.available eq 1 ? "正常" : "禁用"}</th>
			                	<td>${role.createTime}</td>
			                	<td>
			                		<a style="text-decoration:none" class="ml-5" onClick="role_edit(this, '编辑角色', 'sys/role/role-edit', '80%', '80%')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
									<a style="text-decoration:none" class="ml-5" onClick="role_del(this)" href="javascript:;" title="删除"><i class="Hui-iconfont">&#xe6e2;</i></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="lib/layer/layer.js"></script>
		<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="lib/ztree/jquery.ztree.all.min.js"></script>
		<script type="text/javascript">
			$(function(){
				
			});
			/*角色-添加*/
			function role_add(title, url, w, h) {
				layer.open({
					type: 2,
					title: title,
					content: url,
					area: [w, h]
				});
			}
		</script>
	</body>

</html>