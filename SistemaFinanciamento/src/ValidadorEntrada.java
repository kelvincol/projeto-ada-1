import java.util.Scanner;

public class ValidadorEntrada {

    // Valida nome: apenas letras e espaços
    public static String lerNome(Scanner sc) throws DadoInvalidoException {
        String nome = sc.nextLine().trim();
        if (!nome.matches("^[A-Za-zÀ-ÖØ-öø-ÿ ]+$")) {
            throw new DadoInvalidoException("Nome inválido! Digite apenas letras e espaços.");
        }
        return nome;
    }

    // Lê e valida inteiro (ex: idade)
    public static int lerInteiro(Scanner sc) throws DadoInvalidoException {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new DadoInvalidoException("Valor informado não é válido, insira outro valor.");
        }
    }

    // Lê e valida número decimal (ex: renda, valores de bens)
    public static double lerDouble(Scanner sc) throws DadoInvalidoException {
        try {
            return Double.parseDouble(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new DadoInvalidoException("Valor informado não é válido, insira outro valor.");
        }
    }
}
