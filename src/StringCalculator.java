/**
 * Created by juhi on 07/08/21.
 */
public class StringCalculator {

    public int Add(String numbers) throws Exception{

        String regex = "";

        if (numbers.length() > 0) {

            //Delimiter specified by user -> Regex modified accordingly [\\W]
            if (numbers.length() >= 2 && numbers.charAt(0) == '/' && numbers.charAt(1) == '/') {

                //Delimiter list ends with "\n"
                String[] splitNumbers = numbers.split("\\n",2);

                String[] multipleDelimiters = splitNumbers[0].substring(2, splitNumbers[0].length()).split("\\[|\\]");
                for (String a : multipleDelimiters) {

                    //Formatting regex in [//W] form
                    if (!a.isEmpty()) {
                        regex += "[\\"+a+"]|";
                    }

                }
                try {
                    regex = regex.substring(0, regex.length() - 1);
                }
                catch (Exception e) {
                    throw new Exception("Delimiter not specified after double slash");
                }
                return computeSum(splitNumbers[1], regex);

            }
            //Default delimiter is "," and "\n"
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

            //Empty string
            if(a.isEmpty()){
                continue;
            }
            try {
                integer = Integer.parseInt(a.trim());

            }
            //Integer cannot be parsed since Invalid Delimiter
            catch (Exception e) {
                throw new Exception("Invalid Input");
            }

            //Negative Integers
            if (integer < 0) {

                flag = 1;
                negatives += integer + " ";

            }
            //number greater than 1000 should be ignored
            else if (integer > 1000) {
                integer = 0;
            }
            sum += integer;
        }
        //If negative Integer, throw exception
        if (flag == 1) {
            throw new Exception("Negatives not allowed: "+negatives);
        }
        return sum;
    }
}
