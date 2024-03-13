package library_management_system.library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import library_management_system.library.Entity.BookEntity;
import library_management_system.library.Service.BookService;

import java.util.List;
@Controller
public class BookController {
	@Autowired(required=true)
	private BookService bookService;
	
	//issue Book
	@GetMapping("/issuebook")
	  public String issuebook() {
	  return "IssueBook";
	}
	
	
	
//save book	
	@PostMapping("/savebook")
	@ResponseBody
	public BookEntity savebook(@RequestBody BookEntity book) {
		
		return bookService.savebook(book);
	
	}

//list of books
	@GetMapping("/allbook")
	@ResponseBody
	public List<BookEntity> listbook(){
		return bookService.listbook();
		
	}
	
//id select
	@GetMapping("/book/issuebook/{id}")
	@ResponseBody
	public BookEntity issuebookid(@PathVariable("id") long id) {
		  return bookService.getbookno(id);
		
	}

	

}
