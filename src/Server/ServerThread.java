package Server;
import java.net.*;
import java.io.*;

public class ServerThread extends Thread
{
private Socket socket;
private String ClientIp;
private String msg;

public ServerThread(Socket s,String ip) { socket=s;ClientIp=ip;  }

public String getIp(){
    return ClientIp;
}

public void msgReceive(){
    int num=msg.indexOf(" ");
    msg.substring(num+1);
    SenderReceiver.riceviDaMittente(msg,getIp);
}


public void run()
{
boolean fine=false;
try
{
BufferedReader br=new BufferedReader(new
InputStreamReader(socket.getInputStream()));
PrintWriter pw=new PrintWriter(socket.getOutputStream());

msg=br.readLine();

br.close(); pw.close(); socket.close();
}catch(IOException e){System.out.println("Problema di rete");}
}
}
