package library_management_system.library.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="issue_transaction")
public class IssuebookTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "issueId")
	private long issueId;
	
	@Column(name = "issue_Sname")
	private String issue_Sname;

	@Column(name = "issue_Rollnumber")
	private String issue_Rollnumber;
	
	@Column(name = "isbm_No")
	private String isbm_No;
	
	@Column(name = "bookname")
	private String bookname;

	@Column(name="issue_Date")
	private String issue_Date;
	
	@Column(name="issue_Copies")
	private String issue_Copies;
	
	@Column(name="expected_Date")
	private String expected_Date;
	
	@Column(name="actual_Return")
	private String actual_Return;
	
	@Column(name="fine")
	private String fine;

	public long getIssueId() {
		return issueId;
	}

	public void setIssueId(long issueId) {
		this.issueId = issueId;
	}

	public String getIssue_Sname() {
		return issue_Sname;
	}

	public void setIssue_Sname(String issue_Sname) {
		this.issue_Sname = issue_Sname;
	}

	public String getIssue_Rollnumber() {
		return issue_Rollnumber;
	}

	public void setIssue_Rollnumber(String issue_Rollnumber) {
		this.issue_Rollnumber = issue_Rollnumber;
	}

	public String getIsbm_No() {
		return isbm_No;
	}

	public void setIsbm_No(String isbm_No) {
		this.isbm_No = isbm_No;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getIssue_Date() {
		return issue_Date;
	}

	public void setIssue_Date(String issue_Date) {
		this.issue_Date = issue_Date;
	}

	public String getIssue_Copies() {
		return issue_Copies;
	}

	public void setIssue_Copies(String issue_Copies) {
		this.issue_Copies = issue_Copies;
	}

	public String getExpected_Date() {
		return expected_Date;
	}

	public void setExpected_Date(String expected_Date) {
		this.expected_Date = expected_Date;
	}

	public String getActual_Return() {
		return actual_Return;
	}

	public void setActual_Return(String actual_Return) {
		this.actual_Return = actual_Return;
	}

	public String getFine() {
		return fine;
	}

	public void setFine(String fine) {
		this.fine = fine;
	}

	@Override
	public String toString() {
		return "IssuebookTransaction [issueId=" + issueId + ", issue_Sname=" + issue_Sname + ", issue_Rollnumber="
				+ issue_Rollnumber + ", isbm_No=" + isbm_No + ", bookname=" + bookname + ", issue_Date=" + issue_Date
				+ ", issue_Copies=" + issue_Copies + ", expected_Date=" + expected_Date + ", actual_Return="
				+ actual_Return + ", fine=" + fine + "]";
	}

	public IssuebookTransaction(long issueId, String issue_Sname, String issue_Rollnumber, String isbm_No,
			String bookname, String issue_Date, String issue_Copies, String expected_Date, String actual_Return,
			String fine) {
		super();
		this.issueId = issueId;
		this.issue_Sname = issue_Sname;
		this.issue_Rollnumber = issue_Rollnumber;
		this.isbm_No = isbm_No;
		this.bookname = bookname;
		this.issue_Date = issue_Date;
		this.issue_Copies = issue_Copies;
		this.expected_Date = expected_Date;
		this.actual_Return = actual_Return;
		this.fine = fine;
	}

	public IssuebookTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	
	
	

}
