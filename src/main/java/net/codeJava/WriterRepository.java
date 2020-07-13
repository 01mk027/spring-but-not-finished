package net.codeJava;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface WriterRepository extends MongoRepository<Writer,Long>{
	@Query("{'fullName' : ?0 , 'password' : ?1}")
	List<Writer> checkForWriter(String fullName, String password);

	
}
