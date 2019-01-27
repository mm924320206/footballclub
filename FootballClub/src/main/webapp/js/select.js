/**
 * 选择组件的单独js，
 */
$(function(){
	$.post("/football/selectShow",function(data){
		/*<option value="">巴塞罗那</option>
			<option value="">皇马</option>*/
		$("#select").html("");
		var json=eval("("+data+")");
		var html="";
		for(var i=0;i<json.length;i++)
			{
			html+="<option value=\""+json[i]+"\">"+json[i]+"</option>";
			}
		$("#select").html(html);
	})
});