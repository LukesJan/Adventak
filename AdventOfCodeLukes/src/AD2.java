import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AD2 {
    private int powerFinal = 0;
    private int valid = 0;
    private int power = 0;
    public AD2() {
        loadFile();
    } /**in this constructor we start loadFile()**/
    public int getPowerFinal() {
        return powerFinal;
    }
    public int getValid() {
        return valid;
    }

    public void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("input2.txt"))) {
            Pattern p = Pattern.compile("(\\d+) (\\w+)");
            for (String line : br.lines().toList()) {
                String[] lines = line.split(":");
                int number = Integer.parseInt(lines[0].replace("Game", "").trim());
                int red = 0;
                int blue = 0;
                int green = 0;
                for (String round : lines[1].split(";")) {
                    for (String cubes : round.split(",")) {
                        Matcher m = p.matcher(cubes);
                        if (m.find()) {
                            switch (m.group(2)) {
                                case "red":
                                    int newRed = Integer.parseInt(m.group(1));
                                    if (newRed > red) {
                                        red = newRed;
                                    }
                                    break;
                                case "blue":
                                    int newBlue = Integer.parseInt(m.group(1));
                                    if (newBlue > blue) {
                                        blue = newBlue;
                                    }
                                    break;
                                case "green":
                                    int newGreen = Integer.parseInt(m.group(1));
                                    if (newGreen > green) {
                                        green = newGreen;
                                    }
                                    break;
                            }
                        }
                    }
                }
                if( green <= 13 && blue <= 14 && red <= 12){
                   valid += number;
                }
                power = green * blue * red;
                powerFinal += power;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    } /** in this metod we load data from file then import class Pattern and do regex then thanks to foreach loop we do iteration of lines then two regexs we get numbers a colors only
     then we work with every cube then we use Matcher to for finding value and color and then we find new record value, last if for first part of the challange to validate the game
     when the if applies valid = valid + number, power is egual to multiply of red , green, blue, powerFinal is finalpowe and its egual to powerFinal + power
        **/
}
