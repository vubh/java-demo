package com.example.v2.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 This class handles the client input for one server socket connection.
 */
public class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    /**
     Constructs a handler.
     @param i the incoming socket
     */
    public ThreadedEchoHandler(Socket i)
    {
        incoming = i;
    }

    @Override
    public void run()
    {
        try
        {
            try
            {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                Scanner in = new Scanner(inStream, "UTF-8");
                PrintWriter out = new PrintWriter(
                        new OutputStreamWriter(outStream, "UTF-8"),
                        true /* autoFlush */);

                out.println( "Hello! Enter BYE to exit." );

                // echo client input
                boolean done = false;
                while (!done && in.hasNextLine())
                {
                    String line = in.nextLine();
                    out.println("Echo: " + line);
                    if (line.trim().equals("BYE"))
                        done = true;
                }
            }
            finally
            {
                incoming.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
