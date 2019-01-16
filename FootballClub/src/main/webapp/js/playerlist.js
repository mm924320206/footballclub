/**
 * private int pageNum;
	private int totalPage;
	private int totalCount;
	private int currentCount;
	private List<T> currentCounts;
 */
$(function(){
	
	var pageNum=2;
	var totalPage=0;
	var totalCount=0;
	var currentCount=5;
	
		$.post("/football/PlayList", {
		"pageNum" : pageNum,
		"totalPage" : totalPage,
		"totalCount" : totalCount,
		"currentCount":currentCount
		/*<tr>
		<td>1</td>
		<td><img alt="" src="${pageContext.request.contextPath }/images/meixi.jpg" style="width: 100px;height: 100px;"></td>
		<td>梅西</td>
		<td>30</td>
		<td>300000</td>
		<td>2017-11-14</td>
		<td>巴塞罗那</td>
		<td><a href="${pageContext.request.contextPath }/page/playerUpdate.jsp" class="tablelink">修改</a>|<a href="#"
			class="tablelink">删除</a></td>
	</tr>*/
	},function(data){
		var json=eval("("+data+")");
		var html="";
		var jsonObj=json.currentContent;
		for(var i=0;i<jsonObj.length;i++)
		/*{"age":18,"createdate":"2018-12-01 00:00:00","name":"xxx","photoaddress":"xxx","salary":3000,"team":{"name":"皇马"}}*/
{html+="<tr><td>"+((json.pageNum-1)*json.currentCount+i+1)+"</td><td>"+jsonObj[i].photoaddress+"</td><td>"+jsonObj[i].name+"</td><td>"+jsonObj[i].age+"</td><td>"+jsonObj[i].salary+"</td><td>"+jsonObj[i].createdate+"</td><td>"+jsonObj[i].team.name+"</td><td><a href=\"${pageContext.request.contextPath}/page/playerUpdate.jsp\" class=\"tablelink\">修改</a>|<a href=\"#\"class=\"tablelink\">删除</a></td></tr>"}
		$("#msg").html(html);
		alert("sss");
		/*"currentCount":5,"pageNum":1,"totalCount":17,"totalPage":4*/
		//分页条功能
		pageNum=json.pageNum;
		currentCount=json.currentCount;
		totalCount=json.totalCount;
		totalPage=json.totalPage;
		/*<ul class="pagination">
	    <li class="disabled">
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <li class="active"><a href="#" onclick="select(i)">1</a></li>
	    <li><a href="#">2</a></li>
	    <li><a href="#">3</a></li>
	    <li><a href="#">4</a></li>
	    <li><a href="#">5</a></li>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>*/
		//《》能不能被点击，在不在第一页也和最后一页
		var pageHtml="<ul class=\"pagination\">";
		if(pageNum==1)
			{pageHtml+="<li class=\"disabled\"><a href=\"#\">&laquo;</span></a></li>"}
		else
			{pageHtml+="<li><a href=\"#\" onclick=\"prePage()\"><span aria-hidden=\"true\">&laquo;</span></a></li>"}
		//数字部分要写在中间。。。
		for(var i=1;i<=totalPage;i++)
		{
		if(i==pageNum)
			{pageHtml+="<li class=\"active\"><a href=\"#\" onclick=\"selectPage("+i+")\">"+i+"</a></li>"}
		else
			{pageHtml+="<li><a href=\"#\" onclick=\"selectPage("+i+")\">"+i+"</a></li>"}
		}
		if(pageNum==totalPage)
			{pageHtml+="<li class=\"disabled\"><a href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>"}
		else
			{pageHtml+="<li><a href=\"#\" onclick=\"nextPage()\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>"}
		
		$("#page").html(pageHtml);
	});
		
		
		
		function prePage(){
			pageNum=pageNum-1;
			showPage(pageNum);
		}
		function nextPage(){
			pageNum=pageNum+1;
			showPage(pageNum);
		}
		function selectPage(n){
			pageNum=n;
			showPage(pageNum);
		}
function showPage(s){
	$("#msg").html("");
	$.post("/football/PlayList", {
		"pageNum" : s,
		"totalPage" : totalPage,
		"totalCount" : totalCount,
		"currentCount":currentCount
	},function(data){
		var json=eval("("+data+")");
		var html="";
		var jsonObj=json.currentContent;
		for(var i=0;i<jsonObj.length;i++)
		/*{"age":18,"createdate":"2018-12-01 00:00:00","name":"xxx","photoaddress":"xxx","salary":3000,"team":{"name":"皇马"}}*/
{html+="<tr><td>"+(json.pageNum+i)+"</td><td>"+jsonObj[i].photoaddress+"</td><td>"+jsonObj[i].name+"</td><td>"+jsonObj[i].age+"</td><td>"+jsonObj[i].salary+"</td><td>"+jsonObj[i].createdate+"</td><td>"+jsonObj[i].team.name+"</td><td><a href=\"${pageContext.request.contextPath}/page/playerUpdate.jsp\" class=\"tablelink\">修改</a>|<a href=\"#\"class=\"tablelink\">删除</a></td></tr>"}
		$("#msg").html(html);
		alert("sss");
		/*"currentCount":5,"pageNum":1,"totalCount":17,"totalPage":4*/
		//分页条功能
		pageNum=json.pageNum;
		currentCount=json.currentCount;
		totalCount=json.totalCount;
		totalPage=json.totalPage;
		var pageHtml="<ul class=\"pagination\">";
		if(pageNum==1)
			{pageHtml+="<li class=\"disabled\"><a href=\"#\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>"}
		else
			{pageHtml+="<li><a href=\"#\" onclick=\"prePage()\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>"}
		if(pageNum==totalPage)
			{pageHtml+="<li class=\"disabled\"><a href=\"#\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>"}
		else
			{pageHtml+="<li><a href=\"#\" onclick=\"nextPage()\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>"}
		
		//中间部分数字按钮
		for(var i=1;i<=totalPage;i++)
			{
			if(i==pageNum)
				{pageHtml+="<li class=\"active\"><a href=\"#\" onclick=\"selectPage("+i+")\">"+i+"</a></li>"}
			else
				{pageHtml+="<li><a href=\"#\" onclick=\"selectPage("+i+")\">"+i+"</a></li>"}
			}
		$("#page").html(pageHtml);
	});
		
}
	});
