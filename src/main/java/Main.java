

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Created by user54 on 29.02.2016.
 */
public class Main  {
    public static void main(String[] args) {
        System.out.println("Enter number from 0 to 20 : ");
        Integer inputNumber = readInput();
        Integer secretNumber = generateNumber();

        while(!checkNumber(inputNumber, secretNumber)) {
            inputNumber = readInput();
        }
    }

    private static boolean checkNumber(int inputNumber, int secretNumber) {
        int signum = Integer.signum(inputNumber - secretNumber);
        switch(signum) {
            case -1:
                System.out.println(" Input number is less than random!  ");
                break;
            case 0:
                System.out.println(" Correct! ");
                return true;
            case 1:
                System.out.println(" Input number is more than random! ");
                break;
        }

        return false;
    }

    private static Integer generateNumber() {
        Random random = new Random();
        Integer randomNumber = random.nextInt(10);

        return randomNumber;
    }

    private static Integer readInput() {
        Integer inputNumber = null;

        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String inputString = bufferRead.readLine();
            inputNumber = Integer.parseInt(inputString);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return inputNumber;
    }

}