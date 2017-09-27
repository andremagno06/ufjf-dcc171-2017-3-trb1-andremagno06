package Pacote;

import java.io.*;
import java.net.*;
import java.security.MessageDigest;

class TCPClient {

    public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence;
        System.out.println("Cliente");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

       

        Socket clientSocket = new Socket("192.168.1.101", 6789);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        sentence = inFromUser.readLine();

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(sentence.getBytes());
        byte[] hashMd5 = md.digest();

        String hash = stringHexa(hashMd5);

        outToServer.writeBytes(sentence+";"+hash+'\n');
        System.out.println("Enviou:"+sentence+";"+hash+'\n');
        
        
        modifiedSentence = inFromServer.readLine();

        System.out.println("FROM SERVER: " + modifiedSentence);

        clientSocket.close();

    }

    private static String stringHexa(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }
}
