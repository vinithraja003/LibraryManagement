package library_management_system.library.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import library_management_system.library.Entity.IssuebookTransaction;



@Repository
public interface TransactionDao extends JpaRepository<IssuebookTransaction,Long>{

//get all data
	@Query(value="select * from issue_transaction",nativeQuery=true)
	public List<IssuebookTransaction> alldata();
	
	@Query(value="select * from issue_transaction  where issue_Rollnumber=:roll and issue_Copies>=1 ",nativeQuery=true)
	public List<IssuebookTransaction> searchroll(String roll);

	
//Return book	
	@Query(value="select * from issue_transaction  where "
			+ "isbm_No=:isbm and issue_Rollnumber=:rollnumber and issue_Copies>=1 ",nativeQuery=true)
	public IssuebookTransaction returnbook(String isbm,String rollnumber);
	
}
