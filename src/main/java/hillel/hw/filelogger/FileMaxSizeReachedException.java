package src.main.java.hillel.hw.filelogger;

public class FileMaxSizeReachedException extends Exception{
    public FileMaxSizeReachedException(String message){
        super(message);

    }
}