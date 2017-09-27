package Pacote;

import java.io.*;
import java.net.*;
import java.security.MessageDigest;

class TCPServer {

    public static void main(String argv[]) throws Exception {
        String clientSentence;
        String capitalizedSentence;

        ServerSocket welcomeSocket = new ServerSocket(6789);
        System.out.println("Servidor");
        while (true) {

            Socket connectionSocket = welcomeSocket.accept();

            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            clientSentence = inFromClient.readLine();

            capitalizedSentence = clientSentence;

            System.out.println("recebeu: " + capitalizedSentence);
            String[] mensagem;

            mensagem = capitalizedSentence.split(";");

            //Gera o Hash apartir da mensagem enviada
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(mensagem[0].getBytes());
            byte[] hashMd5 = md.digest();

            System.out.println("Mensagem: " + mensagem[0]);
            System.out.println("hash enviado pelo cliente: " + mensagem[1]);
            System.out.println("hash Gerado pelo servidor: " + stringHexa(hashMd5));

            //compara hash recebido e hash gerado
            if (mensagem[1].equals(stringHexa(hashMd5))) {
                System.out.println("Confirmado Mensagem iguais!!!!");
                capitalizedSentence = mensagem[0] + ";" + stringHexa(hashMd5) + ";" + "Mensagem autenticada";
            } else {
                System.out.println("Dirente Mensagem ERRO");
                capitalizedSentence = mensagem[0] + ";" + stringHexa(hashMd5) + ";" + "Mesagem com erro";
            }

            
            //saida
            outToClient.writeBytes(capitalizedSentence + '\n');
            System.out.println("Enviou: " + outToClient.toString());

        }

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
