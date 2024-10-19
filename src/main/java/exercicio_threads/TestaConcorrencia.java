package exercicio_threads;

public class TestaConcorrencia {
    public static void main(String[] args) throws InterruptedException{
        Contador cont = new Contador();
        System.out.println("O valor1 de cont é: "+cont.getValor());
        Thread t1 = new TA(cont);
        Thread t2 = new TB(cont);
        Thread t3 = new TB(cont);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("O valor2 de cont é: "+cont.getValor());
        t1.join();
        t2.join();
        t3.join();
        System.out.println("O valor final de cont é: "+cont.getValor());
    }
}
