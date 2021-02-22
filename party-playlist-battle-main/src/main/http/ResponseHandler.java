package com.party.playlist.battle.http;





public class ResponseHandler {




    public static String response(String responseMessage, String statusCode, String statusMessage) {




        return "HTTP/1.1 " + statusCode + " " + statusMessage + "\r\n"
						+ "Content-Type: text/html\r\n"
						+ "Accept-Ranges: bytes \r\n"
						+ "Server: Daniel \r\n"
						+ "Status: " + statusCode + " \r\n"
						+ "Content-Lenght: 61 \r\n\r\n" + responseMessage;
    }
}
