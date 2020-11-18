package Client;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
    public static void main(String args[]) {

        int port = 6500;
        String ip = "127.0.0.1";

        Socket s;


        try{
            s = new Socket(ip,port);

            Sender sender = new Sender(s);
            Reciever reciever = new Reciever(s);

            sender.start();
            reciever.start();

        }catch(Exception e){};
    }
}
