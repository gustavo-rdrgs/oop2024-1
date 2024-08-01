package sistema_comercial;

public class ClienteNaoExisteException extends Exception{
    public ClienteNaoExisteException(String msg){
        super(msg);
    }
}
