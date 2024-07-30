package card_maker;



public interface CardSystem {
    public void createACard(Card card) throws CardAlreadyCreatedException;
    public Card searchForCard(String name) throws CardNotFoundException;
    public String listAllCards() throws CardNotFoundException;
}
