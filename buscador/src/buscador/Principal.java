package buscador;

import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsultaCep consulta = new ConsultaCep();
		Scanner leitura = new Scanner(System.in);
		
		System.out.println("Digite um cep");
		var cep = leitura.nextLine();
		
		try {
			Endereco novoEndereco = consulta.buscaEndereco(cep);
			System.out.println(novoEndereco);
			GeradorDeArquivo gerador =  new GeradorDeArquivo();
			gerador.salvaJson(novoEndereco);
		}catch(RuntimeException | IOException e) {
		 System.err.println(e.getMessage() + "\n Finalizando a aplicacao");
		}
		
	}

}
