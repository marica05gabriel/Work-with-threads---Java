package Others;
/*
Ceva cod luat de pe aici
link:
https://www.codejava.net/java-se/swing/redirect-standard-output-streams-to-jtextarea
*/

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

public class CustomOutputStream  extends OutputStream {
    private JTextArea textArea;

    public CustomOutputStream(JTextArea _textArea){
        textArea = _textArea;
    }

    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        textArea.append(String.valueOf((char)b));

        // scrolls the text area to the end of data
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
