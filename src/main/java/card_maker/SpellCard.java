package card_maker;
public class SpellCard extends Card {
    private int cost;

    public SpellCard(String name, String info, int cost){
        super(name, info);
        this.cost = cost;
    }

    public String toString(){
        return String.format("""
                Item Card: %s
                Effect: %S
                Cost: %s
                """, super.getName(), super.getInfo(), this.cost);
    }
}
