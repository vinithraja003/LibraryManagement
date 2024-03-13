package library_management_system.library.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "studentId")
	private long studentId;
	
	@Column(name = "sname")
	private String sname;
	@Column(name = "branch")
	private String branch;
	@Column(name = "rollnumber")
	private String rollnumber;
	
	
		
	
	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}




	public long getStudentId() {
		return studentId;
	}
	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}




	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", sname=" + sname + ", branch=" + branch + ", rollnumber="
				+ rollnumber + "]";
	}




	public StudentEntity(long studentId, String sname, String branch, String rollnumber) {
		super();
		this.studentId = studentId;
		this.sname = sname;
		this.branch = branch;
		this.rollnumber = rollnumber;
	}

	

}
