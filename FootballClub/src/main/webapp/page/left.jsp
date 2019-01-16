<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>功能菜单</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/js/playerlist.js"></script> --%>

<script type="text/javascript">
$(function(){	
	//导航切换
 	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	}); 
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>足球俱乐部</div>
    <dl class="leftmenu">
    <dd>
    	<ul class="menuson">
        <li><cite></cite><a  href="${pageContext.request.contextPath }/page/playerList.jsp" target="rightFrame">球员管理</a><i></i></li>
        </ul>    
    </dd>
    </dl>
</body>
</html>
