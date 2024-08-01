package sistema_comercial;

import java.util.ArrayList;
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
    public Produto pesquisaProduto(String codigoProduto) throws ProdutoNaoExisteException {
        if (this.produtos.containsKey(codigoProduto)) {
            return this.produtos.get(codigoProduto);
        }
        throw new ProdutoNaoExisteException("Não foi encontrado produto com o código " + codigoProduto);

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
        return (clientes.containsValue(cliente));
    }

    @Override
    public Cliente pesquisaCliente(String id) throws ClienteNaoExisteException {
        if (clientes.containsKey(id)){
            return clientes.get(id);
        }
        throw new ClienteNaoExisteException("Cliente com o ID '"+id+"' não foi encontrado.");
    }

    @Override
    public Collection<Produto> pesquisaProdutosDaCategoria(CategoriaProduto categoria) {
        Collection<Produto> produtosDaCategoria = new ArrayList<>();
        for (Produto p: produtos.values()){
            if (p.getCategoria().equals(categoria)){
                produtosDaCategoria.add(p);
            }
        }
        return produtosDaCategoria;
    }
}
