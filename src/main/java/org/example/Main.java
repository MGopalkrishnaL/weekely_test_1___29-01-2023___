package org.example;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try{
            Send_HTTP_Request_and_Parse_JSON_Data_Using_Java();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
    public static void Send_HTTP_Request_and_Parse_JSON_Data_Using_Java() throws IOException, InterruptedException {
        String url = "https://jsonplaceholder.typicode.com/albums";
        //building a request
        HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        // getting http client object
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.body());
    }
}