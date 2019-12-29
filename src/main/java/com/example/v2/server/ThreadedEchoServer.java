package com.example.v2.server;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 This program implements a multithreaded server that listens to port 8189 and echoes back
 all client input.
 @author Cay Horstmann
 @version 1.21 2012-06-04
 */
public class ThreadedEchoServer
{
    public static void main(String[] args )
    {
        try
        {
            int i = 1;
            ServerSocket s = new ServerSocket(8189);

            while (true)
            {
                Socket incoming = s.accept();
                System.out.println("Spawning " + i);
                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);
                t.start();
                i++;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
