package amigo_secreto;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String [] args){

        SistemaAmigo sisAmigo = new SistemaAmigo();

        try {
            sisAmigo.cadastraAmigo("Beltrano", "beltrano@yahoo.com.br");
            sisAmigo.cadastraAmigo("Fulana", "fulana@hotmail.com");

            sisAmigo.configuraAmigoSecretoDe("beltrano@yahoo.com.br", "fulana@hotmail.com");
            sisAmigo.enviarMensagemParaAlguem("Boa tarde Fulana!", "beltrano@yahoo.com.br", "fulana@hotmail.com", true);
            sisAmigo.enviarMensagemParaTodos("Bom dia pessoal!", "fulana@hotmail.com", true);

            List<Mensagem> mensagensAnonimas = sisAmigo.pesquisaMensagensAnonimas();
            if (!mensagensAnonimas.isEmpty()){
                for (Mensagem m: mensagensAnonimas){
                    System.out.println(m.getTexto());
                }
            }
            else {
                System.out.println("Não existem mensagens anônimas.");
            }

            String emailSecreto = sisAmigo.pesquisaAmigoSecretoDe("beltrano@yahoo.com.br");

            if (emailSecreto.equals("fulana@hotmail.com")){
                System.out.println("OK");
            }
            else {
                System.out.println("No ok");
            }
        } catch (AmigoInexistenteException | AmigoNaoSorteadoException e){
            System.out.println(e.getMessage());
        }
    }
}