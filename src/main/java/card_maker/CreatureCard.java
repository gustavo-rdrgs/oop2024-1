package card_maker;
public class CreatureCard extends Card {
    private int power;
    private int defense;

    public CreatureCard(String name, String info, int power, int defense){
        super(name, info);
        this.power = power;
        this.defense = defense;
    }


    public String toString(){
        return String.format("""
                Creature Card: %s
                Info: %S
                Power: %d    Defense: %d
                """, super.getName(), super.getInfo(), this.power, this.defense);
    }
}
