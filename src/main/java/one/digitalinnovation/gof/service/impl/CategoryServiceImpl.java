package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Category;
import one.digitalinnovation.gof.model.CategoryRepository;
import one.digitalinnovation.gof.service.CategoryService;

/**
 * Implementação da <b>Strategy</b> {@link CategoryService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private CategoryRepository categoryRepository;

	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Category> buscarTodos() {
		// Buscar todos os Categorys.
		return categoryRepository.findAll();
	}

	@Override
	public Category buscarId(Long id) {
		// Buscar Category por ID.
		Optional<Category> category = categoryRepository.findById(id);
		return category.get();
	}

	
	
	

	@Override
	public void inserir(Category category) {
		categoryRepository.save(category);
		// Category response = buscarPorNome(category.getNome());

		// if (response == null) {
		// 	categoryRepository.save(category);
		// }

	
		
	}

	@Override
	public void atualizar(Long id, Category category) {
		// Buscar Category por ID, caso exista:
		Optional<Category> categoryBd = categoryRepository.findById(id);
		

		
		if (categoryBd.isPresent()) {
			categoryBd.get().setNome(category.getNome());
			categoryBd.get().setImage(category.getImage());
			

		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Category por ID.
		categoryRepository.deleteById(id);
	}


}
