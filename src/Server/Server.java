package Server;

import java.net.*;
import java.io.*;
import java.util.*;

public class Server {
    private static int minimo, massimo;
    private static int idVettore = 0;
    private static int idIP = idVettore+minimo;

    public static ServerThread[] lista;
    public static Boolean[] listaLibero;


    public static void main(String[] args){
        int port=6500;
        ServerSocket s;
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;

        OutputStream os;
        PrintWriter pw;

        System.out.print("Inserisci IP minimo: ");
        Scanner scan = new Scanner(System.in);
        minimo = scan.nextInt();
        System.out.print("Inserisci IP massimo: ");
        massimo = scan.nextInt();
        int numeroip=massimo-minimo;
        lista = new ServerThread[numeroip];
        listaLibero = new Boolean[numeroip];

        for(short i=0; i<(numeroip); i++){
            listaLibero[i] = true;
        }

        try{
            s = new ServerSocket(port);
            while(true){
                System.out.println("IN ASCOLTO...");
                Socket socket = s.accept();

                int i=0;
                boolean eraLibero = false;
                do{
                    if(listaLibero[i]){
                        lista[i] = new ServerThread(socket,("192.168.1."+(i+minimo)));
                        lista[i].start();
                        listaLibero[i] = false;
                        eraLibero = true;
                    }
                    else{
                        i++;
                    if(i>numeroip){
                    
                    }
                    }
                }while(!eraLibero);

            }
        }catch(Exception e){}
    }
}
