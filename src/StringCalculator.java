/**
 * Created by juhi on 07/08/21.
 */
public class StringCalculator {

    public int Add(String numbers) throws Exception{

        String regex = "";

        if (numbers.length() > 0) {

            //Delimiter specified by user
            if (numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {

                String[] splitNumbers = numbers.split("\\n",2);

                String[] multipleDelimiters = splitNumbers[0].substring(2, splitNumbers[0].length()).split("\\[|\\]");
                for (String a : multipleDelimiters) {
                    if (!a.isEmpty()) {
                        regex += "[\\"+a+"]|";
                    }

                }
                regex = regex.substring(0,regex.length()-1);
                return computeSum(splitNumbers[1], regex);

            }
            else {

                regex = ",|\\n";
                return computeSum(numbers, regex);

            }

        }

        return 0;
    }

    private int computeSum(String str, String delimiter) throws Exception{

        int integer, flag = 0;
        String negatives = "";
        String[] splitNumbers = str.split(delimiter);
        int sum = 0;
        for (String a : splitNumbers) {
            if(a.isEmpty()){
                continue;
            }
            integer = Integer.parseInt(a.trim());
            if (integer < 0) {

                flag = 1;
                negatives += integer + " ";

            }
            else if (integer > 1000) {
                integer = 0;
            }
            sum += integer;
        }
        if (flag == 1) {
            throw new Exception("Negatives not allowed: "+negatives);
        }
        return sum;
    }
}
