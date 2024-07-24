package card_maker;
import java.util.ArrayList;
import java.util.List;

public class MyCardSystem implements CardSystem{
    private List<Card> deck;

    public MyCardSystem(){
        this.deck = new ArrayList<>();
    }

    @Override
    public void createACard(Card card) throws CardAlreadyCreatedException{
        if (deck.contains(card)){
            throw new CardAlreadyCreatedException("Card already created. Please try again...");
        }
        this.deck.add(card);
    }

    @Override
    public Card searchForCard(String name) throws CardNotFoundException{
        for (Card c: deck){
            if (c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        throw new CardNotFoundException("Card '"+ name +"' not found. Please try again...");
    }
}
