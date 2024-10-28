package exercicio_threads;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreadTest {
    @Test
    public void testaTA() throws InterruptedException{
        Contador contador = new Contador();

        Thread thread_A = new TA(contador);
        thread_A.start();

        thread_A.join();

        assertEquals(1, contador.getValor());
    }
}
