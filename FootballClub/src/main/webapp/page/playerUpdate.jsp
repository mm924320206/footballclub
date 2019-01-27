<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>球员修改</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/editor/kindeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/nonempty_player.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/non_submit.js"></script>

<script type="text/javascript">
	KE.show({
		id : 'content7',
		cssPath : './index.css'
	});
</script>

<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
<script type="text/javascript">
// 选择图片显示
function imgChange(obj) {
//获取点击的文本框
var file =document.getElementById("file");
var imgUrl =window.URL.createObjectURL(file.files[0]);
var img =document.getElementById('imghead');
img.setAttribute('src',imgUrl); // 修改img标签src属性值
};
</script>
</head>

<body>

	<div class="formbody">
		<div id="usual1" class="usual">
			<div id="tab1" class="tabson">
				<form action="${pageContext.request.contextPath }/playerUpdateByid" method="post"  enctype="multipart/form-data">
					<h2>球员修改</h2>
					<ul class="forminfo">
						<li><label>球员名称<b>*</b></label><span id="sp1"></span>
						 <input name="name" type="text" class="dfinput" style="width: 518px;" value=<s:property value="player.name"/>  msg="球员名称"></li>
						<li><label>球员年龄<b>*</b></label><span id="sp2"></span><input name="age" type="text"
							class="dfinput" style="width: 518px;" value=<s:property value="player.age"/>  msg="球员年龄"></li>
						<li><label>球员薪资<b>*</b></label><span id="sp3"></span> <input name="salary"
							type="text" class="dfinput" style="width: 518px;" value=<s:property value="player.salary"/> msg="球员薪资"></li>
						<li><label>照片<b>*</b></label><span id="sp4"></span> <input name="photoaddress"
							type="file"  id="file" accept="image/*" onchange="imgChange(this);" style="width: 518px;"  msg="照片"/></li>
						<li><label>球队<b>*</b></label><span id="sp5"></span>
							<div class="usercity">
								<div class="cityleft">
									<select id="select" name="select" class="select2" name="team.id" msg="球队">
										<!-- <option value="">巴塞罗那</option>
										<option value="">皇马</option> -->
									</select>
								</div>
							</div></li>
						
						<li><label>&nbsp;</label><input name="submit" type="submit" class="btn"
							value="保存" onclick="return checkNull()"/></li>
					</ul>
					<div><input type="hidden" name="id" value=<s:property value="player.id"/>></div>
				</form>
			</div>
			<img id="imghead" style="position:absolute;left:800px; top:50px" src=<s:property value="player.photoaddress"/> width="200"height="200" /> <!--图片显示位置-->
		</div>
	</div>
	<script type="text/javascript">
		$("#usual1 ul").idTabs();
	</script>
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
