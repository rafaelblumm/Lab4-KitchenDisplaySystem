package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe que permite fazer leitura de dados do teclado.
 */

public class Teclado {
     private static String s;
     private static InputStreamReader i = new InputStreamReader (System.in);
     private static BufferedReader d = new BufferedReader(i);

     /**
        Lê um inteiro.
        @return int
     */
     public static int leInt () {
         int a = 0;

         try {
             s = d.readLine();
             a = Integer.parseInt(s);
         } catch (IOException e) {
        	 Msg.exibeErro(e);
         } catch (NumberFormatException e) {
        	 Msg.exibeErro("O valor digitado deve ser um inteiro");
         }

         return (a);
     }

     /**
        Lê um inteiro, com mensagem.
        @return int
     */
     public static int leInt (String msg) {
         int a = 0;
         System.out.println(msg);

         try {
             s = d.readLine();
             a = Integer.parseInt(s);
         } catch (IOException e) {
        	 Msg.exibeErro(e);
         } catch (NumberFormatException e) {
        	 Msg.exibeErro("O valor digitado deve ser um inteiro");
         }

         return (a);
     }

     /**
        Lê uma string.
        @return String
     */
     public static String leString() {
         s = "";

         try {
            s = d.readLine();
         } catch (IOException e) {
        	 Msg.exibeErro(e);
         }

         return (s);
     }

     /**
        Lê uma string, com mensagem.
        @return String
     */
     public static String leString(String msg) {
         s = "";
         System.out.println(msg);

         try {
            s = d.readLine();
         } catch (IOException e) {
        	 Msg.exibeErro(e);
         }

         return (s);
     }
}