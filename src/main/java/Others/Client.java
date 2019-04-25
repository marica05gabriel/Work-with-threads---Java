package Others;

public class Client {
    private String name;
    private int processingTime;
    private static int nrOfClients=0;

    //............................................... CONSTRUCTORS...............................................
    private Client(int _processingTime) {
        nrOfClients++;
        name = "C"+nrOfClients;
        processingTime = _processingTime;
        //System.out.println("CLIENT: S-a creat clientul:"+name +" Processing time:"+ processingTime);

    }

    private Client(int _processingTime, String _name) {
        nrOfClients++;
        processingTime = _processingTime;
        name = "C"+nrOfClients;
        //System.out.println("CLIENT: S-a creat clientul:"+name+" Processing time:"+ processingTime);

    }
    //..................................................................................................................

    //............................................... FABRICATION METHODS...............................................
    public static Client createClient(int _processingTime) {
        if (_processingTime >= 0) {

            return new Client(_processingTime);
        } else {
            System.out.println("ERROR\nwrong processing time");
            return null;
        }
    }

    public static Client createClient(int _processingTime, String name) {
        if (_processingTime >= 0) {
            return new Client(_processingTime, name);
        } else {
            System.out.println("ERROR\nwrong processing time");
            return null;
        }
    }
    //..................................................................................................................


    public int getProcessingTime() {
        return processingTime;
    }

    public String getName() {
        return name;
    }
    public String toString() {
        return name + "     " + processingTime;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }
}
