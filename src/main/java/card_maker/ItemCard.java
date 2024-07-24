package card_maker;
public class ItemCard extends Card{
    private int uses;

    public ItemCard(String name, String info, int uses){
        super(name, info);
        this.uses = uses;
    }

    public String toString(){
        return String.format("""
                Item Card: %s
                Info: %S
                Uses: %d
                """, super.getName(), super.getInfo(), this.uses);
    }
}
