public class Main {



    public static void main(String[] args) throws Exception {


       FileLogger logger = new FileLogger();
       logger.setLoggingLevel(LoggingLevel.DEBUG);

       logger.info("Starting application");
       logger.debug("Calling method X");


    }
}
