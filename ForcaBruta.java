import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForcaBruta{
    
    static List<Character> gerarCaracters() {
        List<Character> chars = new ArrayList<>();
        for(int i= 97; i <= 122; i++){
            chars.add((char) i);
        }
        for(int i= 65; i <= 90; i++){
            chars.add((char) i);
        }
        for(int i= 48; i <= 57; i++){
            chars.add((char) i);
        }
        return chars;
    }

    static String forcaBruta(List<Character> chars, String senha, int lenSenha){
        int tentativa = 0;
        List<Character> comb = new ArrayList<>(lenSenha);
        for(int i = 0; i < lenSenha; i++){
            comb.add(chars.get(0));
        }
        while (true) {
            StringBuilder combina = new StringBuilder();
            for(char c: comb){
                combina.append(c);
            }
            tentativa++;
            if (tentativa % 500000 == 0) {
                System.out.printf("%10d --> %s%n", tentativa, combina.toString());
            }
            if (senha.equals(combina.toString())) {
                return String.format("Senha encontrada é  |%s| , após %d tentativas", combina, tentativa);
            }

            int index = lenSenha - 1;
            while (index >= 0) {
                if(comb.get(index) == chars.get(chars.size() - 1)){
                    comb.set(index, chars.get(0));
                    index --;
                } else{
                    int charIndex = chars.indexOf(comb.get(index));
                    comb.set(index, chars.get(charIndex + 1));
                    break;
                }
            }
            if(index < 0) {
                break;
            }
        }
        return "Senha NÃO encontrada";
    }

        public static void main(String[] args) {
            List<Character> chars = gerarCaracters();
            Scanner scanner = new Scanner(System.in);

            System.out.printf("Informe a senha que deseja que a força bruta busque:");
            String senha = scanner.nextLine();

            System.out.println("**********************************************");
            System.out.println(forcaBruta(chars, senha, senha.length()));
            System.out.println("**********************************************");

        }
}