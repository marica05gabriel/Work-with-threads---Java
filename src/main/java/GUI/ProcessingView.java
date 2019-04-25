package GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class ProcessingView extends JFrame {
    private Timer timer;
    private int delay = 1000;
    private int counter;
    private int _endTime;

    private int nrOfTasks;
    private ArrayList<String> messages;
    private ArrayList<AtomicInteger> remainingTime;

    private ArrayList<JPanel> tasks;
    private ArrayList<JTextField> messagesTextField;
    private ArrayList<JLabel> remainingTimeLabel;
    private JPanel processingPanel;

    private JLabel timerLabel;


    public  static JTextArea textArea = new JTextArea(10,10);
    private JPanel textAreaPanel;



    private JPanel mainPanel;

    public ProcessingView() {
        super("Proiect Gabi ☺");
        nrOfTasks = 0;
        messages = new ArrayList<String>();


        tasks = new ArrayList<JPanel>();
        messagesTextField = new ArrayList<JTextField>();
        remainingTimeLabel = new ArrayList<JLabel>();
        remainingTime = new ArrayList<AtomicInteger>();

        textArea = new JTextArea(10, 30);
        textAreaPanel =  new JPanel();

        processingPanel = new JPanel();
        processingPanel.setLayout(new BoxLayout(processingPanel, BoxLayout.Y_AXIS));

        timerLabel = new JLabel("START");

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
    }

    public void initialize(int _nrOfTasks, ArrayList<String> _messages, ArrayList<AtomicInteger> _remainingTime){

        nrOfTasks = _nrOfTasks;
        messages = _messages;
        remainingTime = _remainingTime;

        textArea = new JTextArea(2*nrOfTasks, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane= new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        processingPanel.setSize(150, nrOfTasks*70);
        textAreaPanel.setSize(200, nrOfTasks*70);
        textAreaPanel.add(scrollPane);

        for(int i=0; i<nrOfTasks; i++) {
            JPanel aux = new JPanel();
            aux.setBackground(new Color(51,171,240));
            tasks.add(aux);
            tasks.get(i).setSize(150, 50);
            remainingTimeLabel.add( new JLabel(""));
            messagesTextField.add(new JTextField(30));


            tasks.get(i).add(remainingTimeLabel.get(i));
            tasks.get(i).add(messagesTextField.get(i));


            processingPanel.add(tasks.get(i));
        }


        JPanel aux = new JPanel();
        aux.setBackground(new Color(51,171,240));
        //processingPanel.setBackground(new Color(0,0,0,0));
        processingPanel.setBackground(new Color(51,171,240));
        //textAreaPanel.setBackground(new Color(0,0,0,0));
        textAreaPanel.setBackground(new Color(51,171,240));
        mainPanel.add(BorderLayout.CENTER, aux);
        mainPanel.add(BorderLayout.WEST, processingPanel);
        mainPanel.add(BorderLayout.EAST, textAreaPanel);

        setContentPane(mainPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, nrOfTasks*70);

        // Timer pannel
        JPanel timerPanel = new JPanel();
        //aux.setSize(, 50);
        timerPanel.add(timerLabel);
        mainPanel.add(BorderLayout.SOUTH, timerPanel);
    }

    public void startTimer(int endTime) {
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (counter == 0 ) {
                    timer.stop();
                } else {
                    //System.out.println("[ProcessingView] time remaining:"+counter);
                    for(int i=0;i<nrOfTasks;i++) {
                        messagesTextField.get(i).setText( messages.get(i));
                        remainingTimeLabel.get(i).setText( "Coada: "+(i+1)+" Timp_de procesare: " + remainingTime.get(i).toString());
                    }

                    counter--;
                }
                String aux ="TIME : "+ (_endTime - counter);
                timerLabel.setText(aux);
            }
        };


        timer = new Timer(delay,action);
        //timer.setInitialDelay(1000);
        timer.setInitialDelay(1000);
        timer.start();
        _endTime = endTime;
        counter = endTime;

    }

}
