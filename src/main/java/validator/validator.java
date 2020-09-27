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
        Scanner scan = new Scanner(System.in);
        Stack<Character> pilha = new Stack<>();
        String palavra = scan.next();
        Boolean falha = false;
        char charPilha;
        

        OUTER:
        for (int i = 0; i < palavra.length(); i++) {
            switch (palavra.charAt(i)) {
                case '[':
                case '(':
                case '{':
                case '<':
                    pilha.push(palavra.charAt(i));
                    break;
                case ']':
                case ')':
                case '}':
                case '>':
                    if (pilha.empty()) {
                        System.out.println("Palavra inválida");
                        falha = true;
                        break OUTER;
                    }
                    charPilha = pilha.pop();
                    if ((charPilha == '[' && palavra.charAt(i) == ']') || (charPilha == '{' && palavra.charAt(i) == '}') || (charPilha == '(' && palavra.charAt(i) == ')')
                            || (charPilha == '<' && palavra.charAt(i) == '>')) {
                        continue;
                    }   falha = true;
                    System.out.println("Palavra inválida");
                    break OUTER;
                default:
                    falha = true;
                    System.out.println("Caracteres inválidos detectados");
                    break OUTER;
            }
        }
        
        if(!falha){
            System.out.println("Palavra válida");
        }
        
    }
    
}
