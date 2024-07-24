package amigo_secreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        mensagens = new ArrayList<>();
        amigos = new ArrayList<>();
    }


    public List<Amigo> getAmigos(){
        return this.amigos;
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        Amigo novoAmigo = new Amigo(nomeAmigo, emailAmigo);
        amigos.add(novoAmigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo){
        for (Amigo a: amigos){
            if (a.getEmail().equalsIgnoreCase(emailAmigo)){
                return a;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        Mensagem novaMensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        mensagens.add(novaMensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        Mensagem novaMensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        mensagens.add(novaMensagem);

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

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        Amigo amigoSelecionado = pesquisaAmigo(emailDaPessoa);
        if (amigoSelecionado == null){
            throw new AmigoInexistenteException("Amigo não encontrado");
        }
        amigoSelecionado.setEmailAmigoSorteado(emailAmigoSorteado);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigoSelecionado = pesquisaAmigo(emailDaPessoa);
        if (amigoSelecionado == null) {
            throw new AmigoInexistenteException("Amigo não encontrado");
        }
        String amigoSorteado = amigoSelecionado.getEmailAmigoSorteado();
        if (amigoSorteado == null) {
            throw new AmigoNaoSorteadoException("Amigo sorteado não configurado");
        }
        return amigoSorteado;
    }
}
