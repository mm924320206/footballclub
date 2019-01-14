<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script type="text/javascript">
	//session过期 跳出ifarme
	if (window != top) {
		top.location.href = location.href;
	}
	$(function() {
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 692) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
		})
	});
</script>

</head>

<body
	style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">



	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<div class="loginbody">

		<span class="systemlogo"></span>

		<div class="loginbox">
			<center>
				<font size="50">足球俱乐部管理平台</font>
			</center>
			<form action=""
				method="post">
				<ul>
					<li><h5>用户名:</h5> <input name="username" type="text"
						class="loginuser" value="admin" onclick="JavaScript:this.value=''" /></li>
					<li><h5>密&nbsp;&nbsp;&nbsp;码:</h5> <input name="password"
						type="password" class="loginpwd" value=""
						onclick="JavaScript:this.value=''" /></li>
					<li><input type="submit" class="loginbtn" value="登录" /></li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>
