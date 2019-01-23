/**
 * 
 */
function del(id)
{
	var bool=confirm("确认删除吗？");
	if(bool==true)
	{var id=id;
	$.post("/football/playerdelete",{"id":id},function(data){
		if(data==1)
			{alert("删除成功!");
		window.location.replace("/football/page/playerList.jsp");}
		if(data==0)
			{alert("本行数据不存在，请重试!");
			window.location.reload();
			}
		
	});
	}
}
