package primeiro_programa;
import java.util.Locale;

public class IdiomaDaMaquina {
    public static void main(String[] args) {
        Locale idioma = Locale.getDefault(); // nosso o
        System.out.println("Idioma do sistema: ");
        System.out.println(idioma.getDisplayName(idioma));
    }
}
 