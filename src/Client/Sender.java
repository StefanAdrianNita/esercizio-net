package Client;

import java.net.*;
import java.io.*;
import java.util.*;

public class Sender extends Thread{

    Socket s;

    public Sender(Socket s){
        this.s = s;
    }
    OutputStream os;
    PrintWriter pw;

    String messaggio;

    public void run(){
        try{
            os = s.getOutputStream();
            pw = new PrintWriter(os);

            while(true) {
                System.out.print(">> ");
                Scanner scan = new Scanner(System.in);
                String messaggio = scan.nextLine();

                pw.println(messaggio);
                pw.flush();
            }
        }
        catch(Exception e){}
    }
}
