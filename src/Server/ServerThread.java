package Server;
import java.net.*;
import java.io.*;

public class ServerThread extends Thread
{
private Socket socket;
private String ClientIp;

public ServerThread(Socket s,String ip) { socket=s;ClientIp=ip;  }

public String getIp(){
    return ClientIp;
}

public void run()
{
boolean fine=false;
try
{
BufferedReader br=new BufferedReader(new
InputStreamReader(socket.getInputStream()));
PrintWriter pw=new PrintWriter(socket.getOutputStream());

// IMPLEMENTAZIONE DEL PROTOCOLLO...    

br.close(); pw.close(); socket.close();
}catch(IOException e){System.out.println("Problema di rete");}
}
}
