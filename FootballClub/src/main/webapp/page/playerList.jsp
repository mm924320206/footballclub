<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>球员列表展示</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/playerlist.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/pagebean.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/playerdelete.js"></script>

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
							src="${pageContext.request.contextPath }/images/t01.png" /></span></a>添加</li>
			</ul>
		</div>
		<div>
		<nav id="page" aria-label="Page navigation" >
  <!-- <ul class="pagination">
    <li class="disabled">
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="active"><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul> -->
</nav>
</div>

		<table class="table table-hover table-bordered">
			<thead>
				<tr class="info">
					<th>ID</th>
					<!-- <th style="display:none">realID</th> -->
					<th>照片</th>
					<th>名称</th>
					<th>年龄</th>
					<th>薪资</th>
					<th>创建日期</th>
					<th>所属球队</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="msg">
				<%-- <tr>
					<td>1</td>
					<td><img alt="" src="${pageContext.request.contextPath }/images/meixi.jpg" style="width: 100px;height: 100px;"></td>
					<td>梅西</td>
					<td>30</td>
					<td>300000</td>
					<td>2017-11-14</td>
					<td>巴塞罗那</td>
					<td><a href="${pageContext.request.contextPath }/page/playerUpdate.jsp" class="tablelink">修改</a>|<a href="#"
						class="tablelink">删除</a></td>
				</tr> --%>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
