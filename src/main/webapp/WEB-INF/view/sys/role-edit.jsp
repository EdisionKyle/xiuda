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
			.line{border: none;}
		</style>
		<title>添加角色</title>
	</head>

	<body>
		<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 角色管理
		</nav>
		<div class="page-container">
			<ul id="menuTree" class="ztree">
			</ul>
		</div>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="lib/layer/layer.js"></script>
		<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="lib/ztree/jquery.ztree.all.min.js"></script>
		<script type="text/javascript">
			var setting = {
				data: {
					simpleData: {
						enable: true,
						idKey: "menuId",
						pIdKey: "parentId",
						rootPId: -1
					},
					key: {
						url:"nourl"
					}
				},
				check:{
					enable:true,
					nocheckInherit:true
				}
			};
			$(function(){
				//加载菜单树
				$.get("sys/menu/perms", function(data){
					ztree = $.fn.zTree.init($("#menuTree"), setting, data.menuList);
					//展开所有节点
					ztree.expandAll(true);
				});
			});
		</script>
	</body>

</html>