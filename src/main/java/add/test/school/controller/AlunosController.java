package add.test.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import add.test.school.model.Alunos;
import add.test.school.repository.AlunosRepository;

@RestController
@RequestMapping("/alunos")
@CrossOrigin("*")
public class AlunosController {
	
	@Autowired
	private AlunosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Alunos>> GetAll() {
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Alunos> GetById(@PathVariable long id) {
		
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@PostMapping
	public ResponseEntity<Alunos> create (@RequestBody Alunos aluno) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(aluno));
	}
	
	@PutMapping
	public ResponseEntity<Alunos> update (@RequestBody Alunos aluno) {
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(aluno));
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
}
