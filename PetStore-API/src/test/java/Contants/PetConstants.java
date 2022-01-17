package Contants;

import java.util.Random;

public interface PetConstants {


    public  String POST_ENDPOINT = "/pet";
    public  String GET_ENDPOINT = "/pet/";
    public  String PUT_ENDPOINT = "/pet";
    public  String DELETE_ENDPOINT = "/pet/";
    public  String GET_findByStatus_Pending = "/pet/findByStatus?status=pending";
    public  String GET_findByStatus_Available = "/pet/findByStatus?status=available";
    public  String GET_findByStatus_Sold = "/pet/findByStatus?status=sold";

     default int numberGenerator(int low, int high) {

        Random r = new Random();
        int lowvalue = low;
        int highvalue = high;
        int result = r.nextInt(highvalue - lowvalue) + lowvalue;
        return result;
    }

    public default void sleep(int second) {
        try {
            Thread.sleep(second);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


}
