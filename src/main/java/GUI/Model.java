package GUI;

import Generator.ClientsGenerator;
import Server.Server;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Model {
    private int nrOfTasks;
    private int minTimeNextClient;
    private int maxTimeNextClient;
    private int minTimeProcessing;
    private int maxTimeProcessing;
    private int endTime;

    private Server server ;

    public Model (){
        //server = new Server();
    }

    public void initialize(int _nrOfTasks, int _minTimeNextClient, int _maxTimeNextClient, int _minTimeProcessing, int _maxTimeProcessing, int _endTime) {
        nrOfTasks = _nrOfTasks;
        minTimeNextClient = _minTimeNextClient;
        maxTimeNextClient = _maxTimeNextClient;
        minTimeProcessing = _minTimeProcessing;
        maxTimeProcessing = _maxTimeProcessing;
        endTime = _endTime;
        server = new Server(endTime, nrOfTasks);

    }


    public void start() {
        // creating the Threads
        Server sv= new Server(endTime, nrOfTasks);
        server = sv;
        ClientsGenerator clientsGenerator = new ClientsGenerator(minTimeNextClient, maxTimeNextClient, minTimeProcessing, maxTimeProcessing, sv);
        Thread server = new Thread(sv);



        clientsGenerator.start();
        server.start();
    }

    public ArrayList<String> getMessages(){
        return server.getMessages();
    }

    public ArrayList<AtomicInteger> getRemainingTime() {
        return server.getTotalProcessingTime();
    }

}
