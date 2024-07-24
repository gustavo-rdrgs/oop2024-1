package amigo_secreto;

public class MensagemParaTodos extends Mensagem{
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super(texto, emailRemetente, anonima);
    }

    public String getTextoCompletoAExibir(){
        String mensagemCompleta;
        if (super.ehAnonima()){
            mensagemCompleta = "Mensagem para todos. Texto: "+ getTexto();
        }
        else {
            mensagemCompleta = "Mensagem de "+ getEmailRemetente() + " para todos. Texto: "+ getTexto();
        }

        return mensagemCompleta;
    }

}
