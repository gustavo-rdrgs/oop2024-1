package rpg_player;

public class NoRegisteredPlayersException extends Exception {
    public NoRegisteredPlayersException(String msg){
        super(msg);
    }
}
