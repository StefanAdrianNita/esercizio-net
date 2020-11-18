package Server;

<<<<<<< HEAD:src/Server/SenderReceiver.java
public class SenderReceiver {
    //ATTRIBUTI
=======
public class SenderReciever {
    //Attributi
>>>>>>> 13567071fc260daa8045552f6e6335cbc272ad03:src/Server/SenderReciever.java
    private String messaggioInAttesa;
    private String ipDestinatario;
    private String ipMittente;
    //METODI
    public void riceviDaMittente(String msg,String ip){ //VIENE CHIAMATO DAL SERVERTHREAD MITTENTE
    int num=msg.indexOf(" ");
    ipDestinatario=msg.substring(0,num-1);
    messaggioInAttesa=msg.substring(num+1,msg.length());
    messaggioInAttesa=messaggioInAttesa.substring(0,messaggioInAttesa.indexOf(" ")-1);
    ipMittente=ip;
    inviaADestinatario();
}

<<<<<<< HEAD:src/Server/SenderReceiver.java
    private void inviaADestinatario(){ //VIENE CHIAMATO DA riceviDaMittente() GESTISTE E INVIA MESSAGGI AL CLIENT MITTENTE E DESTINATARIO  
    String ip=" ";
    int i=-1;
    while(ip!=null && ip!=ipDestinatario){
    i=i++;
    ip=Server.lista[i].getip();
=======
    private void inviaADestinatario(){ //VIENE CHIAMATO DA riceviDaMittente();
String ip=" ";
int i=-1;
while(ip!=null && ip!=ipDestinatario){
i=i++;
ip=Server.lista[i].getIp();
>>>>>>> 13567071fc260daa8045552f6e6335cbc272ad03:src/Server/SenderReciever.java
}
    if(ip==ipDestinatario){
    Server.lista[i].inviaMessaggio("Sent RECIVE FROM "+ipMittente+" "+messaggioInAttesa);
    i=-1;
    while(ip!=ipMittente){
    i=i++;
<<<<<<< HEAD:src/Server/SenderReceiver.java
    ip=Server.lista[i].getip();
=======
    ip=Server.lista[i].getIp();
>>>>>>> 13567071fc260daa8045552f6e6335cbc272ad03:src/Server/SenderReciever.java
    }
    Server.lista[i].inviaMessaggio("Sent MESSAGE SENT");
}
    else{
    i=-1;
    while(ip!=ipMittente){
        i=i++;
<<<<<<< HEAD:src/Server/SenderReceiver.java
        ip=Server.lista[i].getip();
=======
        ip=Server.lista[i].getIp();
>>>>>>> 13567071fc260daa8045552f6e6335cbc272ad03:src/Server/SenderReciever.java
        }
        if(ip==null)Server.lista[i].inviaMessaggio("sent HOST UNREACHABLE");
    }  
}
    }
