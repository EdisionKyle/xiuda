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
<!-- 		<meta name="renderer" content="webkit|ie-comp|ie-stand"> -->
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
		<meta http-equiv="Cache-Control" content="no-transform" />
		<!--[if lt IE 9]>
		<script type="text/javascript" src="js/html5shiv.min.js"></script>
		<![endif]-->
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="lib/icheck/icheck.css" />
		<link rel="stylesheet" type="text/css" href="lib/ztree/css/zTreeStyle/zTreeStyle.css" />
		<style type="text/css">
			.line{border: none;}
		</style>
		<title>权限编辑</title>
	</head>

	<body>
		<div class="page-container">
			<form class="form form-horizontal" id="form-role-edit">
				<input type="hidden" name="roleId" id="roleId" value="${role.roleId}" />
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>角色名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" name="roleName" id="roleName" value="${role.roleName}" style="width:60%">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">备注：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" name="remark" id="remark" value="${role.remark}" style="width:60%">
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">状态：</label>
					<div class="formControls col-xs-8 col-sm-9 skin-minimal">
						<div class="radio-box">
							<input type="radio" id="sex-1" name="available" value="1" <c:if test="${empty role.available || role.available == 1}">checked</c:if>>
							<label for="sex-1">正常</label>
						</div>
						<div class="radio-box">
							<input type="radio" id="sex-2" name="available" value="0" <c:if test="${not empty role.available && role.available == 1}">checked</c:if>>
							<label for="sex-2">禁用</label>
						</div>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">菜单授权：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<ul id="menuTree" class="ztree">
						</ul>
					</div>
				</div>
				<div class="row cl">
					<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
						<button onClick="role_save_submit();" class="btn btn-primary radius" type="button">&nbsp;&nbsp;确定&nbsp;&nbsp;</button>
						<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="lib/layer/layer.js"></script>
		<script type="text/javascript" src="js/H-ui.js"></script>
		<script type="text/javascript" src="js/H-ui.admin.js"></script>
		<script type="text/javascript" src="lib/ztree/jquery.ztree.all.min.js"></script>
		<script type="text/javascript" src="lib/icheck/icheck.min.js"></script>
		<script type="text/javascript">
			var ztree;
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
				$('.skin-minimal input').iCheck({
					checkboxClass: 'icheckbox-blue',
					radioClass: 'iradio-blue',
					increaseArea: '20%'
				});
				//加载菜单树
				$.ajax({
		            type: "GET",
		            url: "sys/menu/perms",
		            dataType: "json",
		            success: function(data){
						ztree = $.fn.zTree.init($("#menuTree"), setting, data.menuList);
						//展开所有节点
						ztree.expandAll(true);
						if($("#roleId").val() != null && $("#roleId").val() != '') {							
							getRoleMenu();
						}
		            }
		         });
			});
			function getRoleMenu() {
				$.ajax({
		            type: "GET",
		            url: "sys/role/detail/" + $("#roleId").val(),
		            dataType: "json",
		            success: function(data){
		            	//勾选角色所拥有的菜单
		    			var menuIds = data.list;
		    			for(var i=0; i<menuIds.length; i++) {
		    				var node = ztree.getNodeByParam("menuId", menuIds[i]);
		    				ztree.checkNode(node, true, false);
		    			}
		            }
		         });
			}
			//提交
			function role_save_submit() {
				//获取选择的菜单
				var nodes = ztree.getCheckedNodes(true);
				var menuIdList = new Array();
				for(var i=0; i<nodes.length; i++) {
					menuIdList.push(nodes[i].menuId);
				}
				var roleId = $("#roleId").val();
				var url = (roleId == null || roleId == '') ? "sys/role/save" : "sys/role/update";
				$.ajax({
					type: "POST",
				    url: url,
				    dataType: "json",
		            contentType: "application/json",
				    data: JSON.stringify({roleId: $("#roleId").val(), roleName: $("#roleName").val(),
				    		remark: $("#remark").val(), available: $('input[name="available"]:checked').val(), menuIdList: menuIdList}),
				    success: function(data){
			    		if(data.code == '10000'){//操作成功
			    			layer.msg('操作成功', {
								icon: 6,
								time: 1000
							});
			    			layer_close();
			    			parent.location.href ='sys/role/list';
						}else{
							layer.msg(data.msg, {
								icon: 5,
								time: 1000
							});
						}
					}
				});
			}
		</script>
	</body>

</html>