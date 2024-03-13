package library_management_system.library.Dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import library_management_system.library.Entity.BookEntity;


@Repository
public interface BookDao extends JpaRepository<BookEntity,Long> {

	
	@Query(value="select * from books  where isbm_no=:isbm_no",nativeQuery=true)
	public BookEntity search_isbm(String isbm_no);
	//StudentEntity findByRollnumber(String roll);
	

	
}
