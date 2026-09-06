/* 
    Tipos primitivos em Java, são os tipos de dados que representam valores simples, como números inteiros, números de ponto flutuante, caracters e valores booleanos (true ou false).
    Saída de dados é quando o programa fornece informações para o usuário.
    Entrada de dados é quando o usuário fornece informações para o programa.

*/

package tiposprimitivos;

public class TiposPrimitivos {
    public static void main(String[] args) {

        String nome = "Ricardo";
        float nota = 2.5f;
        int idade = 20;
        char sexo = 'M';
        boolean estudando = true;

        System.out.println("Nome: " + nome);
        System.out.printf("Nota: %.2f%n", nota);
        System.out.println("Idade: " + idade);
        System.out.println("Sexo: " + sexo);
        System.out.println("Estudando: " + estudando);
    }
}