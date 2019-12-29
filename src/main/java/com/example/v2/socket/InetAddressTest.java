package com.example.v2.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * InetAddress IP地址
 *
 * InetSocketAddress IP套字节地址（IP地址 + 端口）
 */
public class InetAddressTest
{
    public static void main(String[] args) throws IOException
    {

        InetAddress localHostAddress = InetAddress.getLocalHost();
        System.out.println(localHostAddress);

        InetSocketAddress inetSocketAddress = new InetSocketAddress(localHostAddress, 8000);
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getHostString());
        System.out.println(inetSocketAddress.getPort());
    }
}