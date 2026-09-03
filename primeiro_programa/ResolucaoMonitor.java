package primeiro_programa;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ResolucaoMonitor {
    public static void main(String[] args) {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dimensao = tk.getScreenSize();
        int largura = dimensao.width;
        int altura = dimensao.height;
        System.out.println("A resolução da tela atual é: " + largura + " x " + altura);
    }
}
