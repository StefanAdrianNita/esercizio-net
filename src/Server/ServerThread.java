package Server;
import java.net.*;                          //Packaging e Import classi Java necessarie
import java.io.*;

public class ServerThread extends Thread
{
                                            //Attributi

    private Socket socket;
    private String ClientIp;
    private String msg;
    private Timer t;
    private SenderReciever sr=new SenderReciever();
    private PrintWriter pw;
    private boolean fine;
    private int posizione;

                                            //Metodi+Costruttore

public ServerThread(Socket s,String ip) { socket=s;ClientIp=ip;}

public String getIp(){                      //Serve per ottenere l'ip dato che è un attributo privatp
    return ClientIp;
}

public void Stop(){                         //Ferma il Server e libera l'indirizzo ip
    inviaMessaggio("SENT TIMEOUT");
    ClientIp=null;
}

public void inviaMessaggio(String msg2){    //Invia un messaggio al Client collegato
    int num=msg2.indexOf(" ");
    msg2 = msg2.substring(num+1);
    pw.println(msg2);
    pw.flush();
}


public void run()                           //Crea il Timer,il BufferedReader e il PrintWriter,gestisce i vari messaggi
{

    fine=false;
    t=new Timer(this);t.start();
try
{
    BufferedReader br=new BufferedReader(new
    InputStreamReader(socket.getInputStream()));
    pw=new PrintWriter(socket.getOutputStream());
    pw.println("\n Ip assigned "+ClientIp);
    pw.flush();
posizione=sr.getPosizione(ClientIp);
while(!fine){
    msg=br.readLine();
    if(msg.equals("quit")||msg.equals("Quit")||msg.equals("QUIT")){
        ClientIp=null;
        fine=true;}
        if(msg.equals("quit")&& ClientIp==null||msg.equals("Quit")&& ClientIp==null||msg.equals("QUIT")&& C){
            Server.inserisci(posizione);
            ClientIp=null;
            fine=true;}

if(msg.equals("Lista")||msg.equals("lista")||msg.equals("LISTA")){
    String temp;
    int i=-1;
        boolean loop;
     do{
    loop=true;
    i++;
    temp=Server.lista[i].getIp();
    if(temp==null){
    loop=false;
}
}while(loop);
}
if(msg.equals("Lista") && ClientIp==null||msg.equals("lista") && ClientIp==null||msg.equals("LISTA") && ClientIp==null){
    String temp;
    int i=-1;
        boolean loop;
     do{
    loop=true;
    i++;
    temp=Server.lista[i].getIp();
    if(temp==null){
    loop=false;
}
t=new Timer(this);t.start();
}
while(loop);

}

else{
if(msg!=null){
            sr.riceviDaMittente(msg, ClientIp);
            t=new Timer(this);t.start();
        }
        if(msg!=null && ClientIp == null) {
        Server.inserisci(posizione);
        sr.riceviDaMittente(msg, ClientIp);
        t=new Timer(this);t.start();
        }
    }
}
    br.close(); pw.close(); socket.close();
}
    catch(IOException e){System.out.println("Problema di rete");}
}
}
