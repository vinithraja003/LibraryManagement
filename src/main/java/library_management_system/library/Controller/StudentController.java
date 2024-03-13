package library_management_system.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import library_management_system.library.Entity.StudentEntity;
import library_management_system.library.Service.StudentService;
import library_management_system.library.pageRequest.PageRequestDto;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentservice;

//Add Student
	@PostMapping("/saveStudent")
	@ResponseBody
	public StudentEntity savestudent(@RequestBody StudentEntity student) {
		return studentservice.save(student);
		
	}
	
//list of Students
		@GetMapping("/allStudents")
		@ResponseBody
		public List<StudentEntity> liststudent(){
			return studentservice.liststudent();
			
		}
//Get one student using roll number
		@GetMapping("/allstudent/{roll}")
		@ResponseBody
		public StudentEntity searchroll(@PathVariable("roll") String roll) {
			System.out.println(roll);
			return studentservice.searchroll(roll);
		}

//Get student search any value
				@GetMapping("/student/{value}")
				@ResponseBody
				public List<StudentEntity> search_all(@PathVariable("value") String value) {
					System.out.println(value);
					return studentservice.search_all(value);
				} 
		
		
				
//pagination 			
				
				@PostMapping("/student")
				@ResponseBody
				public Page<StudentEntity> getAllStudentUsingPagination(@RequestBody PageRequestDto dto){
					
					return studentservice.search_all(dto);
				} 
				
			
//pagination  QueryMethod:		
				
				@PostMapping("/nativeQuery/allstudent")
				@ResponseBody
				public List<StudentEntity> Pagination(@RequestBody PageRequestDto dto){
					
					return studentservice.pagination(dto);
				} 
//count all record
				@GetMapping("/nativeQuery/allstudent/record")
				@ResponseBody
				public int PaginationRecord(){
					
					return studentservice.record();
				}
								
//pagination filter value and selected rows	 QueryMethod:			
				@PostMapping("/filter")
				@ResponseBody
				public List<StudentEntity> filter(@RequestBody PageRequestDto dto ){
					System.out.println(dto.getSearch_name());
					System.out.println(dto.getPageNo());
					return studentservice.filter(dto);
				} 
		
//count search  record
				@GetMapping("/nativeQuery/allstudent/record/{value}")
				@ResponseBody
				public int countSearchRecord(@PathVariable("value") String value){
					
					return studentservice.countSearchRecord(value);
				}	
}
