package masterdev.br.com.zup.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogGame {
    private final static Logger logger =Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void log(String message)
    {
        // add some code of your choice here
        // Moving to the logging part now
        logger.log(Level.INFO, message);

        // A log of INFO level with the message "My First Log Message"
    }
    public void error(String message)
    {
        // add some code of your choice here
        // Moving to the logging part now
        logger.severe(message);

        // A log of INFO level with the message "My First Log Message"
    }
}