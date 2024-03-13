




 $( document ).ready(function() {
	/*path  */
	     var home="http://localhost:8080/home";
	     var addBook="http://localhost:8080/addbook";
	     var listbook="http://localhost:8080/listbook";
	     var addStudent="http://localhost:8080/addstudent";
         var liststudent="http://localhost:8080/liststudent";
         var issueBook= "http://localhost:8080/issuebook";
         var transaction= "http://localhost:8080/transaction"; 
         var ReturnBook= "http://localhost:8080/returnBookpage"; 
         var Fine= "http://localhost:8080/fine"; 
         var Report= "http://localhost:8080/report"; 
	    
	   var header=`  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand Home">Library Management System</a>
    </div>
    
    <ul class="nav navbar-nav">
      <li class="active"><a class="Home">Home</a></li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" >Books<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a id="add_book">Add NewBook</a></li>
          <li><a id="List_Books">List of Books</a></li>
        </ul>
      </li>
      
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Students<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a  id="add_student">Add NewStudent</a></li>
          <li><a id="List_Students">List of Students</a></li>
        </ul>
      </li>
      
     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Issue & Return Book<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a id="issue_Book">Issue Book</a></li>
          <li><a id="returnBook">Return Book</a></li>
          <li><a id="TransactionPage">Transaction</a></li>
          <li><a id="Reportpage">Report</a></li>
        </ul>
      </li>
      
      
      <li><a id="fine">Fine</a></li>
    </ul>
  </div>`;
   $(".navbar").append(header);
   
   
     $('.Home').click(function(){
		 	 window.location=home ;	 
	 });
      $('#add_book').click(function(){
		 	 window.location=addBook ;	 
	 });
   
   	 $('#List_Books').click(function(){
		 	 window.location=listbook ;	 
	 });
	  $('#add_student').click(function(){
		 	 window.location=addStudent ;	 
	 });
	 $('#List_Students').click(function(){
		 	 window.location=liststudent ;	 
	 });
	 $('#issue_Book').click(function(){
		 	 window.location=issueBook ;	 
	 });
	 $('#TransactionPage').click(function(){
		 	 window.location=transaction ;	 
	 });
   	 $('#returnBook').click(function(){
		 	 window.location=ReturnBook ;	 
	 });
	 $('#fine').click(function(){
		 	 window.location=Fine ;	 
	 });
	  $('#Reportpage').click(function(){
		 	 window.location=Report ;	 
	 });
   
	});