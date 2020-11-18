package Server;

import java.beans.Expression;
import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    public static ServerThread[] lista;
    

    public static void main(String[] args){
        int port=6500;
        ServerSocket s;
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;

        OutputStream os;
        PrintWriter pw;

        int minimo, massimo;
        int nrDiIp;

        System.out.print("Inserisci IP minimo: ");
        Scanner scan = new Scanner(System.in);
        minimo = scan.nextInt();
        System.out.print("Inserisci IP massimo: ");
        massimo = scan.nextInt();

        nrDiIp = massimo-minimo;

        try{
            s = new ServerSocket(port);
            while(true){
                System.out.println("IN ASCOLTO...");
                Socket socket = s.accept();
            }
        }catch(Exception e){}
    }
}
