package rpg_player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class MainCampaign {
    public static void main(String[] args) {
        List<RpgPlayer> players = new ArrayList<>();
        RpgPlayer action = new RpgPlayer();
        String input = "0";
        String options = """
                Options:
                1: Register new player;
                2: Search for player;
                3: Display all players;
                4: Remove one player;
                5: Roll a D20 for a player
                6: Exit program;
                
                """;

        while (!input.equals("6")){
            String pName;
            String cName;
            String cClass;
            RpgPlayer selectedPlayer = null;
            input = JOptionPane.showInputDialog(options +"Select your option:");
            switch (input) {
                case "1":
                    try {

                        pName = JOptionPane.showInputDialog("Type the player's name:");
                        if (pName.isEmpty()){
                            throw new NullPointerException("Player name cannot be empty.");
                        }
                        cName = JOptionPane.showInputDialog("Type the character's name:");
                        cClass = JOptionPane.showInputDialog("Type the character's class:");

                        RpgPlayer player = new RpgPlayer(pName, cName, cClass);
                        if (players.contains(player)){
                            throw new PlayerAlreadyRegisteredException("Player "+ pName +" is already registered. Please try again.");
                        }
                        players.add(player);

                    } catch (PlayerAlreadyRegisteredException | NullPointerException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case "2":
                    try {
                        if (players.isEmpty()){
                            throw new NoRegisteredPlayersException("No players have been registered yet. Please try again");
                        }
                        pName = JOptionPane.showInputDialog("Type the player's name you want to search:");
                        if (pName == null){
                            throw new NullPointerException("Player name cannot be empty. Please try again.");
                        }
                        for (RpgPlayer p: players){
                            if (p.getPlayerName().equalsIgnoreCase(pName)){
                                selectedPlayer = p;
                            }
                        }
                        if (selectedPlayer == null){
                            throw new PlayerNotFoundException("Player '"+ pName +"' was not found");
                        }
                        JOptionPane.showMessageDialog(null, selectedPlayer.toString());
                    } catch (NoRegisteredPlayersException | PlayerNotFoundException | NullPointerException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case "3":
                    StringBuilder allPlayers = new StringBuilder();
                    try {
                        if (players.isEmpty()){
                            throw new NoRegisteredPlayersException("No players have been registered yet. Please try again");
                        }
                        for (RpgPlayer p: players){
                            allPlayers.append(p.toString()).append("\n");
                        }
                        JOptionPane.showMessageDialog(null, allPlayers.toString());

                    } catch (NoRegisteredPlayersException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }

                    break;

                case "4":
                    try {
                        if (players.isEmpty()){
                            throw new NoRegisteredPlayersException("No players have been registered yet. please try again");
                        }
                        pName = JOptionPane.showInputDialog("Type the player's name you want to remove:");
                        if (pName == null){
                            throw new NullPointerException("Player name cannot be empty. Please try again.");
                        }
                        for (RpgPlayer p: players){
                            if (p.getPlayerName().equalsIgnoreCase(pName)){
                                selectedPlayer = p;
                            }
                        }
                        if (selectedPlayer == null){
                            throw new PlayerNotFoundException("Player '"+ pName +"' was not found.");
                        }
                        players.remove(selectedPlayer);
                    } catch (NoRegisteredPlayersException | PlayerNotFoundException | NullPointerException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case "5":
                    try {
                        if (players.isEmpty()){
                            throw new NoRegisteredPlayersException("No players have been registered yet. Please try again");
                        }
                        pName = JOptionPane.showInputDialog("Please enter the player's name.");
                        for (RpgPlayer p: players){
                            if (p.getPlayerName().equalsIgnoreCase(pName)){
                                selectedPlayer = p;
                            }
                        }
                        if (selectedPlayer == null){
                            throw new PlayerNotFoundException("Player '"+ pName +"' was not found.");
                        }
                        JOptionPane.showMessageDialog(null, action.rollD20(selectedPlayer));
                    } catch (NoRegisteredPlayersException | PlayerNotFoundException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case "6":
                    JOptionPane.showMessageDialog(null, "Thanks for using the program. See you next time.");
                    break;
            }
        }

    }
}
