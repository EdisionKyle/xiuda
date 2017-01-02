<%@page language="java" import="java.util.Date"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="zh">
	<head>
		<base href=" <%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
		<meta http-equiv="Cache-Control" content="no-transform" />
		<link rel="bookmark" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
		<!--[if lt IE 9]>
		<script type="text/javascript" src="js/html5shiv.min.js"></script>
		<![endif]-->
		<link rel="stylesheet" type="text/css" href="css/index.css" />
		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="lib/Hui-iconfont/1.0.8/iconfont.css" />
		<title>M-ui.admin后台管理</title>
		<meta name="keywords" content="后台管理系统模板">
		<meta name="description" content="后台管理系统模板">
	</head>
	<body>
		<header class="navbar-wrapper">
			<div class="navbar navbar-fixed-top">
				<div class="container-fluid cl">
					<img class="logo navbar-logo f-l mr-10 hidden-xs" href="/index.shtml" src="images/logo.png"></img>
					<a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/index.shtml">逗比一刻</a> <span class="logo navbar-slogan f-l mr-10 hidden-xs">运营管理</span>
					<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
					<nav class="nav navbar-nav">
						<ul class="cl">
							<li class="dropDown dropDown_hover">
								<a href="javascript:;" class="dropDown_A"><i class="Hui-iconfont">&#xe600;</i> 新增 <i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li>
										<a href="javascript:;" onclick="article_add('添加资讯','article-add.html')"><i class="Hui-iconfont">&#xe616;</i> 资讯</a>
									</li>
									<li>
										<a href="javascript:;" onclick="picture_add('添加资讯','picture-add.html')"><i class="Hui-iconfont">&#xe613;</i> 图片</a>
									</li>
									<li>
										<a href="javascript:;" onclick="product_add('添加资讯','product-add.html')"><i class="Hui-iconfont">&#xe620;</i> 产品</a>
									</li>
									<li>
										<a href="javascript:;" onclick="member_add('添加用户','member-add.html','','510')"><i class="Hui-iconfont">&#xe60d;</i> 用户</a>
									</li>
								</ul>
							</li>
						</ul>
					</nav>
					<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
						<ul class="cl">
							<li>超级管理员</li>
							<li class="dropDown dropDown_hover">
								<a class="dropDown_A"><shiro:principal property="username"/><i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li>
										<a href="javascript:;" onclick="renderMenu()">个人信息</a>
									</li>
									<li>
										<a href="javascript:;">修改密码</a>
									</li>
									<li>
										<a href="logout">退出</a>
									</li>
								</ul>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<aside class="Hui-aside">
			<div class="menu_dropdown" id="menu_dropdown">
				<dl id="menu-article">
					<dt><i class="Hui-iconfont">&#xe616;</i> 资讯管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li>
								<a data-href="article-list.html" data-title="资讯管理" href="javascript:void(0)">资讯管理</a>
							</li>
						</ul>
					</dd>
				</dl>
				<dl id="menu-member">
					<dt><i class="Hui-iconfont">&#xe60d;</i> 会员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li><a data-href="member-list.html" data-title="会员列表" href="javascript:;">会员列表</a></li>
							<li><a data-href="member-del.html" data-title="删除的会员" href="javascript:;">删除的会员</a></li>
							<li><a data-href="member-level.html" data-title="等级管理" href="javascript:;">等级管理</a></li>
							<li><a data-href="member-scoreoperation.html" data-title="积分管理" href="javascript:;">积分管理</a></li>
							<li><a data-href="member-record-browse.html" data-title="浏览记录" href="javascript:void(0)">浏览记录</a></li>
							<li><a data-href="member-record-download.html" data-title="下载记录" href="javascript:void(0)">下载记录</a></li>
							<li><a data-href="member-record-share.html" data-title="分享记录" href="javascript:void(0)">分享记录</a></li>
						</ul>
					</dd>
				</dl>
				<dl id="menu-admin">
					<dt><i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li><a data-href="admin-role.html" data-title="角色管理" href="javascript:void(0)">角色管理</a></li>
							<li><a data-href="admin-permission.html" data-title="权限管理" href="javascript:void(0)">权限管理</a></li>
							<li><a data-href="admin-list.html" data-title="管理员列表" href="javascript:void(0)">管理员列表</a></li>
						</ul>
					</dd>
				</dl>
				<dl id="menu-tongji">
					<dt><i class="Hui-iconfont">&#xe61a;</i> 系统统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li><a data-href="charts-1.html" data-title="折线图" href="javascript:void(0)">折线图</a></li>
							<li><a data-href="charts-2.html" data-title="时间轴折线图" href="javascript:void(0)">时间轴折线图</a></li>
							<li><a data-href="charts-3.html" data-title="区域图" href="javascript:void(0)">区域图</a></li>
							<li><a data-href="charts-4.html" data-title="柱状图" href="javascript:void(0)">柱状图</a></li>
							<li><a data-href="charts-5.html" data-title="饼状图" href="javascript:void(0)">饼状图</a></li>
							<li><a data-href="charts-6.html" data-title="3D柱状图" href="javascript:void(0)">3D柱状图</a></li>
							<li><a data-href="charts-7.html" data-title="3D饼状图" href="javascript:void(0)">3D饼状图</a></li>
						</ul>
					</dd>
				</dl>
			</div>
		</aside>
		<div class="dislpayArrow hidden-xs">
			<a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
		</div>
		<section class="Hui-article-box">
			<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
				<div class="Hui-tabNav-wp">
					<ul id="min_title_list" class="acrossTab cl">
						<li class="active"><span title="我的桌面" data-href="default.html">我的桌面</span><em></em></li>
					</ul>
				</div>
				<div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
			</div>
			<div id="iframe_box" class="Hui-article">
				<div class="show_iframe">
					<div style="display:none" class="loading"></div>
					<iframe scrolling="yes" frameborder="0" src="default.html"></iframe>
				</div>
			</div>
		</section>

		<script id="menuTpl" type="text/html">
		{{each menuList as value index}}
            <dl id="menu-{{value.id}}">
				
				<dt><i class="Hui-iconfont">&#xe616;</i> {{value.name}}<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
				{{if value.list}}
					{{each value.list as subvalue subindex}}
					<dd>
					<ul>
						<li>
							<a data-href="{{subvalue.url}}" data-title="{{subvalue.name}}" href="javascript:void(0)">{{subvalue.name}}</a>
						</li>
					</ul>
					</dd>
					{{/each}}
				{{/if}}
			</dl>
		{{/each}}
        </script>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="lib/layer/layer.js"></script>
		<script type="text/javascript" src="js/H-ui.js"></script>
		<script type="text/javascript" src="js/template.js"></script>
		<script type="text/javascript" src="js/H-ui.admin.js"></script>
		<script type="text/javascript">
			/*资讯-添加*/
			function article_add(title, url) {
				var index = layer.open({
					type: 2,
					title: title,
					content: url
				});
				layer.full(index);
			}
			/*图片-添加*/
			function picture_add(title, url) {
				var index = layer.open({
					type: 2,
					title: title,
					content: url
				});
				layer.full(index);
			}
			/*产品-添加*/
			function product_add(title, url) {
				var index = layer.open({
					type: 2,
					title: title,
					content: url
				});
				layer.full(index);
			}
			/*用户-添加*/
			function member_add(title, url, w, h) {
				layer_show(title, url, w, h);
			}
		</script>
	</body>
</html>