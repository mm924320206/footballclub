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
	alert("ssa");
		$.post("/football/PlayList", {
		"pageNum" : pageNum,
		"totalPage" : totalPage,
		"totalCount" : totalCount,
		"currentCount":currentCount
	},function(data){
		alert("sss"+data);
	});
	});


/*function playerlist1(){
		var pageNum=1;
		var totalPage=0;
		var totalCount=0;
		var currentCount=5;
		alert("sst");
			$.post("/football/PlayList", {
			'pageNum': pageNum,
			'totalPage': totalPage,
			'totalCount': totalCount,
			'currentCount':currentCount
		},function(data){
			alert(data);
		});
			alert("ssa");
	}*/