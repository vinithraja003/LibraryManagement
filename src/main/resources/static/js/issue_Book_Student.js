var GetAllStudent='http://localhost:8080/allStudents';
var listStudent;
var storeStu = [];

var store=[];
   $.ajax({
     		   type: "GET",
     		   url: GetAllStudent,
     		   success: function(response){
					   console.log(response);
					    listStudent=response;
	           },
     		   error:function(response)
     		   {				  
				  console.log("error:",response);
			   }
				  
        });
        
        
 $('#search_student').click(function(){
	 
	 $('#show_table_student').css('display','block');
	 var studentlist_category= $("#studentlist_category").val();
	 var student_value= $("#student_value").val();
	 
	 var flag=false;
	 for (const key in listStudent) {
          console.log(key, listStudent[key]);
          
         if( listStudent[key][studentlist_category]==student_value){
	//store value
        	 store.push(listStudent[key]);
        	 flag=true;
          }
         
      }
	 console.log(store);
	 if(flag==true){
	          var currentdata;
	          store.forEach(function(data){
		   currentdata+='<tr>'+
		   '<td>'+data.sname+'</td>'+
		    '<td >'+data.branch+'</td>'+
		     '<td>'+data.rollnumber+'</td>'+
		           '<td>'+
		            '<button type="button" class="btn btn-success btn-md" onclick="student_data('+data.rollnumber+')">Click</button>'+
		           '</td>'+
		        '</tr>' ;
		       			   
               });
                  //console.log(store=[]);   
		         storeStu=store;  
		         store=[]; 
                 $('#show_table_student >tbody').html(currentdata);
                 $("#student_value").val("");
	 }else if(student_value==""){
		          location.reload();
	 }
	 else{
		 alert("please enter correct value!")
	 }	
	 
});

function student_data(rollno){
	 
	//alert(rollno);
	console.log(storeStu);
	     for (const key in storeStu) {
			//  console.log(key, store[key]);
			   if( storeStu[key].rollnumber==rollno){
				      //console.log(key, storeStu[key]);
				    
				      $("#student_name").val(storeStu[key].sname);
				      $("#roll_number").val(storeStu[key].rollnumber);
				    
				     
				   }
		 }
		 
$('#show_table_student').css('display','none');
	
	}
	
	
	
	
//get all books:

var GetAllBooks='http://localhost:8080/allbook';
 var listbook;
 var storeBook = [];
   $.ajax({
     		   type: "GET",
     		   url: GetAllBooks,
     		   success: function(response){
					   console.log(response);
					    listbook=response;
	           },
     		   error:function(response)
     		   {				  
				  console.log("error:",response);
			   }
				  
        });
        
        
 $('#search_book').click(function(){
	 $('#show_table_book').css('display','block');
	 
	 $('#show_table_book').css('display','block');
	 var booklist_category= $("#booklist_category").val();
	 var book_value= $("#book_value").val();
	 
	 var flag=false;
	 for (const key in listbook) {
          console.log(key, listbook[key]);
          
         if( listbook[key][booklist_category]==book_value){
	//storeBook value
        	 store.push(listbook[key]);
        	 flag=true;
          }
         
      }
	 console.log(store);
	 if(flag==true){
	          var currentdata;
	          store.forEach(function(data){
		   currentdata+='<tr>'+
		   '<td>'+data.isbm_no+'</td>'+
		    '<td >'+data.bookname+'</td>'+
		     '<td>'+data.author+'</td>'+
		       '<td>'+data.category+'</td>'+
		        '<td>'+data.copies+'</td>'+
		           '<td>'+
		            '<button type="button" class="btn btn-success btn-md" onclick="book_data('+data.bookId+')">Click</button>'+
		           '</td>'+
		        '</tr>' ;        			   
               });
               storeBook=store;  
		         store=[]; 
                 $('#show_table_book >tbody').html(currentdata);
                  $("#book_value").val("");
                
	 }else if(book_value==""){
		          location.reload();
	 }
	 else{
		 alert("please enter correct value!")
	 }	
});

function book_data(bookId){
	 
	//alert(rollno);
	console.log(storeBook);
	     for (const key in storeBook) {
			//  console.log(key, storeBook[key]);
			   if( storeBook[key].bookId==bookId){
				      //console.log(key, storeBook[key]);
				    
				      $("#book_name").val(storeBook[key].bookname);
				      $("#author").val(storeBook[key].author);
				      $("#isbm").val(storeBook[key].isbm_no);
				    
				     
				   }
		 }
		 
$('#show_table_book').css('display','none');
	
	}
	
	
	
//Issue book  data in table:

$(".issue_Book_Student").click(function(){
	 var yourcopie=$('#copies').val();
	 var copies= storeBook[0].copies;
	 
	
	
	
	if(copies-yourcopie>=0){

		      		      
		let data={
			issueId:"",
			issue_Sname : $('#student_name').val(),
			issue_Rollnumber : $('#roll_number').val(),
			isbm_No : $('#isbm').val(),
			bookname : $('#book_name').val(),
			issue_Copies:$('#copies').val(),
			issue_Date : "",
			expected_Date : "",
			actual_Return : "",
			fine:0,
		
		}
		 console.log(data);
           $.ajax({
        		   type: "POST",
        		   contentType:"application/json;charset=utf-8",
        		   url: 'http://localhost:8080/issuebook',
        		   data: JSON.stringify(data),
        		   dataType:'json',
        		   success: function(responce){
					   alert("Success...");
					    console.log(responce)
	           },
     		   error:function(response)
     		   {				  
				  console.log("error:",response);
			   }
				  
        });  
	}
	
});
	
	/* Clear Form */

$(".issue_Clear").click(function(){
					 $("#student_name").val("");
				      $("#roll_number").val("");
				     $("#book_name").val("");
				      $("#author").val("");
				      $("#isbm").val("");
				      $('#copies').val("");
	});