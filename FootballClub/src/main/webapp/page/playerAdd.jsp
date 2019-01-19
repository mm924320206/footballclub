<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags"%>
	
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>球员添加</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/editor/kindeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/playeradd.js"></script>

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
				<form action="${pageContext.request.contextPath}/player_add" method="post"  enctype="multipart/form-data">
					<div class="form-group col-md-6 col-md-offset-3">
					<h2>球员添加</h2>
    			 <label for="name">球员名称</label>
   				 <input type="text" class="form-control" name="name" style="width: 518px;">
  				</div>
  				<div class="form-group col-md-6 col-md-offset-3">
    			 <label for="age">球员年龄</label>
   				 <input type="text" class="form-control" name="age" style="width: 518px;">
  				</div>
  				<div class="form-group col-md-6 col-md-offset-3">
    			 <label for="salary">球员薪资</label>
   				 <input type="text" class="form-control" name="salary" style="width: 518px;">
  				</div>
  				<div class="form-group col-md-6 col-md-offset-3">
    			 <label for="photoaddress">照片</label>
   				 <input type="file" name="photoaddress" >
  				</div>
				<div class="form-group col-md-6 col-md-offset-3">
    			 <label for="team">球队</label>
   				 <select id="select" name="select" class="form-control" style="width: 300px;">
  					<!-- <option value="">巴塞罗那</option>
  					<option value="">皇马</option> -->
				</select>
  				</div>
  				<div class="form-group col-md-6 col-md-offset-3">
				 <button type="submit" class="btn btn-default ">保存</button>
				 </div>
					
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
