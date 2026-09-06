package JavaBasic; 
import java.util.Date;

public class HoraDoSistema {
    public static void main(String[] args) {
        Date relogio = new Date(); // new cria um novo objeto do tipo Date 
        System.out.println("Data e hora do sistema atual: ");
        System.out.println(relogio.toString()); // toString() converte o objeto em String

    }
}



