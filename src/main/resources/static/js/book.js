var homepage="http://localhost:8080/home";
$(document).ready(function() {
	
	
	$(".submitbook").on('click',function(){
		
		let data={
			book_id:"",
			bookname : $('#book_name').val(),
			author : $('#author').val(),
			isbm_no : $('#isbm').val(),
			copies : $('#copies').val(),
			category : $('#category').val(),
			bookprice : $('#book_price').val(),		
		}
		 console.log(data);
        	   $.ajax({
        		   type: "POST",
        		   contentType:"application/json;charset=utf-8",
        		   url: 'http://localhost:8080/savebook',
        		   data: JSON.stringify(data),
        		   dataType:'json',
        		   success: function(responce){
					  console.log(responce);
        			   alert('book added');
        			    window.location=homepage;
        			   
        		   },
        		   error:function(e){
					   alert("Error");
					   console.log("error:",e);
				   }
        		 });
		
		
	});
	
	
	
});

