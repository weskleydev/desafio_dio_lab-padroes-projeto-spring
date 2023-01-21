package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Product;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author falvojr
 */
public interface ProductService {

	Iterable<Product> buscarTodos();

	Product buscarPorId(Long id);

	void inserir(Product product);

	void atualizar(Long id, Product product);

	void deletar(Long id);

}
