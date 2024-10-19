package exercicio_threads;

public class TB extends Thread{
    private Contador cont;
    public TB(Contador cont){
        this.cont = cont;
    }
    public void run(){
        System.out.println("TA: Vou decrementar contador...");
        this.cont.decrementa();
        System.out.println("TA: Valor do contador: "+ this.cont.getValor());
    }
}
