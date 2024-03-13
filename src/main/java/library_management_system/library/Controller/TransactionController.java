package library_management_system.library.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import library_management_system.library.Entity.BookEntity;
import library_management_system.library.Entity.IssuebookTransaction;
import library_management_system.library.Service.TransactionService;

@Controller
public class TransactionController {
	@Autowired
	private TransactionService tservice;
	
	@GetMapping("/transaction")
	  public String transaction() {
	  return "transaction";
	}
	@GetMapping("/returnBookpage")
	  public String returnBook() {
	  return "returnBook";
	}
	@GetMapping("/fine")
	  public String fine() {
	  return "fine";
	}
	@GetMapping("/report")
	  public String report() {
	  return "reportpage";
	}
	
	


	
//Send Issue book data store in DB 
		@PostMapping("/issuebook")
		@ResponseBody
		public IssuebookTransaction issuebook(@RequestBody IssuebookTransaction transaction) {
			return tservice.savedata(transaction);	
		}
		
		
		
//Get All Data in DB
		@PostMapping("/transaction")
		@ResponseBody
		public List<IssuebookTransaction> getall(){
			return tservice.listdata();
		}
	
//Return book
		@PostMapping("/returnbook")
		@ResponseBody
		public IssuebookTransaction returnbook(@RequestBody IssuebookTransaction returnBook) throws ParseException {
			
			return tservice.returnbook(returnBook);
			
		}

//Pay and Return book
				@PostMapping("/returnbook/pay")
				@ResponseBody
				public IssuebookTransaction Payreturnbook(@RequestBody IssuebookTransaction returnBook) {
					
					return tservice.payreturnbook(returnBook);
					
				}		
		
		
//id select
		@GetMapping("liststudent/issuebook/{rollno}")
		@ResponseBody
		public List<IssuebookTransaction> issuebookid(@PathVariable("rollno") String rollno) {
			  return tservice.getbookno(rollno);
			
		}
		
		
//Report download doc file
		@GetMapping("/report_download")
		@ResponseBody
		public String reportDownload() throws ParseException, IllegalStateException, IOException{
			  return  tservice.reportDownload();
			
		}
	//file download hit end point
		@GetMapping("/download/{fileName}")
		public ResponseEntity<Object> download(@PathVariable String fileName)throws IllegalStateException,IOException{
		
		 // System.out.println(fileName);
		  File Pfile=new File("D:\\springboot\\library\\src\\main\\resources\\Files\\"+fileName);
			
			InputStreamResource resource=new InputStreamResource(new FileInputStream(Pfile));
			HttpHeaders headers=new HttpHeaders();
			headers.add("Content-Disposition",
					String.format("attachment; filename=\"%s\"", Pfile.getName()));
			headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
			headers.add("Pragma", "no-cache");
			headers.add("Expires", "0");

			ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers)
					.contentLength(Pfile.length())
					.contentType(MediaType.parseMediaType("application/txt")).body(resource);

			return responseEntity;    
		}

}
