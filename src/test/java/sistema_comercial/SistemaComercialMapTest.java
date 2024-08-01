package sistema_comercial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

public class SistemaComercialMapTest {
    @Test
    public void testaCadastroProdutos(){
        SistemaComercialMap sistema = new SistemaComercialMap();
        Produto p = new Produto("001", "macarrão", 5.0, 10, CategoriaProduto.ALIMENTO);
        sistema.cadastraProduto(p);
        Collection<Produto> alimentos = sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
        assertTrue(alimentos.size()==1);
    }
}
