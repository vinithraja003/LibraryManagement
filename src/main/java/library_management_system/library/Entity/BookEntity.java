package library_management_system.library.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookId")
	private long bookId;
	
	@Column(name = "bookname")
	private String bookname;
	@Column(name = "author")
	private String author;
	@Column(name = "isbm_no")
	private String isbm_no;
	@Column(name = "copies")
	private String copies;
	@Column(name = "category")
	private String category;
	@Column(name = "bookprice")
	private String bookprice;
	
	
	
	
	
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbm_no() {
		return isbm_no;
	}
	public void setIsbm_no(String isbm_no) {
		this.isbm_no = isbm_no;
	}
	public String getCopies() {
		return copies;
	}
	public void setCopies(String copies) {
		this.copies = copies;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBookprice() {
		return bookprice;
	}
	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}
	@Override
	public String toString() {
		return "BookEntity [bookId=" + bookId + ", bookname=" + bookname + ", author=" + author + ", isbm_no=" + isbm_no
				+ ", copies=" + copies + ", category=" + category + ", bookprice=" + bookprice + "]";
	}
	
	public BookEntity(long bookId, String bookname, String author, String isbm_no, String copies, String category,
			String bookprice) {
		super();
		this.bookId = bookId;
		this.bookname = bookname;
		this.author = author;
		this.isbm_no = isbm_no;
		this.copies = copies;
		this.category = category;
		this.bookprice = bookprice;
	}
	
	
	
	

}
