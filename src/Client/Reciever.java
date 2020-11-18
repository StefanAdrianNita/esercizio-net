package Client;

import java.net.*;
import java.io.*;
import java.util.*;

public class Reciever extends Thread{

    Socket s;

    public Reciever(Socket s){
        this.s = s;
    }

    InputStream is;
    InputStreamReader isr;
    BufferedReader br;

    public void run(){
        try{
            is = s.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            while(true) {
                String inEntrata = br.readLine();
                System.out.println("  " + inEntrata);
            }
        }
        catch(Exception e){}
    }
}
