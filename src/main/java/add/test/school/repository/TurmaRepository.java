package add.test.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import add.test.school.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
	
	
	
}

