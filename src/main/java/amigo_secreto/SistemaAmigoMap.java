package amigo_secreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigoMap(){
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }


    // TODO: Importar as Exceptions


    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.putIfAbsent(nomeAmigo, novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo){
        for (Amigo a: amigos.values()){
            if (a.getEmail().equalsIgnoreCase(emailAmigo)){
                return a;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        MensagemParaTodos m = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        System.out.println(m.getTextoCompletoAExibir());
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        MensagemParaAlguem m = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        System.out.println(m.getTextoCompletoAExibir());
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for (Mensagem m: mensagens){
            if (m.ehAnonima()){
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado){
        Amigo amigoSelecionado = pesquisaAmigo(emailDaPessoa);
        Amigo amigoSorteado = pesquisaAmigo(emailAmigoSorteado);
        if (amigoSelecionado != null && amigoSorteado != null){
            amigoSelecionado.setEmailAmigoSorteado(emailAmigoSorteado);
            System.out.println("Amigo configurado com sucesso.");
        }

    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa){
        Amigo amigoSelecionado = pesquisaAmigo(emailDaPessoa);
        String emailAmigoSecreto = amigoSelecionado.getEmailAmigoSorteado();


        return emailAmigoSecreto;
    }




}
