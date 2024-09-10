package A_3;


import java.util.*;

public class Assignment3 {

    //Digit Sum Loop method 
    public static void digitSumLoop(int number){
        Constants constant = new Constants();
        if(number < 10){
            System.out.println(constant.SINGLE_DIGIT);
        }else{
            String numString = Integer.toString(number);
        int[] digits = new int[numString.length()];

        for(int i = 0 ; i < numString.length() ; i++){
            digits[i] = numString.charAt(i) - '0';
        }

        int sum = 0;

        for(int i = 0 ; i < digits.length ; i++){
            sum += digits[i];
        }

        if(sum > 9){
            digitSumLoop(sum);
        }else{
            System.out.println(sum);
        }
        }
    }

    // Function to generate all combinations
    public static void combine(char[] chars, int start, String result) {
        if (!result.isEmpty()) {
            permute(result, "");  // Call permutations for each combination
        }

        // Recursively generate combinations
        for (int i = start; i < chars.length; i++) {
            combine(chars, i + 1, result + chars[i]);
        }
    }

    // Function to generate all permutations
    public static void permute(String str, String result) {
        if (str.length() == 0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permute(remaining, result + ch);
        }
    }

    public static void consecutiveNumber(int number){
        for(int start = 1 ; start <= number / 2 ; start++){
            int sum = 0;
            for(int end = start ; end <= number ; end++){
                sum += end ;
                if(sum == number){
                    printSequence(start, end);
                    break ;
                }else if(sum > number){
                    break ;
                }

            }
        }
    }

    public static void printSequence(int start, int end){
        for(int i = start ; i <= end ; i++){
            if(i == end){
                System.out.println(i);
            }else{
                System.out.print(i + "+");
            }
        }
    }

    public static void main(String[] args) {
        Constants constant = new Constants();
        Scanner input = new Scanner(System.in);
        boolean isQuit = true;
        while(isQuit){
            System.out.println(constant.OPERATION_TYPE);
            System.out.print(constant.OPERATION_NO);
            String operation = input.nextLine();

            switch (operation) {
                case "1":
                    while (true) {
                        try {
                            System.out.print(constant.ENTER_POSITIVE);
                            int number = input.nextInt();
                            input.nextLine(); 
                            if (number <= 0) {
                                System.out.println(constant.MUST_POSITIVE);
                                continue; 
                            }
                            System.out.print(constant.OUTPUT);
                            digitSumLoop(number);
                            break; 
                        } catch (InputMismatchException e) {
                            System.out.println(constant.INVALID_INPUT_INTEGER);
                            input.next(); 
                        }
                    }
                    break;
            
                case "2":
                    System.out.print(constant.ENTER_STRING);
                    String str = input.nextLine();
                    char[] chars = str.toCharArray();
                    System.out.println(constant.OUTPUT);
                    combine(chars, 0, "");
                    break;

                case "3" :
                    while (true) {
                        try {
                            System.out.print(constant.ENTER_POSITIVE);
                            int number = input.nextInt();
                            input.nextLine(); 
                            if (number <= 0) {
                                System.out.println(constant.MUST_POSITIVE);
                                continue; 
                            }
                            System.out.println(constant.OUTPUT);
                            consecutiveNumber(number);
                            break; 
                        } catch (InputMismatchException e) {
                            System.out.println(constant.INVALID_INPUT_INTEGER);
                            input.next(); 
                        }
                    }
                    break;
                case "0" :
                    isQuit = false;
                    break ;
            }
        }
        input.close();
    }
}
