package artesanato;

import java.util.*;

public class SistemaFeiraArtesanatoRioTinto implements SistemaFeiraArtesanato{
    private Map<String, ItemDeArtesanato> itensDeArtesanato;

    public SistemaFeiraArtesanatoRioTinto(){
        itensDeArtesanato = new HashMap<>();
    }

    @Override
    public boolean cadastrarItem(ItemDeArtesanato item) {
        if (itensDeArtesanato.containsKey(item.getCodigo())){
            return false;
        }
        this.itensDeArtesanato.put(item.getCodigo(), item);
        return true;
    }

    @Override
    public List<ItemDeArtesanato> pesquisarItensPeloNome(String nome) {
        List<ItemDeArtesanato> itensPeloNome = new LinkedList<>();
        for (ItemDeArtesanato item: this.itensDeArtesanato.values()){
            if (item.getNome().startsWith(nome)){
                itensPeloNome.add(item);
            }
        }
        Collections.sort(itensPeloNome);
        return itensPeloNome;
    }

    @Override
    public List<ItemDeArtesanato> pesquisarItensAbaixoDoPreco(double preco) {
        List<ItemDeArtesanato> itensAbaixoDoPreco = new LinkedList<>();
        for (ItemDeArtesanato item: this.itensDeArtesanato.values()){
            if (item.getPreco() <= preco){
                itensAbaixoDoPreco.add(item);
            }
        }
        Collections.sort(itensAbaixoDoPreco);
        return itensAbaixoDoPreco;
    }

    @Override
    public ItemDeArtesanato pesquisarItemPeloCodigo(String codigo) throws ItemInexistenteException{
        ItemDeArtesanato item = this.itensDeArtesanato.get(codigo);
        if (item==null){
            throw new ItemInexistenteException("Item com o código '"+codigo+"' não foi encontrado.");
        } else {
            return item;
        }
    }
}
