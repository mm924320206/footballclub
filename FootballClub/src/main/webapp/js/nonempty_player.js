/**
 * 新增输入格式校验
 */
$(function(){
	$("input[name='name']").blur(function(){
        var value = $(this).val();
        if(value==""){
        	$("#sp1").html("<font color='red'>球员名称不能为空</font>");
            $("input[name='age']").focus();
        }
        else
        	{$("#sp1").html("");}
    });
	
	
	$("input[name='age']").blur(function(){
        var value = $(this).val();
        var reg = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
        var result = reg.test(value);
        
        if(!result){
        	$("#sp2").html("<font color='red'>年龄1-120之间</font>");
            $("input[name='age']").focus();
        }
        else
    	{$("#sp2").html("");}
    });

	
	$("input[name='salary']").blur(function(){
        var value = $(this).val();
        var reg = /^[1-9][0-9]{0,4}$/;
        var result = reg.test(value);
        if(!result){
        	$("#sp3").html("<font color='red'>薪资最大99999</font>");
            $("input[name='salary']").focus();
        }
        else
    	{$("#sp3").html("");}
    });

	

	$("input[name='photoaddress']").blur(function(){
        var value = $(this).val();
        if(value==""){
        	$("#sp4").html("<font color='red'>照片不能为空</font>");        
        }
        else
    	{$("#sp4").html("");}
    });
	
	
	
	$("input[name='select']").blur(function(){
        var value = $(this).val();
        if(value==""){
        	$("#sp4").html("<font color='red'>请选择球队</font>");      
        }
        else
    	{$("#sp5").html("");}
    });
	
});



