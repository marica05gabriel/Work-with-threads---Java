package Server;

import Others.Client;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.sleep;

public class Task implements Runnable{
    private ArrayList<Client> queue;
    private AtomicInteger totalProcessingTime;
    private Server server;
    private ArrayList<String> message;

    public Task(Server _server) {
        server = _server;
        queue = new ArrayList<Client>();
        totalProcessingTime = new AtomicInteger();
        totalProcessingTime.set(0);
        message = new ArrayList<String>();

    }

    public void run() {

        while(server.getTimer() > 0  ) {

            if(!queue.isEmpty() ) {
                if(queue.get(0).getProcessingTime() > 0  ) {
                    try {
                        sleep(1000 );
                        queue.get(0).setProcessingTime( queue.get(0).getProcessingTime() - 1);
                        totalProcessingTime.set(totalProcessingTime.get()-1);
                    } catch (InterruptedException e) {
                        System.out.println("ERROR\nTask - sleep");
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Remove Client:"+queue.get(0).getName() );
                    removeClient();
                }

            } else {
                try {
                   sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("ERROR\nTask - wait");
                    e.printStackTrace();
                }
            }

        }
    }

    public synchronized void addClient(Client client){
        //System.out.println();
        totalProcessingTime.set(totalProcessingTime.get() + client.getProcessingTime());
        queue.add(client);
        message.add(client.getName());
        notifyAll();
    }

    private synchronized void removeClient()  {
        totalProcessingTime.set(totalProcessingTime.get() - queue.get(0).getProcessingTime());
        queue.remove(0);
        message.remove(0);
    }

    public AtomicInteger getTotalProcessingTime() {
        return totalProcessingTime;
    }

    public void setTotalProcessingTime(AtomicInteger totalProcessingTime) {
        this.totalProcessingTime = totalProcessingTime;
    }

    public String getMessage(){
        String rez = "";
        int length = message.size();
        for(int i=0; i<length; i++) {
            rez+=message.get(i) + " ";
        }
        //System.out.println("[TASK] "+ rez);
        return rez;
    }

}
