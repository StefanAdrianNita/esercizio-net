package Server;

public class SenderReciever {
    //Attributi
    private String messaggioInAttesa;
    private String ipDestinatario;
    private String ipMittente;
    //Metodi
    void riceviDaMittente(String msg){ //VIENE CHIAMATO DAL SERVERTHREAD MITTENTE
    int num=msg.indexOf(" ");
    ipMittente=msg.substring(0,num-1);
    messaggioInAttesa=msg.substring(num+1,msg.length());
    messaggioInAttesa=messaggioInAttesa.substring(0,messaggioInAttesa.indexOf(" ")-1);
    ipMittente=msg.substring(messaggioInAttesa.length()+2, msg.length());
}

    void inviaADestinatario(){ //VIENE CHIAMATO DA riceviDaMittente();

    }
}