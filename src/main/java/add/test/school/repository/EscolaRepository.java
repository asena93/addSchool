package add.test.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import add.test.school.model.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Long> {
	

}
