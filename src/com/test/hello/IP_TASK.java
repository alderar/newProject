package com.test.hello;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

public class IP_TASK {
    private static final long factor0 = 256 * 256 * 256;
    private static final long factor1 = 256 * 256;
    private static final long factor2 = 256;

    public static long ipToLong(InetAddress ip) {
        byte ipByte[] = ip.getAddress();
        int i0 = ipByte[0];
        if (i0 < 0) i0 += 256;

        int i1 = ipByte[1];
        if (i1 < 0) i1 += 256;

        int i2 = ipByte[2];
        if (i2 < 0) i2 += 256;

        int i3 = ipByte[3];
        if (i3 < 0) i3 += 256;

        return (factor0 * i0) + (factor1 * i1) + (factor2 * i2) + i3;
    }

    public static String longToIp(long ip) {
        long tmp = ip;
        long part0 = tmp / factor0; tmp -= (part0 * factor0);
        long part1 = tmp / factor1; tmp -= (part1 * factor1);
        long part2 = tmp / factor2; tmp -= (part2 * factor2);
        long part3 = tmp;
        String ipStr = part0 + "." + part1 + "." + part2 + "." + part3;
        return ipStr;
    }

    public static void main(String[] args) throws UnknownHostException{
        Scanner in = new Scanner(System.in);
        System.out.print("Введите 1-й IP-адрес: ");
        String strIp1 = in.nextLine();
        System.out.print("Введите 2-й IP-адрес: ");
        String strIp2 = in.nextLine();

        ArrayList<String> listIp = new ArrayList<>();
        InetAddress ip1 = InetAddress.getByName(strIp1);
        InetAddress ip2 = InetAddress.getByName(strIp2);

        long l1 = IP_TASK.ipToLong(ip1);
        long l2 = IP_TASK.ipToLong(ip2);

        long res = Math.abs(l1 - l2);

        if (l2 > l1) {
            for (long i = 1; i < res; i++) {
                listIp.add(IP_TASK.longToIp(l1 + i));
            }
        } else {
            for (long i = 1; i < res; i++) {
                listIp.add(IP_TASK.longToIp(l2 + i));
            }
        }

        listIp.forEach((x)-> System.out.println(x));
    }

}
