package amigo_secreto;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima){
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return this.emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    public String getTextoCompletoAExibir(){
        String mensagemCompleta;
        if (ehAnonima()){
            mensagemCompleta = "Mensagem para "+ getEmailDestinatario() +" Texto: "+ getTexto(); // se der errado, troca os get
        }
        else {
            mensagemCompleta = "Mensagem de: "+ getEmailRemetente() +" para "+ getEmailDestinatario() +" Texto: "+ getTexto();
        }

        return mensagemCompleta;
    }
}