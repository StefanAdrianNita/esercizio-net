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
            boolean loop=true;
            while(loop) {
                String inEntrata = br.readLine();
                if(inEntrata=="Quit"||inEntrata=="QUIT"||inEntrata=="quit"){
                loop=false;
                }
                else{
                System.out.println("  " + inEntrata);
            }
        }
        }
        catch(Exception e){}
    }
}
