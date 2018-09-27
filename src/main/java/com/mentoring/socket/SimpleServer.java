package com.mentoring.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket.getInetAddress());
            PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
//

            out.println("hello");
            out.print(-1);
            out.close();
            in.close();
            clientSocket.close();
        }

    }
}
