/**
 * 解决分页条的数字点击刷新列表问题
 */
function prePage(s){
			pageNum=s-1;
			showPage(pageNum);
		}
function nextPage(s){
			pageNum=s+1;
			showPage(pageNum);
		}
function selectPage(n){
			pageNum=n;
			showPage(pageNum);
		}
function showPage(s){
	var pageNum=s;
	var totalPage=0;
	var totalCount=0;
	var currentCount=5;
	$("#msg").html("");
	$.post("/football/PlayList", {
		"pageNum" : pageNum,
		"totalPage" : totalPage,
		"totalCount" : totalCount,
		"currentCount":currentCount
	},function(data){
		var json=eval("("+data+")");
		var html="";
		var jsonObj=json.currentContent;
		for(var i=0;i<jsonObj.length;i++)
{html+="<tr><td>"+((json.pageNum-1)*json.currentCount+i+1)+"</td><td>"+jsonObj[i].photoaddress+"</td><td>"+jsonObj[i].name+"</td><td>"+jsonObj[i].age+"</td><td>"+jsonObj[i].salary+"</td><td>"+jsonObj[i].createdate+"</td><td>"+jsonObj[i].team.name+"</td><td><a href=\"${pageContext.request.contextPath}/page/playerUpdate.jsp\" class=\"tablelink\">修改</a>|<a href=\"#\"class=\"tablelink\">删除</a></td></tr>"}
		$("#msg").html(html);
		pageNum=json.pageNum;
		currentCount=json.currentCount;
		totalCount=json.totalCount;
		totalPage=json.totalPage;
		var pageHtml="<ul class=\"pagination\">";
		if(pageNum==1)
			{pageHtml+="<li id=\"next\" class=\"disabled\"><a href=\"#\">&laquo;</span></a></li>"}
		else
			{pageHtml+="<li id=\"next\" ><a href=\"#\" onclick=\"prePage(pageNum)\"><span aria-hidden=\"true\">&laquo;</span></a></li>"}
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
			{pageHtml+="<li><a href=\"#\" onclick=\"nextPage(pageNum)\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>"}
		
		$("#page").html(pageHtml);
	});
	
	
	
}