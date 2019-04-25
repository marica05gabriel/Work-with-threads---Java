import GUI.Controller;
import GUI.Model;
import GUI.View;
import Generator.ClientsGenerator;
import Server.Server;

import javax.swing.*;

public class DemoProject {

    public static void main(String[] args) {
         /*int minTimeNextClient          = 2;
         int maxTimeNextClient          = 6;
         int minTimeProcessingClient    = 4;
         int maxTimeProcessingClient    = 10;
         int endTime                    = 30;
         int numberOfTasks              = 3;


        Server sv = new Server(endTime, numberOfTasks);
        ClientsGenerator clientsGenerator = new ClientsGenerator(minTimeNextClient, maxTimeNextClient, minTimeProcessingClient, maxTimeProcessingClient, sv);

        Thread server = new Thread(sv);
        //Thread clientsGeneratorThread = new Thread(clientsGenerator);
        server.start();
        clientsGenerator.start();
        //clientsGeneratorThread.start();*/

        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
    }
}
