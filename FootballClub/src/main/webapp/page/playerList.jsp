<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>球员列表展示</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/playerlist.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$(".click").click(function() {
			$(".tip").fadeIn(200);
		});

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
		});

	});
</script>
</head>
<body>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li class="click"><a href="${pageContext.request.contextPath }/page/playerAdd.jsp"><span> <img
							src="${pageContext.request.contextPath }/images/t01.png" /></span>添加</li>
				</a>
			</ul>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th>ID</th>
					<th>照片</th>
					<th>名称</th>
					<th>年龄</th>
					<th>薪资</th>
					<th>创建日期</th>
					<th>所属球队</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td><img alt="" src="${pageContext.request.contextPath }/images/meixi.jpg" style="width: 100px;height: 100px;"></td>
					<td>梅西</td>
					<td>30</td>
					<td>300000</td>
					<td>2017-11-14</td>
					<td>巴塞罗那</td>
					<td><a href="${pageContext.request.contextPath }/page/playerUpdate.jsp" class="tablelink">修改</a>|<a href="#"
						class="tablelink">删除</a></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
