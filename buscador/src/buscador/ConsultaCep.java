package buscador;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.management.RuntimeErrorException;

import com.google.gson.Gson;

public class ConsultaCep {

	public Endereco buscaEndereco(String cep) {
		URI endereco = URI.create("https://viacep.com.br/ws/" + cep + "/json");

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(endereco)
					.build();

		try {
			HttpResponse<String> response;
			response = HttpClient.newHttpClient()
					.send(request, HttpResponse.BodyHandlers.ofString());
			return new Gson().fromJson(response.body(), Endereco.class);

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
		throw new RuntimeErrorException(null, "Nao consegui obter o endereco a partir desse cep");

		}

	}
}
