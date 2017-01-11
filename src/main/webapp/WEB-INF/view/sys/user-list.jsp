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
		<title>员工管理</title>
	</head>

	<body>
		<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 员工列表
		</nav>
		<div class="page-container">
			<div class="cl pd-5 bg-1 bk-gray">
				<span class="l"><a class="btn btn-primary radius" data-title="添加员工" onclick="user_add('添加员工', 'sys/user/info', '100%', '100%')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加员工</a></span>
			</div>
			<div class="mt-10">
				<table class="table table-border table-bordered table-bg table-hover table-sort">
					<thead>
						<tr class="text-c">
							<th width="15%">员工编号</th>
							<th width="25%">员工姓名</th>
							<th width="10%">手机号码</th>
							<th width="20%">固定电话</th>
							<th width="20%">邮箱</th>
							<th width="20%">职位</th>
							<th width="20%">所属角色</th>
							<th width="20%">服务商</th>
							<th width="20%">创建时间</th>
							<th width="20%">状态</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="role">
							<tr class="text-c" data-tt-id='${role.roleId}'>
								<td>${role.roleId}</td>
			            		<td>${role.roleName}</td>
			                	<td>${role.remark}</td>
			                	<th>${role.available eq 1 ? "正常" : "禁用"}</th>
			                	<td>${role.createTimeText}</td>
			                	<td>
			                		<a style="text-decoration:none" class="ml-5" onClick="role_edit(this, '编辑角色', 'sys/role/info', '100%', '100%')" href="javascript:;" title="编辑"><i class="Hui-iconfont">&#xe6df;</i></a>
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
			/*员工-添加*/
			function user_add(title, url, w, h) {
				layer.open({
					type: 2,
					title: title,
					maxmin: true,
					content: url,
					area: [w, h]
				});
			}
			/*员工-编辑*/
			function user_edit(obj, title, url, w, h) {
				layer.open({
					type: 2,
					title: title,
					maxmin: true,
					content: url + '/' + $(obj).parents("tr").attr("data-tt-id"),
					area: [w, h]
				});
			}
			/*员工-删除*/
			function user_del(obj) {
				layer.confirm('确认要删除吗？', function(index) {
					$.ajax({
			            type: "POST",
			            url: "sys/role/delete",
			            dataType: "json",
			            data: {roleId: $(obj).parents("tr").attr("data-tt-id")},
			            success: function(data){
			            	if(data.code == '10000'){//操作成功
			            		layer.msg('删除成功', {
									icon: 6,
									time: 1000
								});
			            		window.location.href ='sys/role/list';
							}else{
								layer.msg(data.msg, {
									icon: 5,
									time: 1000
								});
							}
			            }
			         });
				});
			}
		</script>
	</body>

</html>