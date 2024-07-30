package artesanato;

import java.util.List;

/**
 * Sistema para gerenciar itens de artesato.
 */
public interface SistemaFeiraArtesanato {

    /**
     * Cadastra um novo item no sistema.
     * @param item O item a ser adicionado
     *
     */
    public void cadastraItem(ItemDeArtesanato item) throws CodigoInvalidoException, ItemJaExisteException;

    /**
     * Pesquisa todos os itens cujo nome começa com o nome passado como parâmetro
     * @param nome O nome a pesquisar
     * @return uma lista contendo os itens cujo nome começa com o parâmetro passado.
     */
    public List<ItemDeArtesanato> pesquisaItensPeloNome(String nome);

    /**
     * Pesquisa os itens cujo preço é menor ou igual ao valor passado no parâmetro
     * @param preco O valor dos itens a pesquisar
     * @return a lista dos itens cujo preço é menor ou igual ao valor passado no parâmetro.
     */
    public List<ItemDeArtesanato> pesquisaItensAbaixoDoPreco(double preco);

    /**
     * Pesquisa o item cujo código é passado por parâmetro.
     * @param codigo O código do item a pesquisar
     * @return o item encontrado.
     * @throws ItemInexistenteException Se não for encontrado nenhum item com o código passado.
     */
    public ItemDeArtesanato pesquisaItemPeloCodigo(String codigo) throws ItemInexistenteException;

}