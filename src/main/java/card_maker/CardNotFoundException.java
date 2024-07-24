package card_maker;
import java.io.Serial;

public class CardNotFoundException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;
    public CardNotFoundException(String msg){
        super(msg);
    }
}
