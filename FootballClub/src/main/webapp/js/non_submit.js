/**
 * 保存按钮等不给按
 */

function checkNull()
	{
	     var num=0;
	     var str="";
	     $("input[type$='text']").each(function(n){
	          if($(this).val()=="")
	          {
	               num++;
	               str+="?"+$(this).attr("msg")+"不能为空！\r\n";
	          }
	     });
	     if( $("input[type$='file']").val()=="")
	     { num++;
         str+="?"+"照片不能为空！\r\n";
	     }
	     if( $("input[type$='team']").val()=="")
	     { num++;
         str+="?"+"球队不能为空！\r\n";
	     }
	     if(num>0)
	     {
	          alert(str);
	          return false;
	     }
	     else
	     {   	 
	          return true;
	    	
	     }
	}

