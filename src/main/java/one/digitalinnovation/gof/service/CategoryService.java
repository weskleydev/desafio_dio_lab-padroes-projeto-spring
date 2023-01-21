package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Category;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio da categoria. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author falvojr
 */
public interface CategoryService {

	Iterable<Category> buscarTodos();

	Category buscarId(Long id);

	void inserir(Category category);

	void atualizar(Long id, Category category);

	void deletar(Long id);

}
