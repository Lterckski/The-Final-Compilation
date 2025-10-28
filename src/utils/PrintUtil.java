package utils;

public class PrintUtil {
    public static void delay(int delay){
        try{
            Thread.sleep(delay);
        } catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
