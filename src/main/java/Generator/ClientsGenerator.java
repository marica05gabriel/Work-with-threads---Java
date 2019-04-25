package Generator;

import Others.Client;
import Server.Server;

import java.util.Random;

import static java.lang.Thread.sleep;

public class ClientsGenerator extends Thread{
    private int minTimeNextClient;
    private int maxTimeNextClient;
    private int minTimeProcessingClient;
    private int maxTimeProcessingClient;
    private Server server;
    private static int  totalNumberOfClients;

    public ClientsGenerator(int _minTimeNextClient, int _maxTimeNextClient, int _minTimeProcessingClient, int _maxTimeProcessingClient, Server _server) {
        minTimeNextClient = _minTimeNextClient;
        maxTimeNextClient = _maxTimeNextClient;
        minTimeProcessingClient = _minTimeProcessingClient;
        maxTimeProcessingClient = _maxTimeProcessingClient;
        server = _server;
        totalNumberOfClients = 0;
    }



    public void run() {
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("[ClientsGenerator] start sleep error");
        }

        Random random = new Random();
        int processingTime;
        int newClientTime;
        int time1 = maxTimeNextClient - minTimeNextClient ;
        int time2 = maxTimeProcessingClient - minTimeProcessingClient ;

        while( server.getTimer() >0) {
            newClientTime = minTimeNextClient + random.nextInt(time1);
            processingTime = minTimeProcessingClient + random.nextInt(time2);


            Client client = Client.createClient(processingTime);
            if(client!=null) {
                server.addClient(client);
                totalNumberOfClients++;


            //System.out.println("Timpii generati: "+newClientTime + "  " + processingTime);
            //System.out.println(client.toString());

                try {
                    sleep(newClientTime*1000);
                } catch (InterruptedException e) {
                    System.out.println("ERROR\nClientsGenerator - sleep");
                    e.printStackTrace();
                }
            }
        }
    }
}
