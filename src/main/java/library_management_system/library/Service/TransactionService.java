package library_management_system.library.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import library_management_system.library.Dao.BookDao;
import library_management_system.library.Dao.TransactionDao;
import library_management_system.library.Entity.BookEntity;
import library_management_system.library.Entity.IssuebookTransaction;
import library_management_system.library.pageRequest.Utility;



@Service
public class TransactionService {
	@Autowired
	private TransactionDao Tdao;

	@Autowired(required=true)
	private BookDao bookdao;
	

	
	
//issue book store in DB 	
  public IssuebookTransaction savedata(IssuebookTransaction transaction) {
			
		
    //Today Date
		  DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		  String Today_date= formatter.format(new Date());
   //add 30days		 
		 Calendar c = Calendar.getInstance();
		 c.add(Calendar.DATE, 30);
		 String rdate=formatter.format(c.getTime());
		 
		 System.out.println(Today_date);
		 System.out.println(rdate);
		 
		 /* set date value in IssuebookTransaction DB */
		 transaction.setIssue_Date(Today_date);
		 transaction.setExpected_Date(rdate);
		 
	    String isbm_no=transaction.getIsbm_No();
	/* get book object to modify copies and set value in book DB*/
	    BookEntity book=bookdao.search_isbm(isbm_no);
	     int copies=Integer.parseInt(book.getCopies())-Integer.parseInt(transaction.getIssue_Copies());
	     book.setCopies(Integer.toString(copies));
	           bookdao.save(book);
			
		return Tdao.save(transaction);
	}

  
  

      
//Get All Data in DB
	public List<IssuebookTransaction> listdata() {
		//List<IssuebookTransaction> allTransactions=Tdao.findAll();
		List<IssuebookTransaction> allTransaction=Tdao.alldata();
		return allTransaction;
	}


//Return book
	public IssuebookTransaction returnbook(IssuebookTransaction returnBook) throws ParseException {
		
   //Today Date
	  DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	    String Today_date= formatter.format(new Date());
	 
	 
	 
	  String isbm=returnBook.getIsbm_No();
	  String rollnumber=returnBook.getIssue_Rollnumber();
	  
 //get  object 
	  IssuebookTransaction issueTransaction=Tdao.returnbook(isbm,rollnumber);
	  BookEntity book=bookdao.search_isbm(isbm);
	  
	//checking
	  //String returndate= issueTransaction.getExpected_Date();
	String returndate= "25-07-2023";
	
	
	 SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
     Date today = sdformat.parse(Today_date);
     Date ex_date = sdformat.parse(returndate);
   	
	   System.out.println("Today:"+sdformat.format(today));
	   System.out.println("Return Date:"+sdformat.format(ex_date));
	   
	   
	  System.out.println(today.compareTo(ex_date)<=0); 
	  	boolean date=today.compareTo(ex_date)<=0;
	  if(date) {
		  //set value
		       int copie= Integer.parseInt(issueTransaction.getIssue_Copies())-1;
			     issueTransaction.setIssue_Copies(Integer.toString(copie));
		 	        issueTransaction.setActual_Return(Today_date);
		 	           Tdao.save(issueTransaction);
		 	           
			   int copies=Integer.parseInt(book.getCopies())+1;
			     book.setCopies(Integer.toString(copies));
			        bookdao.save(book);
			     
			     System.out.println("save db");
		
			     

	     }else {
	    	 
	    	 //find Difference -days
			   DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			   LocalDate  d1 = LocalDate.parse(Today_date, df);
			   LocalDate  d2 = LocalDate.parse(returndate, df);
			     
			   Long datediff = ChronoUnit.DAYS.between(d2,d1);
			   System.out.println(datediff);
			   System.out.println(issueTransaction);
			   String fineamount=Long.toString(datediff*30);
			   
			   returnBook.setFine(fineamount);
			   issueTransaction.setFine(fineamount);
			   Tdao.save(issueTransaction);
	     }
	  	 
	  /*  List of IssuebookTransaction
	
		List<IssuebookTransaction> allTransactions=Tdao.findAll();
		
		 for (IssuebookTransaction alltransaction : allTransactions) {
			// System.out.println(allbook.getIsbm_No());
			   if (alltransaction.getIsbm_No().equals(returnBook.getIsbm_No())
					 && alltransaction.getIssue_Rollnumber().equals(returnBook.getIssue_Rollnumber())
					    && (0<Integer.parseInt(alltransaction.getIssue_Copies()))
					        && (0==Integer.parseInt(alltransaction.getFine())) ) 
			   {
				   int copie= Integer.parseInt(alltransaction.getIssue_Copies())-1;
			 //set value
				   alltransaction.setIssue_Copies(Integer.toString(copie));
				   alltransaction.setActual_Return(date);
				     //System.out.println(date);
				   System.out.println(alltransaction.getExpected_Date());
				 Tdao.save(alltransaction);
				 */  
				   
				 /*List of BookEntity  
					List<BookEntity> allbooks=bookdao.findAll();
					    
				    for (BookEntity allbook : allbooks) {
				        if (allbook.getIsbm_no().equals(returnBook.getIsbm_No())) 
				        {
				           int copies=Integer.parseInt(allbook.getCopies())+1;
				             allbook.setCopies(Integer.toString(copies));
				            //   bookdao.save(allbook);
				                break;
				        }
				    }
				
			    break;
			   }

		 }

		 */		
		return issueTransaction;	
	}


//Pay and Return
	public IssuebookTransaction payreturnbook(IssuebookTransaction returnBook) {
		System.out.println("Pay and Return");
		 //Today Date
		  DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		  String Today_date= formatter.format(new Date());
		 
		  String isbm=returnBook.getIsbm_No();
		  String rollnumber=returnBook.getIssue_Rollnumber();
		  
	 //get  object 
		  IssuebookTransaction issueTransaction=Tdao.returnbook(isbm,rollnumber);
		  BookEntity book=bookdao.search_isbm(isbm);
		   
		   issueTransaction.setFine("0");
	       int copie= Integer.parseInt(issueTransaction.getIssue_Copies())-1;
		     issueTransaction.setIssue_Copies(Integer.toString(copie));
	 	        issueTransaction.setActual_Return(Today_date);
	 	           Tdao.save(issueTransaction);
	 	           
		   int copies=Integer.parseInt(book.getCopies())+1;
		     book.setCopies(Integer.toString(copies));
		        bookdao.save(book);
		
		return returnBook;
	}
	
	
	
	
//id select

	public List<IssuebookTransaction> getbookno(String rollno) {
		  //create empty arraylist
				List<IssuebookTransaction> issue_data = Tdao.searchroll(rollno);
				System.out.println(issue_data);
	/*	
		List<IssuebookTransaction> allTransactions=Tdao.findAll();
		//System.out.println(rollno);
		 for (IssuebookTransaction alltransaction : allTransactions) {
			 if (alltransaction.getIssue_Rollnumber().equals(rollno)
					 && (1<=Integer.parseInt(alltransaction.getIssue_Copies())) ) {
								issuedata.add(alltransaction);
			 }
		 }
		
		*/
		
		return issue_data;
	}




//Report download doc file
	public String reportDownload() throws ParseException,  IllegalStateException,IOException{
	//Create Date
		  //String today_date=Utility.today();
		  String today_date= "04-08-2023";
		  System.out.println(today_date);
		  
		  
		//file create 
		 File file=new File("D:\\springboot\\library\\src\\main\\resources\\Files\\"+today_date+".txt");
	     try {
			if (file.delete()) {  
				file.createNewFile();
			        System.out.println("File created: " + file.getName()); 
			        System.out.println(file);
			      } 

	    HashMap<String, Integer> issuebook = new HashMap<String, Integer>();
	    HashMap<String, Integer> returnBook = new HashMap<String, Integer>();
		
		
		//get data in DB and set value
		 List<IssuebookTransaction> allTransaction=Tdao.alldata();
		  for(IssuebookTransaction transaction:allTransaction) {
			  
			  System.out.println(transaction.getIssue_Date().equals(today_date));
			  System.out.println(transaction.getExpected_Date().equals(today_date));
			
	       if(transaction.getIssue_Date().equals(today_date) || transaction.getExpected_Date().equals(today_date)) {
			  String Isbm=transaction.getIsbm_No();
			  String BookName=transaction.getBookname();
			  String Name=transaction.getIssue_Sname();
			  String Rollnumber=transaction.getIssue_Rollnumber();
			  String IssueDate=transaction.getIssue_Date();
			  String ExpectedDate=transaction.getExpected_Date();
		    	 
			
		    
			        int bookANDreturn=Integer.parseInt(transaction.getIssue_Copies());
			           if(bookANDreturn>=1) {
			        	   String name= transaction.getBookname();
			        	   if(issuebook.containsKey(transaction.getBookname())) {
			        		      issuebook.put(name,issuebook.get(name)+1);
			        		      System.out.println( name+"-2-"+issuebook.get(name));
			        	   }else {

			        	   	   issuebook.put(name,1);
			        	   	System.out.println( name+"-1-"+issuebook.get(name));
			        	   }
			           }else {
			        	   String name= transaction.getBookname();
			        	   if(returnBook.containsKey(transaction.getBookname())) {
			        		   returnBook.put(name,issuebook.get(name)+1);
			        		   
			        	   }else {
			        		   returnBook.put(name,1);
			        	   }
			        	   
			        	   
			          }
			       	//file write
				        FileWriter writer=new FileWriter(file,true);
					writer.write("Isbm:"+Isbm+"/BookName:"+BookName+",Name:"+Name+"/Rollnumber:"+Rollnumber+
					   ",IssueDate:"+IssueDate+"/ExpectedDate:"+ExpectedDate+"\n");
			        writer.flush();
			        writer.close();
		    }else {
		    	System.out.println( "Today Date Not Record! ");
		     }
		  
		  }
		  FileWriter writer=new FileWriter(file,true);
		  writer.write("bookissue:"+issuebook+",returnbook:"+returnBook+"\n");
		        writer.flush();
		        writer.close();
			     
	     } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
		
		return file.getName();
	}










	
	
	
}
