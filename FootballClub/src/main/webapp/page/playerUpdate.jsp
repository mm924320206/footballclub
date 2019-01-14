<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>球员修改</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/editor/kindeditor.js"></script>

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
</head>

<body>

	<div class="formbody">
		<div id="usual1" class="usual">
			<div id="tab1" class="tabson">
				<form action="playerList.jsp">
					<h2>球员修改</h2>
					<ul class="forminfo">
						<li><label>球员名称<b>*</b></label> <input name="name"
							type="text" class="dfinput" style="width: 518px;" /></li>
						<li><label>球员年龄<b>*</b></label> <input name="age" type="text"
							class="dfinput" style="width: 518px;" /></li>
						<li><label>球员薪资<b>*</b></label> <input name="salary"
							type="text" class="dfinput" style="width: 518px;" /></li>
						<li><label>照片<b>*</b></label> <input name="file"
							type="file"  style="width: 518px;" /></li>
						<li><label>球队<b>*</b></label>
							<div class="usercity">
								<div class="cityleft">
									<select class="select2" name="team.id">
										<option value="">巴塞罗那</option>
										<option value="">皇马</option>
									</select>
								</div>
							</div></li>
						<li><label>&nbsp;</label><input type="submit" class="btn"
							value="保存" /></li>
					</ul>
				</form>
			</div>
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
