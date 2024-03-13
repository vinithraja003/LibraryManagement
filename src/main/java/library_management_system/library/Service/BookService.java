package library_management_system.library.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import library_management_system.library.Dao.BookDao;
import library_management_system.library.Entity.BookEntity;

import java.util.List;

@Service
public class BookService {

@Autowired(required=true)
private BookDao bookdao;


//save book
	public BookEntity savebook(BookEntity book) { 
		 return bookdao.save(book);
	}
	
	
//list of books
	public List<BookEntity> listbook() {
		List<BookEntity> allbooks=bookdao.findAll();
		return allbooks;
	}


	public BookEntity getbookno(long id) {
		// TODO Auto-generated method stub
		return bookdao.findById(id).get();
	}

}
