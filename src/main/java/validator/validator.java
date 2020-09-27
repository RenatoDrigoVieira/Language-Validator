/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author oseas
 */
public class validator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Stack<Character> pilhaCaracteres = new Stack<>();
        Scanner scan = new Scanner(System.in);
        String palavra = scan.next();
        Boolean falha = false;
        char charPilha;
        

        OUTER:
        for (int i = 0; i < palavra.length(); i++) {
            switch (palavra.charAt(i)) {
                case '(':
                case '[':
                case '<':
                case '{':
                    pilhaCaracteres.push(palavra.charAt(i));
                    break;
                case ')':
                case '>':
                case '}':
                case ']':
                    if (pilhaCaracteres.empty()) {
                        System.out.println("Palavra não aceita");
                        falha = true;
                        break OUTER;
                    }
                    charPilha = pilhaCaracteres.pop();
                    if ( (charPilha == '<' && palavra.charAt(i) == '>')||  (charPilha == '{' && palavra.charAt(i) == '}') || (charPilha == '[' && palavra.charAt(i) == ']')|| (charPilha == '(' && palavra.charAt(i) == ')')
                            ) {
                        continue;
                    }   falha = true;
                    System.out.println("Palavra não aceita");
                    break OUTER;
                default:
                    falha = true;
                    System.out.println("Caracteres inválidos");
                    break OUTER;
            }
        }
        
        if(!falha){
            System.out.println("Palavra aceita");
        }
        
    }
    
}
