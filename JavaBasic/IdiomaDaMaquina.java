package JavaBasic;
import java.util.Locale;

public class IdiomaDaMaquina {
    public static void main(String[] args) {
        Locale idioma = Locale.getDefault(); // nosso idioma do sistema operacional
        System.out.println("Idioma do sistema: ");
        System.out.println(idioma.getDisplayName(idioma));
    }
}
 
