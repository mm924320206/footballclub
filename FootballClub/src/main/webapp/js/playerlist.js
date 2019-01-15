/**
 * private int pageNum;
	private int totalPage;
	private int totalCount;
	private int currentCount;
	private List<T> currentCounts;
 */
$(function(){
	var pageNum=1;
	var totalPage=0;
	var totalCount=0;
	var currentCount=5;
	$.post("/footballClub/action/PlayList", {
		" pageNum" : pageNum,
		"totalPage" : totalPage,
		"totalCount" : totalCount,
		"currentCount":currentCount
	},function(data){
		alert("sss");
	})
},json);