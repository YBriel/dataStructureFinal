package cn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketDemo extends  Thread{

    ServerSocket serverSocket;

    int num=0;

    public ServerSocketDemo(){
        try {
            serverSocket=new ServerSocket(2888);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.start();
        System.out.println("服务器启动...");
    }

    public void run(){
        while (this.isAlive()){
            try {
                Socket socket=serverSocket.accept();
                BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line=br.readLine();
                System.out.println(line);
                PrintStream ps=new PrintStream(socket.getOutputStream());
                ps.println("您是第+"+(++num)+"个访问服务器的用户！");
                ps.flush();
                br.close();
                ps.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
     new ServerSocketDemo();
    }
}
