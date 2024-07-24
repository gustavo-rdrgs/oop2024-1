package amigo_secreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        SistemaAmigo sisAmigo = new SistemaAmigo();
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Digite a quantidade de amigos que vão participar da brincadeira: ");
            int qtdAmigos = Integer.parseInt(sc.nextLine());
            for (int k = 0; k < qtdAmigos; k++){
                System.out.println("Digite o nome do amigo:");
                String novoNome = sc.nextLine();
                System.out.println("Digite o email do amigo:");
                String novoEmail = sc.nextLine();
                sisAmigo.cadastraAmigo(novoNome, novoEmail);
            }

            for (int k = 0; k < sisAmigo.getAmigos().size(); k++){
                System.out.println("Digite o email de um amigo que queira definir o amigo sorteado: ");
                String email = sc.nextLine();
                System.out.println("Agora digite o email do amigo sorteado: ");
                String emailSorteado = sc.nextLine();
                sisAmigo.configuraAmigoSecretoDe(email, emailSorteado);
            }

            for (Amigo a: sisAmigo.getAmigos()){
                System.out.println("Amigo "+ a.getEmail() +" pegou "+ a.getEmailAmigoSorteado());
            }

        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }
}