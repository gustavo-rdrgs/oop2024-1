package rpg_player;

public class PlayerAlreadyRegisteredException extends Exception {
    public PlayerAlreadyRegisteredException(String msg){
        super(msg);
    }
}
