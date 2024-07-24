package artesanato;

import java.util.List;

/**
 * Sistema para gerenciar itens de artesanato
 */

public interface SistemaFeiraArtesanato {
    /**
     * Cadastra um novo item no sistema.
     * @param item O item a ser adicionado
     * @return true se o item foi cadastrado, ou false caso ele já exista no sistema.
     */
    public boolean cadastrarItem(ItemDeArtesanato item);

    /**
     * Pesquisa todos os itens cujo nome começa com o nome passado como parâmetro.
     * @param nome O nome a pesquisar
     * @return uma lista contend os itens cusjo nome começa com o parâmetro.
     */
    public List<ItemDeArtesanato> pesquisarItensPeloNome(String nome);

    /**
     * Pesquisa os itens cujo preço é menor ou igual ao valor passado no parâmetro.
     * @param preco O valor dos itens a pesquisar
     * @return a lista dos itens cujo preço é menor ou igual ao valor passado no parâmetro.
     */
    public List<ItemDeArtesanato> pesquisarItensAbaixoDoPreco(double preco);

    /**
     * pesquisa o item cujo o código é passado por parâmetro.
     * @param codigo O código do item a pesquisar
     * @return o item encontrado
     * @throws ItemInexistenteException Se não for encontrado o item com o código passado.
     */
    public ItemDeArtesanato pesquisarItemPeloCodigo(String codigo) throws ItemInexistenteException;
}
