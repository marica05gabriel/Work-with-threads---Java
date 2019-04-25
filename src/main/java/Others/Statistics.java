package Others;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Statistics {
    private float averageWaitingTime;
    private ArrayList<Integer> clientProcessingTimes;
    private int peakTime;
    private float peakValue;

    public Statistics(){
        averageWaitingTime = 0;
        peakTime = 0;
        clientProcessingTimes = new ArrayList<Integer>();
        peakValue = 0;
    }

    public float calculateAverageTime() {
        averageWaitingTime = 0;
        int size = clientProcessingTimes.size();
        for( int i =0; i<size; i++) {
            averageWaitingTime+=clientProcessingTimes.get(i);
        }
        averageWaitingTime/=size;
        return averageWaitingTime;
    }

    public int calculatePeakTime(int totalTime, int second) {
        if(peakValue < totalTime) {
            peakTime = second;
            peakValue = totalTime;
        }
        return peakTime;
    }

    public ArrayList<Integer> getClientProcessingTimes() {
        return clientProcessingTimes;
    }

    public float getAverageWaitingTime() {
        return averageWaitingTime;
    }

    public int getPeakTime() {
        return peakTime;
    }

    public float getPeakValue() {
        return peakValue;
    }
}
