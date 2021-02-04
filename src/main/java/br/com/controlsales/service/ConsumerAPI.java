package br.com.controlsales.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConsumerAPI {
	
	public HttpResponse<String> post(Map<String, String> values, String uri) {
		
		var objectMapper = new ObjectMapper();
		try {			
			String requestBody = objectMapper.writeValueAsString(values);
			System.out.println(requestBody);
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
					.POST(HttpRequest.BodyPublishers.ofString(requestBody))
					.header("Content-Type", "application/json")
					.uri(URI.create(uri))
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			
			return response;
			
		}catch(Exception e) {
			System.out.println("Erro ao cadastrar "+ e);
			return null;
		}
		
	}
	
	public String get(String uri) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request  = HttpRequest.newBuilder()
				.GET()
				.header("accept", "application/json")
				.uri(URI.create(uri))
				.build();
		try {		
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			return response.body();
		}catch(Exception e) {
			System.out.println("Erro ao listar" + e);
			
			return "Error";
		}
	}
	
	public boolean put(Map<String, String> values, String uri) {
		
		var objectMapper = new ObjectMapper();
		try {	
			
			String requestBody = objectMapper.writeValueAsString(values);
			HttpClient client = HttpClient.newHttpClient();	
			HttpRequest request = HttpRequest.newBuilder(URI.create(uri))	
					.version(Version.HTTP_1_1)
					.PUT(HttpRequest.BodyPublishers.ofString(requestBody))
					.header("Content-Type", "application/json")
					.build();
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
						
			return response.statusCode() >= 200 && response.statusCode() < 300;
				
		}catch(Exception e) {
			System.out.println("Erro ao atualizar "+ e);
			return false;
		}
		
	}
	

}
