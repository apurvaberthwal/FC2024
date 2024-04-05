package NumOperation;

public class ArmstrongNumber {
    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int digitCount = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digitCount);
            num /= 10;
        }

        return sum == originalNum;
    }
}


