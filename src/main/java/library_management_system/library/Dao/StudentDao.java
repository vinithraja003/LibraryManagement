package library_management_system.library.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import library_management_system.library.Entity.StudentEntity;

@Repository
public interface StudentDao extends JpaRepository<StudentEntity,Long>{
/*error:
	@Modifying
	@Query(value="insert into students(sname,branch,rollnumber)"+
	"values(:#{#s.sname},:#{#s.branch},:#{#s.rollnumber})",nativeQuery=true)
	 StudentEntity store(@Param("s")StudentEntity student);
	
	*/
	
	@Query(value="select * from students ",nativeQuery=true)
	public List<StudentEntity>getall();

	@Query(value="select * from students  where rollnumber=:roll",nativeQuery=true)
	public StudentEntity searchroll(String roll);
	//StudentEntity findByRollnumber(String roll);

	@Query(value="select *,Count(*) Over () AS TotalCount  from students  where rollnumber=:value or sname=:value or branch=:value",nativeQuery=true)
	public List<StudentEntity> search_all(String value);
	
	

	
	
//	pagination selected rows 
	@Query(value="select *  from students ORDER BY [student_id] OFFSET :offset ROWS FETCH NEXT :pagesize ROWS ONLY",nativeQuery=true)
	public List<StudentEntity> pagination(int offset,int pagesize);
		
	
//	pagination filter value and selected rows
	@Query(value="select * from students  where rollnumber=:value or sname=:value or branch=:value   "
			+ "ORDER BY [student_id] OFFSET :offset ROWS FETCH NEXT :pagesize ROWS ONLY",nativeQuery=true)
	public List<StudentEntity> filter(String value,int offset,int pagesize);

	
//count all  record pagination
		@Query(value="SELECT COUNT(*) FROM students",nativeQuery=true)
		public int countRecord();

//count search  record pagination
		@Query(value="SELECT COUNT(*) FROM students  where rollnumber=:value or sname=:value or branch=:value",nativeQuery=true)
		public int countSearchRecord(String value);

		

	
	

	

}
