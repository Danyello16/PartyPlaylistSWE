package com.party.playlist.battle;


import com.party.playlist.battle.http.RequestContext;
import com.party.playlist.battle.util.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class PartyPlaylistBattle {
    public static void main(String[] args) {
        System.out.println("Welcome to PartyPlaylistBattle");
        serverListening();
		
		
		
		
    }


    private static void serverListening() {
        ServerSocket serverSocket;
        try {
			
            serverSocket = new ServerSocket(10001);
            System.out.println("Listening for connection on port 10001 ...");
			
			
            while (true) {
                Socket socket = serverSocket.accept();
                handleRequest(socket);
            }
			
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket client) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String request = getRequestString(bufferedReader);
        System.out.println(request);
        RequestContext requestContext = new RequestContext(request);
        requestContext.printContexts();
		

        String usedMethod = requestContext.getMethod();


        if ((usedMethod.equals(Constants.POST) || usedMethod.equals(Constants.PUT))) {
            setPayLoad(bufferedReader, requestContext);
        }
		

        final HttpRouter httpRouter = new HttpRouter(requestContext);
        client.getOutputStream().write(httpRouter.router().getBytes(StandardCharsets.UTF_8));
        client.close();
    }

    private static String getRequestString(BufferedReader bufferedReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String lines = "";
        while (!(lines = bufferedReader.readLine()).isBlank()) {
            stringBuilder.append(lines + "\r\n");
        }
		
		
        String request = stringBuilder.toString();
        return request;
    }
	

    private static void setPayLoad(BufferedReader bufferedReader, RequestContext requestClient) throws IOException {
        int counter = Integer.parseInt(requestClient.getContentLength());
        int value;
        StringBuilder content = new StringBuilder();
        for (int j = 0; j < counter; j++) {
            value = bufferedReader.read();
            content.append((char) value);
        }
		
		
		
        requestClient.setPayload(content.toString());
        System.out.println(requestClient.getPayload());
    }
}
