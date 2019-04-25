package GUI;

import Others.CustomOutputStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class Controller {
    View view;
    ProcessingView processingView;
    Model model;

    // time
    private int nrOfTasks;
    private int minTimeNextClient;
    private int maxTimeNextClient;
    private int minTimeProcessing;
    private int maxTimeProcessing;
    private int endTime;

    private PrintStream printStream;

    public Controller(Model _model, View _view) {
        view = _view;
        model = _model;
        //processingView = _processingView;

        view.addSubmitListener(new SubmitListener());
        view.addInitializeListener(new InitializeButtonListener());
    }

    private class SubmitListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            nrOfTasks = view.getNrOfTasks();
            minTimeNextClient = view.getMinTimeNextClient();
            maxTimeNextClient = view.getMaxTimeNextClient();
            minTimeProcessing = view.getMinTimeProcessing();
            maxTimeProcessing = view.getMaxTimeProcessing();
            endTime = view.getEndTime();

            if(nrOfTasks !=0 && minTimeNextClient>0 && maxTimeNextClient>1 && minTimeProcessing>0 && maxTimeProcessing > 1) {
                model.initialize(nrOfTasks, minTimeNextClient, maxTimeNextClient, minTimeProcessing, maxTimeProcessing, endTime);
                model.start();
                view.setVisible(false);



                processingView = new ProcessingView();
                processingView.initialize(nrOfTasks, model.getMessages(), model.getRemainingTime());

                printStream = new PrintStream(new CustomOutputStream(ProcessingView.textArea));
                System.setOut(printStream);

                processingView.startTimer(endTime);


            }
        }

    }
    private class InitializeButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            view.setNrOfTasksTextField("3");
            view.setMinTimeNextClientTextField("2");
            view.setMaxTimeNextClientTextField("6");
            view.setMinTimeProcessingTextField("6");
            view.setMaxTimeProcessingTextField("15");
            view.setEndTimeTextField("30");

        }
    }




}
