package rpg_player;

import java.util.Random;
public class RpgPlayer {
    private String playerName;
    private String charName;
    private String charClass;

    public RpgPlayer(String playerName, String charName, String charClass){
        this.playerName = playerName;
        this.charName = charName;
        this.charClass = charClass;
    }

    public RpgPlayer(){
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RpgPlayer rpgPlayer = (RpgPlayer) o;
        return playerName.equals(rpgPlayer.playerName);
    }

    @Override
    public int hashCode() {
        return playerName.hashCode();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String charClass) {
        this.charClass = charClass;
    }

    public String rollD20(RpgPlayer player){
        Random generator = new Random();
        int result = generator.nextInt(20) + 1;
        String msg;
        if (result == 1){
            msg = "Disaster!! Player '"+ player.getPlayerName() +"' rolled a "+result+" and failed the test miserably";
        } else if (result <= 10){
            msg = "Bad luck! Player '"+ player.getPlayerName() +"' rolled a "+result+" and failed the test";
        } else if (result < 20){
            msg = "Nice shot! Player '"+ player.getPlayerName() +"' rolled a "+result+" and passed the test";
        } else {
            msg = "Critical!! Player '"+ player.getPlayerName() +"' rolled a "+result+" and passed the test successfully";
        }
        return msg;
    }

    public String toString(){
        return String.format("""
                Player: %s
                Character: %s
                Class: %s
                """, playerName, charName, charClass);
    }

}
