import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import static java.lang.System.exit;

public class Concurrent {
    Semaphore semaphore0 = new Semaphore(1);

    synchronized void consumer () {
        System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.notify();
    }

    synchronized void start() {
        System.out.println(Thread.currentThread().getName());
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(this::consumer);

        System.out.println(Thread.currentThread().getName() + " is exiting..");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " completed!");
        exit(0);
    }

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        Concurrent ins = new Concurrent();
        ins.start();
    }
}
