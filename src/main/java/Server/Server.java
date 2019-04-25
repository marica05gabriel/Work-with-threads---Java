package Server;

import Others.Client;
import Others.MyLogger;
import Others.Statistics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class Server implements Runnable{
    private int timer;
    private int endTime;
    private int numberOfTasks;
    private ArrayList<Task> tasks;
    private ArrayList<String> messages;
    private ArrayList<AtomicInteger> totalProcessingTime;
    private Statistics statistics;


    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Server(int _endTime, int _numberOfTasks) {
        numberOfTasks = _numberOfTasks;
        timer = _endTime;
        endTime = _endTime;
        tasks = new ArrayList<Task>();
        messages = new ArrayList<String>();
        totalProcessingTime = new ArrayList<AtomicInteger>();
        try {
            MyLogger.setup();
        } catch( IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log file");
        }
        statistics = new Statistics();

    }

    public void run() {
        for(int i=0;  i < numberOfTasks; i++) {
            tasks.add(new Task(this) );
            Thread thread = new Thread(( tasks.get(i)));
            thread.start();
        }



        while(timer > 0 ) {
            try {
                sleep(1000);
                //System.out.println("REMAINING TIME: " + timer);
            } catch (InterruptedException e) {
                System.out.println("ERROR\nServer - sleep");
                e.printStackTrace();
            }
            timer --;
            setMessages();
            setTotalProcessingTime();
            statistics.calculatePeakTime( calculateTotalTimeAllTasks(),endTime- timer );
        }

        statistics.calculateAverageTime();
        System.out.println("[Statistics] Average waiting time: "+ statistics.getAverageWaitingTime());
        System.out.println("[Statistics] Peak time: "+ statistics.getPeakTime() + "  Peak value: "+ (statistics.getPeakValue()/numberOfTasks));
        LOGGER.info("[Statistics] Average waiting time: "+ statistics.getAverageWaitingTime());
        LOGGER.info("[Statistics] Peak time: "+ statistics.getPeakTime());

        System.out.println("[ProcessingView] time passed");

    }

    public synchronized void addClient(Client client) {
        // add client to the queue
        int taskIndex=0;
        taskIndex = giveMeTheTask();
        tasks.get(taskIndex).addClient(client);

        statistics.getClientProcessingTimes().add(client.getProcessingTime());

        System.out.println(client.getName()+ " P.T: "+ client.getProcessingTime() + " repartizat la coada: "+(taskIndex+1));
        LOGGER.info(client.getName()+ " P.T: "+ client.getProcessingTime() + " repartizat la coada: "+(taskIndex+1));
    }

    private int giveMeTheTask(){
        int index = 0;
        int minTime = tasks.get(0).getTotalProcessingTime().get();
        int timeTask = 0;

        int size = tasks.size();
        for(int i=0; i < size; i++) {
            timeTask = tasks.get(i).getTotalProcessingTime().get();
            //System.out.println("[SERVER] TimeTask["+i+"] "+timeTask);
            if( minTime >  timeTask) {
                minTime = (tasks.get(i).getTotalProcessingTime().get());
                index = i;
            }
        }
        //System.out.println("Cea mai libera coada: "+index );
        return index;
    }

    public void setMessages() {
        messages.clear();
        for(int i=0; i<numberOfTasks; i++) {
            messages.add(tasks.get(i).getMessage());
        }
    }

    public void setTotalProcessingTime(){
        totalProcessingTime.clear();
        for(int i=0;i<numberOfTasks; i++) {
            totalProcessingTime.add(tasks.get(i).getTotalProcessingTime());
        }
    }

    public ArrayList<String> getMessages(){
        return messages;
    }

    public int getTimer() {
        return timer;
    }

    private int calculateTotalTimeAllTasks() {
        int size = totalProcessingTime.size();
        int sum = 0;
        for(int i=0; i<size; i++) {
            sum+=totalProcessingTime.get(i).get();
        }
        return sum;
    }



    public ArrayList<AtomicInteger> getTotalProcessingTime() {
        return totalProcessingTime;
    }
}
