import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class AD1 {
    private String line = "";
    private int firstD = 0;
    private int lastD = 0;
    private int firstDigit = 0;
    private int lastDigit = 0;
    private String connectNumbers = "";
    private int value = 0;
    private int valueFirst = 0;
    private int finalValue = 0;
    private Map<String, String> numbers = new HashMap<>();
    public AD1() {
        this.numbers.put("one", "one1one");
        this.numbers.put("two", "two2two");
        this.numbers.put("three", "three3three");
        this.numbers.put("four", "four4four");
        this.numbers.put("five", "five5five");
        this.numbers.put("six", "six6six");
        this.numbers.put("seven", "seven7seven");
        this.numbers.put("eight", "eight8eight");
        this.numbers.put("nine", "nine9nine");
        loadFile();
        } /** in this constructor we put informations to hashmap and start loadFile()**/

    public void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("input1.txt"))) {
            while ((line = br.readLine()) != null) {
                digit();
                textDigit();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } /** in this metod we load data from file and we read lines here and start digit() and textDigit() **/
    public int getFinalValue() {
        return finalValue;
    }
    public int getValueFirst() {
        return valueFirst;
    }
    private void digit() {
         firstD = -1;
         lastD = -1;
        for (String oC : line.split("")) {
            if (Character.isDigit(oC.charAt(0))) {
                if (firstD == -1) {
                    firstD = Integer.parseInt(oC);
                }
                lastD = Integer.parseInt(oC);
            }
        }
        firstD *= 10;
        valueFirst += firstD + lastD;
    } /** in this metod I split lines and then search for a first and last number then we multiply firtsD by 10 and then to valueFirst will be valueFirst = valueFirst + (firstD + lastD) **/

    private void textDigit() {
        for (Map.Entry<String, String> entry : numbers.entrySet()) {
            line = line.replace(entry.getKey(), entry.getValue());
        }
        for (int c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                firstDigit = Character.getNumericValue(c);
                break;
            }
        }
        for (int index = line.length()-1; index >= 0; index--) {
            int c = line.charAt(index);
            if (Character.isDigit(c)) {
                lastDigit = Character.getNumericValue(c);
                break;
            }
        }
        connectNumbers = firstDigit + "" + lastDigit;
        value = Integer.parseInt(connectNumbers);
        finalValue += value;
    }/**in metod above we transform line, then we find firstDigit in second for loop and lastDigit in the third loop and connectNumbers after connecting we parse connect numbers
     to int a then we do finalValue = finalValue + value**/
}
