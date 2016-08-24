package TestDataManagement;


import java.util.Random;

public class RandomDataGenerator {


    public RandomDataGenerator GetRandomString(int length){

        String characters = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        
        return sb.toString();
    }


}
