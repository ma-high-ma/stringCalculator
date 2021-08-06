/**
 * Created by juhi on 07/08/21.
 */
public class StringCalculator {

    public int Add(String numbers) {

        if (numbers.length() > 0) {

            String[] splitNumbers = numbers.split(",|\\n");
            int sum = 0;
            for (String a : splitNumbers) {
                sum += Integer.parseInt(a.trim());
            }
            return sum;
        }

        return 0;
    }
}
