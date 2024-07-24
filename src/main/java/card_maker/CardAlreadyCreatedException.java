package card_maker;
import java.io.Serial;

public class CardAlreadyCreatedException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;
    public CardAlreadyCreatedException(String msg){
        super(msg);
    }
}
