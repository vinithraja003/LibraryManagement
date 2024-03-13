var homepage="http://localhost:8080/home";
$(document).ready(function() {
	
	
	$(".submitstudent").on('click',function(){
		
		let data={
			studentId:"",
			sname : $('#sname').val(),
			branch : $('#branch').val(),
			rollnumber : $('#rollnumber').val(),
			
		}
		 console.log(data);
        	   $.ajax({
        		   type: "POST",
        		   contentType:"application/json;charset=utf-8",
        		   url: 'http://localhost:8080/saveStudent',
        		   data: JSON.stringify(data),
        		   dataType:'json',
        		   success: function(responce){
					  console.log(responce);
        			   alert('Student added successfully!');
        			    window.location=homepage;
        			   
        		   },
        		   error:function(e){
					   alert("Error");
					   console.log("error:",e);
				   }
        		 });
		
		
	});
	
	


	
});