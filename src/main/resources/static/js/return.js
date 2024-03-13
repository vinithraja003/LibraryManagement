$('.returnBook').click(function(){
	
	   var sname=$('#sname').val();
	   var rollnumber=$('#rollnumber').val();
	   var bookname=$('#book_name').val();
	   var isbm=$('#isbm').val();
	      if(sname!="" && rollnumber!="" && bookname!=""&&isbm!=""){
			  //alert(sname+rollnumber+bookname+isbm);
			  
			  		 
	                   let data={
	                  	issue_Sname :sname,
		             	issue_Rollnumber : rollnumber,
			            isbm_No : isbm,
			            bookname : bookname,
				
		               }
		        var fine;
        	   $.ajax({
        		   type: "POST",
        		   contentType:"application/json;charset=utf-8",
        		   url: 'http://localhost:8080/returnbook',
        		   data: JSON.stringify(data),
        		   dataType:'json',
        		   success: function(responce){
					  console.log(responce);
        			fine=responce.fine;
        			//console.log(typeof(fine));
        			
        			if(fine!=0 ){
						payfine(fine);
					}else{
						alert("success return")
					}
        			   
        		   },
        		    
        		   error:function(e){
					   alert("wrong data");
					   console.log("error:",e);
				   }
				   
        		 });
		 
			  
			  
			  
			  
		  }
		 else{
			 alert("please fill input filed!")
		 }

		 
		 
		 
});
function payfine(fine){
	$('.returnBook').css("display","none");
	$('.pay').css("display","block");
	$('.fine').css("display","block");
	$('#fine_amount').val("Rs:"+fine);
}


$('.pay').click(function(){
	
	   var sname=$('#sname').val();
	   var rollnumber=$('#rollnumber').val();
	   var bookname=$('#book_name').val();
	   var isbm=$('#isbm').val();
	   var fine=$('#fine_amount').val();
	      if(sname!="" && rollnumber!="" && bookname!=""&&isbm!=""){
			  //alert(sname+rollnumber+bookname+isbm);
			  
			  		 
	                   let data={
	                  	issue_Sname :sname,
		             	issue_Rollnumber : rollnumber,
			            isbm_No : isbm,
			            bookname : bookname,
				         fine:fine,
		               }
		        var fine;
        	   $.ajax({
        		   type: "POST",
        		   contentType:"application/json;charset=utf-8",
        		   url: 'http://localhost:8080/returnbook/pay',
        		   data: JSON.stringify(data),
        		   dataType:'json',
        		   success: function(responce){
					 alert("Successfully Return");
        			   clear();
        		   },
        		    
        		   error:function(e){
					   alert("Error");
					   console.log("error:",e);
				   }
				   
        		 });
		 
			  
			  
			  
			  
		  }
		 else{
			 alert("please fill input filed!")
		 } 
		 
		 
});

function clear(){
		  $('#sname').val("");
	     $('#rollnumber').val("");
	     $('#book_name').val("");
	     $('#isbm').val("");
	$('.returnBook').css("display","block");
	$('.pay').css("display","none");
	$('.fine').css("display","none");
	
}