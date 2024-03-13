package library_management_system.library.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LibraryContoller {
	
	@GetMapping("/home")
	  public String index() {
	  return "index";
	}
	
	@GetMapping("/addbook")
	  public String addbook() {
	  return "addbooks";
}
	@GetMapping("/listbook")
	  public String listbook() {
	  return "listbooks";
}
	@GetMapping("/addstudent")
	  public String addstudent() {
	  return "addstudent";
}
	@GetMapping("/liststudent")
	  public String liststudent() {
	  return "liststudents";
}

	
	
}
