package artesanato;

import javax.swing.JOptionPane;
import java.util.List;

public class ProgramaArtesanatoRioTinto {

    public static void main(String [] args){
        boolean continuar = true;
        SistemaFeiraArtesanato sistema = new SistemaFeiraArtesanatoRioTinto();
        while(continuar){
            String opcao = JOptionPane.showInputDialog("Digite uma opção:\n1.Cadastrar item\n2.Pesquisar item pelo nome\n3.Pesquisar pelo código\n4.Sair");
            if (opcao.equals("1")){
                //Cadastrar
                String tipoItem = JOptionPane.showInputDialog("Qual o tipo de item?\n1.Roupa\n2.Estátua");
                if (tipoItem.equals("1")){
                    Roupa item = new Roupa();
                    String codigo = JOptionPane.showInputDialog("Qual o código?");
                    item.setCodigo(codigo);
                    item.setNome(JOptionPane.showInputDialog("Qual o nome do item?"));
                    item.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Qual o preço do item?")));
                    String tamanho = JOptionPane.showInputDialog("Qual o tamanho da roupa?");
                    item.setTamanho(tamanho);

                    try {
                        sistema.cadastraItem(item);
                        JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso:"+ item.toString());
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        e.printStackTrace();
                    }
                }



            } else if (opcao.equals("2")){
                String nomeItemAPesquisar = JOptionPane.showInputDialog("Digite o nome do item a pesquisar (início do nome)");
                List <ItemDeArtesanato> itensPorNome = sistema.pesquisaItensPeloNome(nomeItemAPesquisar);
                if (itensPorNome.size()==0){
                    JOptionPane.showMessageDialog(null, "Não existe nenhum item com esse nome");
                } else {
                    JOptionPane.showMessageDialog(null, "Itens achados:");
                    for (ItemDeArtesanato it: itensPorNome){
                        JOptionPane.showMessageDialog(null, it.toString());
                    }
                }
            } else if (opcao.equals("3")){
                String codigoPesq = JOptionPane.showInputDialog("Digite o código a pesquisar");
                try {
                    ItemDeArtesanato itemAchado = sistema.pesquisaItemPeloCodigo(codigoPesq);
                    JOptionPane.showMessageDialog(null, "Item achado:"+ itemAchado.toString());
                } catch (ItemInexistenteException e){
                    JOptionPane.showMessageDialog(null, "Não foi encontrado item com o código "+codigoPesq);
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
            } else if (opcao.equals("4")){
                continuar = false;
                JOptionPane.showMessageDialog(null, "Tchau");
            }
        }


    }


}
