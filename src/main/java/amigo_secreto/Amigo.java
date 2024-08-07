package amigo_secreto;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nomeAmigo, String emailAmigo){
        nome = nomeAmigo;
        email = emailAmigo;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmailAmigoSorteado(){
        return this.emailAmigoSorteado;
    }

    public void setEmailAmigoSorteado(String emailAmigoSorteado){
        this.emailAmigoSorteado = emailAmigoSorteado;
    }
}
