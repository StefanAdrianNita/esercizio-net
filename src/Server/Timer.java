package Server;

public class Timer extends Thread {
                                            //Attributi
    ServerThread s;

                                            //Metodi+Costruttore

    public Timer(ServerThread x) {          
        s = x;
    }

    public void run() {                     //Crea tramite uno sleep un timer 30s e poi fermare il server
        System.out.println("Avvio Timer");
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {}
        s.Stop();
    }

}
