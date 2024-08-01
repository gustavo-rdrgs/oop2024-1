package sistema_comercial;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SistemaComercialMap implements SistemaComercial {
    private Map<String, Cliente> clientes;
    private Map<String, Produto> produtos;

    public SistemaComercialMap() {
        this.clientes = new HashMap<String, Cliente>();
        this.produtos = new HashMap<String, Produto>();
    }

    @Override
    public boolean existeProduto(Produto produto) {
        if (this.produtos.containsKey(produto.getCodigo())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Produto pesquisaProduto(String codigoProduto)
            throws ProdutoNaoExisteException {
        if (this.produtos.containsKey(codigoProduto)) {
            return this.produtos.get(codigoProduto);
        }
        throw new ProdutoNaoExisteException("Não foi encontrado produto"

                + " com o código " + codigoProduto);

    }

    @Override
    public boolean cadastraProduto(Produto produto) {
        if (existeProduto(produto)) {
            return false;
        } else {
            this.produtos.put(produto.getCodigo(), produto);
            return true;
        }
    }

    @Override
    public boolean existeCliente(Cliente cliente) {
        return false;
    }

    @Override
    public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException {
        return null;
    }

    @Override
    public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) {
        return null;
    }
}
