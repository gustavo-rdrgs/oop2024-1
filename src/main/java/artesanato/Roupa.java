package artesanato;

public class Roupa extends ItemDeArtesanato {

    private String material;
    private String tipo;
    private String tamanho;

    public Roupa(String codigo, String nome, double preco, String material, String tipo, String tamanho) {
        super(codigo, nome, preco);
        this.material = material;
        this.tamanho = tamanho;
        this.tipo = tipo;

    }

    public Roupa() {
        this("","",0.0, "", "","");
    }

}
