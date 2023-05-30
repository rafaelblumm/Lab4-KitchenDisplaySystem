package ui;

import java.io.IOException;

/**
 * Classe que permite a exibição de mensagens de sucesso e erro formatadas com cores.
 */

public class Msg {
	
	public static final String ANSI_VERMELHO = "\u001B[31m";
	public static final String ANSI_VERDE = "\u001B[32m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	/**
	 * Exibe mensagem de erro formatada em vermelho.
	 * Ex.: '> ERRO: [mensagem_de_erro].".
	 * 
	 * @param msg (String) Mensagem personalizada.
	 */
	public static void exibeErro(String msg) {
		System.out.println(ANSI_VERMELHO + "> ERRO: " + msg + "." + ANSI_RESET);
	}
	
	/**
	 * Exibe mensagem de erro formatada em vermelho.
	 * Ex.: '> ERRO: [mensagem_de_erro].".
	 * 
	 * @param e (IOException) Erro de I/O.
	 */
	public static void exibeErro(IOException e) {
		System.out.println(ANSI_VERMELHO + "> ERRO: " + e + "." + ANSI_RESET);
	}
	
	/**
	 * Exibe mensagem de sucesso formatada.
	 * Ex.: '> SUCESSO!
	 *       > [mensagem_de_sucesso].'
	 *       
	 * @param msg (String) Mensagem personalizada.
	 */
	public static void exibeSucesso(String msg) {
		System.out.println(ANSI_VERDE + "> SUCESSO!\n> " + msg + "." + ANSI_RESET);
	}
}
