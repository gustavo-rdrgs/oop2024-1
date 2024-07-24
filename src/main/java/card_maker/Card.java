package card_maker;
import java.util.Objects;

public class Card implements Comparable<Card>{
    private String name;
    private String info;

    public Card(String name, String info){
        this.name = name;
        this.info = info;
    }

    public Card(){
        this("no name", "no info");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card otherCard = (Card) o;
        return Objects.equals(name, otherCard.name) && Objects.equals(info, otherCard.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, info);
    }

    @Override
    public int compareTo(Card otherCard) {
        int nameComparison = this.name.compareTo(otherCard.name);
        return nameComparison != 0 ? nameComparison : this.info.compareTo(otherCard.info);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String toString(){
       return String.format("""
                Card: %s
                Info: %s
                """, this.name, this.info);
    }

}
