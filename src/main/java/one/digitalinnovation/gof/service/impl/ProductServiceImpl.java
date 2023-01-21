package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Product;
import one.digitalinnovation.gof.model.ProductRepository;
import one.digitalinnovation.gof.model.Category;
import one.digitalinnovation.gof.model.CategoryRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ProductService;
import one.digitalinnovation.gof.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link ProductService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ProductServiceImpl implements ProductService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Product> buscarTodos() {
		// Buscar todos os Products.
		return productRepository.findAll();
	}

	@Override
	public Product buscarPorId(Long id) {
		// Buscar Product por ID.
		Optional<Product> product = productRepository.findById(id);
		return product.get();
	}
	

	@Override
	public void inserir(Product product) {
		Optional<Category> category = categoryRepository.findById(product.getCategory().getId());
		product.setCategory(category.get());// product.s
		productRepository.save(product);
		

		// salvarProductComCep(product);
	}

	@Override
	public void atualizar(Long id, Product product) {
		// Buscar Product por ID, caso exista:
		Optional<Product> productBd = productRepository.findById(id);
		if (productBd.isPresent()) {
			productBd.get().setName(product.getName());
			productBd.get().setDescription(product.getDescription());
			productBd.get().setCategory(product.getCategory());
		
			
		}
	}

	@Override
	public void deletar(Long id) {
		// Deletar Product por ID.
		productRepository.deleteById(id);
	}

	

}
