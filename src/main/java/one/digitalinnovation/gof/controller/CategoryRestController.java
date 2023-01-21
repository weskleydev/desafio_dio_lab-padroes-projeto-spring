package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.model.Category;
import one.digitalinnovation.gof.service.CategoryService;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 * 
 * @author falvojr
 */
@RestController
@RequestMapping("categories")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public ResponseEntity<Iterable<Category>> buscarTodos() {
		return ResponseEntity.ok(categoryService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(categoryService.buscarId(id));
	}
	


	@PostMapping
	public ResponseEntity<Category> inserir(@RequestBody Category category) {
		categoryService.inserir(category);
		return ResponseEntity.ok(category);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> atualizar(@PathVariable  Long id, @RequestBody Category category) {
		categoryService.atualizar(id, category);
		return ResponseEntity.ok(category);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		categoryService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
