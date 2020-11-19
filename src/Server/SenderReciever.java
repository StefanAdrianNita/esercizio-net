package Server;

public class SenderReciever {
    //ATTRIBUTI
    private String messaggioInAttesa;
    private String ipDestinatario;
    private String ipMittente;
    private int posizione;
    //METODI
    public int getPosizione(String ip) {
        posizione=-1;
        String temp;
		do{
        posizione++;
      temp=Server.lista[posizione].getIp();
        }while(temp!=ip);
        
        return posizione;
    }
    public void riceviDaMittente(String msg,String ip){ //VIENE CHIAMATO DAL SERVERTHREAD MITTENTE
    int num=msg.indexOf(" ");
    ipDestinatario=msg.substring(0,num-1);
    messaggioInAttesa=msg.substring(num+1,msg.length());
    messaggioInAttesa=messaggioInAttesa.substring(0,messaggioInAttesa.indexOf(" ")-1);
    ipMittente=ip;
    inviaADestinatario();
    }

    private void inviaADestinatario(){ //VIENE CHIAMATO DA riceviDaMittente() GESTISTE E INVIA MESSAGGI AL CLIENT MITTENTE E DESTINATARIO  
    String ip=" ";
    int i=-1;
    while(ip!=null && ip!=ipDestinatario){
    i=i++;
    ip=Server.lista[i].getIp();
}
    if(ip==ipDestinatario){
    Server.lista[i].inviaMessaggio("Sent RECIVE FROM "+ipMittente+" "+messaggioInAttesa);
    i=-1;
    while(ip!=ipMittente){
    i=i++;
    ip=Server.lista[i].getIp();
    }
    Server.lista[i].inviaMessaggio("Sent MESSAGE SENT");
}
    else{
    i=-1;
    while(ip!=ipMittente){
        i=i++;
        ip=Server.lista[i].getIp();
        }
        if(ip==null)Server.lista[i].inviaMessaggio("sent HOST UNREACHABLE");
    }
}
    }
