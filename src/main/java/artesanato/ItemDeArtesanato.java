package artesanato;

import java.util.Objects;

public class ItemDeArtesanato  implements Comparable<ItemDeArtesanato> {
    private String codigo;
    private String nome;
    private double preco;

    private TipoItem tipo;

    public ItemDeArtesanato(String codigo, String nome, double preco, TipoItem tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
    }


    public ItemDeArtesanato() {
        this("","",0.0, TipoItem.INDEFINIDO);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemDeArtesanato that = (ItemDeArtesanato) o;
        return Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }


    @Override
    public int compareTo(ItemDeArtesanato o) {
        return (int) (this.preco - o.getPreco());
    }

    @Override
    public String toString() {
        return "ItemDeArtesanato de " +
                "codigo '" + codigo + '\'' +
                ", nome '" + nome + '\'' +
                ", e preco " + preco;
    }
}
