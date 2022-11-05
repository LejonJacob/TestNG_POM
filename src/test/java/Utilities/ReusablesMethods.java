package Utilities;

public class ReusablesMethods {

    public static void waiting(int saniye){

        try {
            Thread.sleep(saniye*1000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
