var GetAllstudent='http://localhost:8080/allStudents';
var stdId='http://localhost:8080/allstudent/';
var issuebook='http://localhost:8080/liststudent/issuebook/';
 var listStudent;
 var tabledata="";

   $.ajax({
     		   type: "GET",
     		   url: GetAllstudent,
     		   
     		   success: function(response){
					   console.log(response);
					    listStudent=response;
					   response.forEach(function(data){
						   tabledata+='<tr>'+
						  // '<td>'+data.studentId+'</td>'+
						    '<td>'+data.sname+'</td>'+
						     '<td>'+data.branch+'</td>'+
						      '<td>'+data.rollnumber+'</td>'+
						        '<td>'+
						            '<button type="button" class="btn btn-success btn-md" onclick="info('+data.rollnumber+')">Info Student</button>'+
						            '<button type="button" class="btn btn-danger btn-md">Delete</button>'+
						         '</td>'+
						        '</tr>' ; 
					          			   
     		   });
     		   $('#show_table>tbody').html(tabledata);
     		   },
     		   error:function(response)
     		   {
					  
					   console.log("error:",response);
				   }
				  
        });
 
 
    
 $('#search_student').click(function(){
	 var studentlist_category= $("#studentlist_category").val();
	 var student_value= $("#student_value").val();
	 var store = [];
	 var flag=false;
	 for (const key in listStudent) {
          console.log(key, listStudent[key]);
          
         if( listStudent[key][studentlist_category]==student_value){
        	 store.push(listStudent[key]);
        	 flag=true;
          }
         
      }
	 console.log(store);
	 if(flag==true){
	          var currentdata;
	          store.forEach(function(data){
		   currentdata+='<tr>'+
						 //  '<td>'+data.studentId+'</td>'+
						    '<td>'+data.sname+'</td>'+
						     '<td>'+data.branch+'</td>'+
						      '<td>'+data.rollnumber+'</td>'+
		           '<td>'+
		            '<button type="button" class="btn btn-success btn-md" onclick="info('+data.rollnumber+')">Info Student</button>'+
		            '<button type="button" class="btn btn-danger btn-md">Delete</button>'+
		            '</td>'+
		        '</tr>' ; 
	          			   
               });
                 $('#show_table>tbody').html(currentdata);
                 $("#student_value").val("");
	 }else if(student_value==""){
		          location.reload();
	 }
	 else{
		 alert("please enter correct value!")
	 }	
});


/*   Issue Info */
 function info(rollno){
	  $('.container').css("display","block");
	//get student controller	 
	  $.ajax({
     		   type: "GET",
     		   url: stdId+rollno,
     		   
     		   success: function(data){
					console.log("stdid")
					   console.log(data);
					    $('#student_name').val(data.sname);
	                    $('#roll_number').val(data.rollnumber);
	                    $('#branch').val(data.branch);
					   },
	      	   error:function(e){
					   alert("Error");
					   console.log("error:",e);
				   }
           });
	 
	   
	  //transaction controller
	       $.ajax({
        		   type: "GET",
        		   contentType:"application/json;charset=utf-8",
        		   url: issuebook+rollno,       		 
        		   success: function(data){
					    console.log(data);
					   var textare="";
					   var fine="";
		                 for(let i=0;i<data.length;i++){
			                 textare+="ISBM: "+data[i].isbm_No+" - "+"BookName: "+data[i].bookname+" - "+
			                   "Return Date:"+data[i].expected_Date+"\n";
			          //fine added
        			      fine+= parseInt(data[i].fine);
					  }
					 $(".issuedata").val(textare);
					 $("#fine_amount").val(fine);
					
				
              			   
        		   },
        		   
        		   error:function(e){
					   alert("Error");
					   console.log("error:",e);
				   }
           });
        		
 
 }
 
 
 $('.back-btn').click(function(){
	 $(".issuedata").val("");
	 $('.container').css("display","none");
	  
	 
 });
 

 
  //pagination:
 function pagination(){
	 
 //var allstudent='http://localhost:8080/student';
 let allstudent='http://localhost:8080/filter';
 var pagesize=$('#table_size').val();
   value=$('#tab_filter_text').val();
  
   countRecord(value);
 tab_end=$('#table_size').val();
 var data={
	pageNo:current_index,
    pageSize:pagesize,
    search_name:value
    
 }
 
 $.ajax({
	  type:"POST",
	  url:allstudent,
	  contentType:"application/json;charset=utf-8",	  
      data: JSON.stringify(data),
      dataType:'json',
	 
	  success: function(response){
					   console.log(response);
				
     		        valueset(response);
	   },
	     error:function(e){
					   alert("Error");
					   console.log("error:",e);
				   }
	   
	  
      });
 
 }
 //search value
 $('#tab_filter_btn').click(function(){
	 search_pagination();

});
function search_pagination(){
		      let allstudent='http://localhost:8080/filter';
	  //let allstudent='http://localhost:8080/nativeQuery/allstudent';
            let pagesize=$('#table_size').val();
            let pageNo=current_index;
            value=$('#tab_filter_text').val();
        countRecord(value); 
         tab_end=$('#table_size').val(); 
            let data={
				pageSize:pagesize,
				pageNo:pageNo,
				search_name:value
			}
    $.ajax({
	  type:"POST",
	  url:allstudent,
	  contentType:"application/json;charset=utf-8",	  
      data: JSON.stringify(data),
      dataType:'json',
	 
	  success: function(response){
					   console.log(response);
					   valueset(response);
					   },
	  error:function(e){
					   alert("Error");
					   console.log("error:",e);
				   }
            
            });
}
var value;
 var array=[];
 var arr_length=0;
 var table_size=0;
 var max_indexButton=0;
 var current_index=1;
  var tab_start=0;
 var tab_end=0;
 
 function countRecord(value){
	 if(value==""){
		  var record='http://localhost:8080/nativeQuery/allstudent/record';
	 }else{
		 var record='http://localhost:8080/nativeQuery/allstudent/record/'+value;
	 }
	   
	       $.ajax({
	  type:"GET",
	  url:record, 
	  success: function(record){
					   console.log(record);
					   arr_length=record;
					   }
            
      });
 }
 function valueset(response){
	 
	    array=response;
	  	table_size=parseInt($('#table_size').val());
	     
	   displayIndexButton();
	  check();
 }
 function check(){
	 console.log(arr_length);
	 console.log(table_size);
	 console.log(max_indexButton);
	 console.log(array);
 }
 
 
 
 
  function preLoadcalculate(){
	 
	 //filter_list();
	
	 max_indexButton=parseInt(arr_length/table_size);
	      if(arr_length%table_size>0){
	    	  max_indexButton++;
	      }
 }
 function displayIndexButton(){
	 
	 $('.index_button button').remove();
	   
	    preLoadcalculate();
	    $('.index_button').append('<button onclick="prev()" class="previous">Previous</button>');
	    
	    for(let i=1;i<=max_indexButton;i++){
	    	 $('.index_button').append('<button onclick="indexPagination('+i+')" index="'+i+'" >'+i+'</button>');
	    	 
	    }
	    $('.index_button').append('<button onclick="next()" class="next">Next</button>');
	    highlightbutton();
 }
 
 
 function highlightbutton(){

	
	start_index=((current_index-1)*table_size)+1;
	end_index=(start_index+table_size)-1;
	
	    if(end_index>arr_length){
	    	end_index=arr_length;
	    }
	 
	       $(".footer span").text('showing '+ start_index+' to '+end_index+' of '+arr_length+' entity');
	    $('.index_button button').removeClass('active');
	    $('.index_button button[index="'+current_index+'"]').addClass('active');
	     
	  
	   displayTableRow();
 }
 function displayTableRow(){
	 $('#pagination_table tbody tr').remove();
	
	   for(let i=tab_start;i<tab_end;i++){
		   var pagination_table='<tr><td>'+array[i].sname+'</td><td>'+array[i].branch+'</td><td>'+array[i].rollnumber+'</td></tr>';
	       $('#pagination_table tbody').append(pagination_table);
	   }
 }
  function next(){
	 if(current_index<max_indexButton){
		 current_index++;
		 	 if(value=="") {
		 pagination();
	 }else{
		 search_pagination();
	 }
		
		 highlightbutton();
		 
		 $('.previous').removeAttr("style");
	 }else{
		 $('.next').css({"cursor":" not-allowed","pointer-events":" none"});
	 }

 } 
 function prev(){
	 if(current_index>1){
		 current_index--;
		 	 if(value=="") {
		 pagination();
	 }else{
		 search_pagination();
	 }
		 highlightbutton();
		 
		 $('.next').removeAttr("style");
	 }else{
		 $('.previous').css({"cursor":" not-allowed","pointer-events":" none"});
	 }

 }
 function indexPagination(index){
	 current_index=index;
	 if(value=="") {
		 pagination();
	 }else{
		 search_pagination();
	 }
		 
	 
	 highlightbutton();
	 
	 $('.previous').removeAttr("style");
	 $('.next').removeAttr("style");
 }
  $('#table_size').change(function(){
	 //alert($(this).val())
	table_size=parseInt($(this).val());
	current_index=1;
		 if(value=="") {
		 pagination();
	 }else{
		 search_pagination();
	 }
	
	start_index=1;
	
 });
 
 
 

 
 