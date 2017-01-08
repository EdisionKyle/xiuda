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
		<title>菜单编辑</title>
	</head>
<body>
	<div class="page-container">
		<form class="form form-horizontal" id="form-menu-edit">
			<input type="hidden" name="menuId" value="${menu.menuId}" />
			<input type="hidden" name="parentId" value="${menu.parentId}" />
			<input type="hidden" name="type" id="type" value="${menu.type}" />
			<input type="hidden" name="parentIds" value="${menu.parentIds}" />
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">类型：</label>
				<div class="formControls col-xs-8 col-sm-9 skin-minimal">
					<div class="radio-box">
						<input type="radio" id="type-1" value="0" <c:choose><c:when test="${not empty menu.type && menu.type == 0}">checked</c:when><c:otherwise>disabled='disabled'</c:otherwise></c:choose>>
						<label for="type-1">目录</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="type-2" value="1" <c:choose><c:when test="${not empty menu.type && menu.type == 1}">checked</c:when><c:otherwise>disabled='disabled'</c:otherwise></c:choose>>
						<label for="type-2">菜单</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="type-3" value="2" <c:choose><c:when test="${not empty menu.type && menu.type == 2}">checked</c:when><c:otherwise>disabled='disabled'</c:otherwise></c:choose>>
						<label for="type-3">按钮</label>
					</div>
				</div>
			</div>
			<c:if test="${menu.type ne 0}">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>上级菜单：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" name="parentName" id="parentName" value="${parent.name}" <c:if test="${not empty parent.name}">readonly="readonly"</c:if> style="width:60%">
					</div>
				</div>
			</c:if>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>菜单名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" name="name" id="name" value="${menu.name}" style="width:60%">
				</div>
			</div>
			<c:if test="${menu.type ne 2}">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">菜单图标：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" name="icon" value='<c:if test="${not empty menu.icon}">&amp;${menu.icon}</c:if>' style="width:60%">
					</div>
				</div>
			</c:if>
			<c:if test="${menu.type eq 1}">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">菜单URL：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" name="url" value="${menu.url}" style="width:60%">
					</div>
				</div>
			</c:if>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">授权标识：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" name="perms" value="${menu.perms}" style="width:60%">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">排序号：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" name="orderNum" value="${menu.orderNum}" style="width:60%">
				</div>
			</div>
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2">状态：</label>
				<div class="formControls col-xs-8 col-sm-9 skin-minimal">
					<div class="radio-box">
						<input type="radio" id="sex-1" name="available" value="1" <c:if test="${empty menu.available || menu.available == 1}">checked</c:if>>
						<label for="sex-1">正常</label>
					</div>
					<div class="radio-box">
						<input type="radio" id="sex-2" name="available" value="0" <c:if test="${not empty menu.available && menu.available == 1}">checked</c:if>>
						<label for="sex-2">禁用</label>
					</div>
				</div>
			</div>
			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<button onClick="menu_save_submit();" class="btn btn-primary radius" type="button">&nbsp;&nbsp;确定&nbsp;&nbsp;</button>
					<button onClick="layer_close();" class="btn btn-default radius" type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
				</div>
			</div>
		</form>
	</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.serialize-object.min.js"></script>
<script type="text/javascript" src="lib/layer/layer.js"></script>
<script type="text/javascript" src="lib/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/H-ui.js"></script>
<script type="text/javascript" src="js/H-ui.admin.js"></script>
<script type="text/javascript" src="lib/icheck/icheck.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('.skin-minimal input').iCheck({
			checkboxClass: 'icheckbox-blue',
			radioClass: 'iradio-blue',
			increaseArea: '20%'
		});
	});
	//提交
	function menu_save_submit() {
		$.ajax({
            type: "POST",
            url: "sys/menu/save",
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify($("#form-menu-edit").serializeObject()),
            success: function(data){
            	if(data.code == '10000'){//操作成功
            		layer_close();
            		parent.location.href ='sys/menu/list';
				}else{
					alert(data.msg);
				}
            }
         });
	}
</script>
</body>
</html>