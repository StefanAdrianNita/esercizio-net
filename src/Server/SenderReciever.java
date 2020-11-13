package Server;

public class SenderReciever {
    //Attributi
    private String messaggioInAttesa;
    private String ipDestinatario;
    private String ipMittente;
    //Metodi
    public void riceviDaMittente(String msg,String ip){ //VIENE CHIAMATO DAL SERVERTHREAD MITTENTE
    int num=msg.indexOf(" ");
    ipDestinatario=msg.substring(0,num-1);
    messaggioInAttesa=msg.substring(num+1,msg.length());
    messaggioInAttesa=messaggioInAttesa.substring(0,messaggioInAttesa.indexOf(" ")-1);
    ipMittente=ip;
    inviaADestinatario();
}

    private void inviaADestinatario(){ //VIENE CHIAMATO DA riceviDaMittente();
String ip=" ";
int i=-1;
while(ip!=null && ip!=ipDestinatario){
i=i++;
ip=Server.lista[i].Clientip;
}
if(ip==ipDestinatario){
Server.lista[i].inviaMessaggio("RECIVE FROM "+ipMittente+" "+messaggioInAttesa);
i=-1;
while(ip!=ipMittente){
    i=i++;
    ip=Server.lista[i].Clientip;
    }
    Server.lista[i].inviaMessaggio("MESSAGE SENT");
}
else{
    i=-1;
    while(ip!=ipMittente){
        i=i++;
        ip=Server.lista[i].Clientip;
        }
        Server.lista[i].inviaMessaggio("CONN_REFUSED");
    }  
}
    }