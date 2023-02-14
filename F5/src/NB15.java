import static java.lang.Math.pow;

public class NB15 {
    public static void main(String [] args){
        System.out.println(binaryToDecimal("1011"));
        System.out.println(decimalToBinary(11));
    }

    static int binaryToDecimal(String binary){
        return binaryToDecimal(binary, 0, 0);
    }

    private static int binaryToDecimal(String binary, int decimal, int n){
        if(n == binary.length())
            return decimal;
        else{
            char[] binaryChar = binary.toCharArray();
            if(binaryChar[binaryChar.length - n - 1] == '1')
                return binaryToDecimal(binary, (int) (decimal + pow(2, n)), n + 1);
            else
                return binaryToDecimal(binary, decimal, n + 1);
        }
    }

    static String decimalToBinary(int decimal){
        return decimalToBinary(decimal, "");
    }

    private static String decimalToBinary(int decimal, String binary){
        if(decimal == 0)
            return binary;

        binary = decimal % 2 + binary;
        return decimalToBinary(decimal / 2, binary);
    }
}
