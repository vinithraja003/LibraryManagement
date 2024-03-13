var GetAllBooks='http://localhost:8080/allbook';

 
 var listbook;
 var tabledata="";
   $.ajax({
     		   type: "GET",
     		   url: GetAllBooks,
     		   
     		   success: function(response){
					   console.log(response);
					   listbook=response;
					   response.forEach(function(data){
						   tabledata+='<tr>'+
						   '<td>'+data.isbm_no+'</td>'+
						    '<td>'+data.bookname+'</td>'+
						     '<td>'+data.author+'</td>'+
						      '<td>'+data.category+'</td>'+
						      '<td>'+data.copies+'</td>'+
						        '<td>'+data.bookprice+'</td>'+
						           '<td>'+
						            '<button type="button" class="btn btn-success btn-md" onclick="issue_book('+data.bookId+')">Info book</button>'+
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
 
 $('#search_book').click(function(){
	 var booklist_category= $("#booklist_category").val();
	 var book_value= $("#book_value").val();
	 var store = [];
	 var flag=false;
	 
	 for (const key in listbook) {
          console.log(key, listbook[key]);
          
         if( listbook[key][booklist_category]==book_value){
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
		        '<td>'+data.bookprice+'</td>'+
		           '<td>'+
		            '<button type="button" class="btn btn-success btn-md" onclick="issue_book('+data.bookId+')">Info book</button>'+
		            '<button type="button" class="btn btn-danger btn-md">Delete</button>'+
		            '</td>'+
		        '</tr>' ; 
	          			   
});
$('#show_table>tbody').html(currentdata);
 $("#book_value").val("");
	 }else if(book_value==""){
		 location.reload();
	 }
	 else{
		 alert("please enter correct value!")
	 }	
});

function issue_book(bookid){
	 
	alert(bookid)
	// window.location=issuebook;

	
	 	/*      
        		  $.ajax({
        		   type: "GET",
        		   contentType:"application/json;charset=utf-8",
        		   url: 'http://localhost:8080/book/issuebook/'+bookid,
        		
        		 
        		   success: function(responce){
					   newdata=responce;
					  console.log(responce);
        			   alert('book added');
        			   window.location=issuebook;
        			   
        		   },
        		   error:function(e){
					   alert("Error");
					   console.log("error:",e);
				   }
        		 });
        		 
        		 */

	
	}
	
	


