package Others;
/* ceva cod luat de aici :)
... chair daca poate nu se vede l-am scris de mana,
 nu am dat copy-paste
 link:
https://www.vogella.com/tutorials/Logging/article.html
*/

import java.io.IOException;
import java.util.logging.*;

public class MyLogger  {
    static private FileHandler fileTxt;
    static private SimpleFormatter formattetTxt;

    static public void setup() throws IOException {
        // get the global
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler("Logging_Gabi.txt");

        //create a TXT formatter
        formattetTxt = new SimpleFormatter();
        fileTxt.setFormatter(formattetTxt);
        logger.addHandler(fileTxt);
    }
}
