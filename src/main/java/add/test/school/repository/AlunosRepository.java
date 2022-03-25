package add.test.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import add.test.school.model.Alunos;

@Repository
public interface AlunosRepository extends JpaRepository<Alunos, Long> {
	
	
}
