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

import add.test.school.model.Escola;
import add.test.school.repository.EscolaRepository;

@RestController
@RequestMapping("/escola")
@CrossOrigin("*")
public class EscolaController {
	
	@Autowired
	private EscolaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Escola>> GetAll() {
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Escola> GetById(@PathVariable long id) {
		
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@PostMapping
	public ResponseEntity<Escola> create (@RequestBody Escola escola) {
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(escola));
	}
	
	@PutMapping
	public ResponseEntity<Escola> update (@RequestBody Escola escola) {
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(escola));
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
}
