package library_management_system.library.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import library_management_system.library.Dao.StudentDao;
import library_management_system.library.Entity.StudentEntity;
import library_management_system.library.pageRequest.PageRequestDto;
import library_management_system.library.pageRequest.Utility;


@Service
public class StudentService {
	@Autowired
	private StudentDao studentdao;
	

//add Student
	public StudentEntity save(StudentEntity student) {
		// TODO Auto-generated method stub
		System.out.println(student.getSname());

		return studentdao.save(student);
		//return studentdao.store(student);
		
	}
	
	
//list  of Students
	public List<StudentEntity> liststudent() {
		//List<StudentEntity> allStudents=studendao.findAll();
		System.out.println("all list");
		List<StudentEntity> allStudents=studentdao.getall();
		return allStudents;
	}



//Get one student using rollnumber

	public StudentEntity searchroll(String roll) {
    /*  return studendao.findByRollnumber(roll);  */
		
		return studentdao.searchroll(roll);
	}

	
//Get student search any value

		public List<StudentEntity> search_all(String value) {
	   		return studentdao.search_all(value);
		}


//pagination 
		public Page<StudentEntity> search_all(PageRequestDto dto) {
			 Pageable pageable = new PageRequestDto().getPageable(dto);
			 Page<StudentEntity> studentPage = studentdao.findAll(pageable);
			 return  studentPage;
		}


		
//pagination query method		
		
		public List<StudentEntity> pagination( PageRequestDto dto) {
		
			    int pageno=dto.getPageNo();
			    int pagesize=dto.getPageSize();
			 	int offset=Utility.val(pageno,pagesize);
			
			return studentdao.pagination(offset,pagesize);
		}	
		
		
//count  all record		
		public int record() {
			// TODO Auto-generated method stub
			return studentdao.countRecord();
		}
		
//pagination filter value and selected rows		
		
		public List<StudentEntity> filter( PageRequestDto dto) {
		
			    int pageno=dto.getPageNo();
			    int pagesize=dto.getPageSize();
			    String search_value=dto.getSearch_name();
			    
			    System.out.println(dto.getSearch_name());
				System.out.println(dto.getPageNo());
			int offset=Utility.val(pageno,pagesize);
		      if(search_value!="" ) {
			        return studentdao.filter(search_value,offset,pagesize);
			   }
		      return studentdao. pagination( offset, pagesize);
		}

//count search  record
	   public int countSearchRecord(String value) {
			// TODO Auto-generated method stub
			return studentdao.countSearchRecord(value);
		}


	


		

	

		


	
	
	
}
