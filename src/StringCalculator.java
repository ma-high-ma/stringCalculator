/**
 * Created by juhi on 07/08/21.
 */
public class StringCalculator {

    public int Add(String numbers) {

        String delimiter;

        if (numbers.length() > 0) {

            //Delimiter specified by user
            if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {

                String[] splitNumbers = numbers.split("\\n",2);
                delimiter = "\\"+splitNumbers[0].substring(2, splitNumbers[0].length());
//                System.out.println("deli = "+delimiter);
//                System.out.println("string sent = "+splitNumbers[1]);
                return computeSum(splitNumbers[1], delimiter);

            }
            else {

                delimiter = ",|\\n";
                return computeSum(numbers, delimiter);

            }

        }

        return 0;
    }

    private int computeSum(String str, String delimiter) {

        String[] splitNumbers = str.split(delimiter);
//        System.out.println("split = "+splitNumbers[0]);
        int sum = 0;
        for (String a : splitNumbers) {
            sum += Integer.parseInt(a.trim());
        }
        return sum;
    }
}
