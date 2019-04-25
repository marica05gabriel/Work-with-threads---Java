package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{

    JLabel mainLabel ;

    private JLabel startMessageLabel = new JLabel("Hello! Please complete the following textfields");

    private JLabel nrOfTasksLabel = new JLabel("Number of tasks:");
    private JTextField nrOfTasksTextField = new JTextField(7);

    private JLabel minTimeNextClientLabel = new JLabel("Min time for next client:");
    private JLabel maxTimeNextClientLabel = new JLabel("Max time for next client:");
    private JTextField minTimeNextClientTextField = new JTextField(7);
    private JTextField maxTimeNextClientTextField = new JTextField(7);

    private JLabel minTimeProcessingLabel = new JLabel("Min processing time:");
    private JLabel maxTimeProcessingLabel = new JLabel("Max processing time:");
    private JTextField minTimeProcessingTextField = new JTextField( 7);
    private JTextField maxTimeProcessingTextField = new JTextField(7);

    private JLabel endTimeLabel = new JLabel("End time:");
    private JTextField endTimeTextField = new JTextField(10);

    private JButton submit =  new JButton("Submit");
    private JButton initializeButton =  new JButton("Initialize Button");

    public View (){
        super("Proiect Gabi ☺");
        setSize(400, 300);
        mainLabel = new JLabel(new ImageIcon("123.jpg"));

        JPanel mainPannel = new JPanel();
        mainPannel.setLayout(new BoxLayout(mainPannel, BoxLayout.Y_AXIS));
        mainPannel.setSize(400, 300);

        mainLabel.setLayout(new BoxLayout(mainLabel, BoxLayout.Y_AXIS));
        mainLabel.setSize(400, 300);

        JPanel startMessagePanel = new JPanel();
        startMessagePanel.add(startMessageLabel);
        startMessagePanel.setBackground(new Color(0,0,0,0));
        mainPannel.add(startMessagePanel);
        mainLabel.add(startMessagePanel);


        JPanel nrOfTasksPanel = new JPanel();
        nrOfTasksPanel.add(nrOfTasksLabel);
        nrOfTasksPanel.add(nrOfTasksTextField);
        nrOfTasksPanel.setBackground(new Color(0,0,0,0));
        mainPannel.add(nrOfTasksPanel);
        mainLabel.add(nrOfTasksPanel);

        JPanel minTimeNextClientPanel = new JPanel();
        minTimeNextClientPanel.add(minTimeNextClientLabel);
        minTimeNextClientPanel.add(minTimeNextClientTextField);
        minTimeNextClientPanel.setBackground(new Color(0,0,0,0));
        mainPannel.add(minTimeNextClientPanel);
        mainLabel.add(minTimeNextClientPanel);

        JPanel maxTimeNextClientPanel = new JPanel();
        maxTimeNextClientPanel.add(maxTimeNextClientLabel);
        maxTimeNextClientPanel.add(maxTimeNextClientTextField);
        maxTimeNextClientPanel.setBackground(new Color(0,0,0,0));
        mainPannel.add(maxTimeNextClientPanel);
        mainLabel.add(maxTimeNextClientPanel);

        JPanel minTimeProcessingPanel = new JPanel();
        minTimeProcessingPanel.add(minTimeProcessingLabel);
        minTimeProcessingPanel.add(minTimeProcessingTextField);
        minTimeProcessingPanel.setBackground(new Color(0,0,0,0));
        mainPannel.add(minTimeProcessingPanel);
        mainLabel.add(minTimeProcessingPanel);

        JPanel maxTimeProcessingPanel = new JPanel();
        maxTimeProcessingPanel.add(maxTimeProcessingLabel);
        maxTimeProcessingPanel.add(maxTimeProcessingTextField);
        maxTimeProcessingPanel.setBackground(new Color(0,0,0,0));
        mainPannel.add(maxTimeProcessingPanel);
        mainLabel.add(maxTimeProcessingPanel);

        JPanel endTimePanel = new JPanel();
        endTimePanel.add(endTimeLabel);
        endTimePanel.add(endTimeTextField);
        endTimePanel.setBackground(new Color(0,0,0,0));
        mainPannel.add(endTimePanel);
        mainLabel.add(endTimePanel);

        JPanel submitPanel = new JPanel();
        submitPanel.add(submit);
        submitPanel.add(initializeButton);
        submitPanel.setBackground(new Color(0,0,0,0));
        mainPannel.add(submitPanel);
        mainLabel.add(submitPanel);

        //setContentPane(mainPannel);
        setContentPane(mainLabel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addSubmitListener(ActionListener actionListener) {
        submit.addActionListener(actionListener);
    }

    public void addInitializeListener(ActionListener actionListener){
        initializeButton.addActionListener(actionListener);
    }
    public int getNrOfTasks() {
        int nrOfTasks = 0;

        try {
            nrOfTasks = Integer.parseInt(nrOfTasksTextField.getText());

        } catch(NumberFormatException e) {
            System.out.println("ERROR\nwrong number of tasks");
            e.printStackTrace();
        }
        return nrOfTasks;
    }

    public int getMinTimeNextClient() {
        int minTimeNextClient = 0;

        try {
            minTimeNextClient = Integer.parseInt(minTimeNextClientTextField.getText());

        } catch(NumberFormatException e) {
            System.out.println("ERROR\nwrong minTimeNextClient");
            e.printStackTrace();
        }
        return minTimeNextClient;
    }

    public int getMaxTimeNextClient() {
        int maxTimeNextClient = 0;

        try {
            maxTimeNextClient = Integer.parseInt(maxTimeNextClientTextField.getText());

        } catch(NumberFormatException e) {
            System.out.println("ERROR\nwrong maxTimeNextClient");
            e.printStackTrace();
        }
        return maxTimeNextClient;
    }

    public int getMinTimeProcessing() {
        int minTimeProcessing = 0;

        try {
            minTimeProcessing = Integer.parseInt(minTimeProcessingTextField.getText());

        } catch(NumberFormatException e) {
            System.out.println("ERROR\nwrong minTimeProcessing");
            e.printStackTrace();
        }
        return minTimeProcessing;
    }

    public int getMaxTimeProcessing() {
        int maxTimeProcessing = 0;

        try {
            maxTimeProcessing = Integer.parseInt(maxTimeProcessingTextField.getText());

        } catch(NumberFormatException e) {
            System.out.println("ERROR\nwrong maxTimeProcessing");
            e.printStackTrace();
        }
        return maxTimeProcessing;
    }

    public int getEndTime() {
        int endTime = 0;

        try {
            endTime = Integer.parseInt(endTimeTextField.getText());

        } catch(NumberFormatException e) {
            System.out.println("ERROR\nwrong endTIme");
            e.printStackTrace();
        }
        return endTime;
    }

    public void setNrOfTasksTextField(String text) {
        nrOfTasksTextField.setText(text);
    }

    public void setMinTimeNextClientTextField(String text) {
        minTimeNextClientTextField.setText(text);
    }

    public void setMaxTimeNextClientTextField(String text) {
        maxTimeNextClientTextField.setText(text);
    }

    public void setMinTimeProcessingTextField(String text) {
        minTimeProcessingTextField.setText(text);
    }

    public void setMaxTimeProcessingTextField(String text) {
        maxTimeProcessingTextField.setText(text);
    }

    public void setEndTimeTextField(String text) {
        endTimeTextField.setText(text);
    }
}
