package sistema_comercial;

public class ProdutoNaoExisteException extends Exception{
    public ProdutoNaoExisteException(String msg){
        super(msg);
    }
}
