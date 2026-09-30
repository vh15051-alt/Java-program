class Shared {
    int data;
    boolean available = false;

    synchronized void produce(int x) {  
        while (available) {  
            try { wait(); } catch (Exception e) {}  
        }  
        data = x;  
        available = true;  
        System.out.println("Produced: " + x);  
        notifyAll();  
    }  

    synchronized void consume(String name) {  
        while (!available) {  
            try { wait(); } catch (Exception e) {}  
        }  
        System.out.println(name + " consumed: " + data);  
        available = false;  
        notifyAll();  
    }
}

class Producer extends Thread {
    Shared s;
    Producer(Shared s) { this.s = s; }

    public void run() {  
        for (int i = 1; i <= 5; i++)  
            s.produce(i);  
    }
}

class Consumer extends Thread {
    Shared s;
    String name;

    Consumer(Shared s, String name) {  
        this.s = s;  
        this.name = name;  
    }  

    public void run() {  
        for (int i = 1; i <= 5; i++)  
            s.consume(name);  
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Shared s = new Shared();

        Thread p = new Producer(s);  
        Thread c1 = new Consumer(s, "Consumer 1");  
        Thread c2 = new Consumer(s, "Consumer 2");  

        p.start();  
        c1.start();  
        c2.start();  

        p.join();  
        c1.join();  
        c2.join();  

        System.out.println("Communication completed.");  
    }
}