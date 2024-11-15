package app.filelogger;

public class FileMaxSizeReachedException extends RuntimeException{
    public FileMaxSizeReachedException(String msg){
        super(msg);
    }
}
