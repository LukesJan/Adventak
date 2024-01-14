public class Main {
        public static void main(String[] args) {
                AD1 ad1 = new AD1();
                System.out.println("Summary of all the calibrations values is: " + ad1.getValueFirst() + " (only digits)");
                System.out.println("Summary of all the calibrations of all the values is: " + ad1.getFinalValue());
                AD2 ad2 = new AD2();
                System.out.println("The summary of IDs of the games is: "+ ad2.getValid() + " if there is only 12 red cubes, 13 green cubes, and 14 blue cubes");
                System.out.println("The summary of the power in these sets is: " +ad2.getPowerFinal());
                AD6 ad6 = new AD6();
                System.out.println("Number you get if you multiply these numbers: " + ad6.getValue());
                System.out.println("You can broke the record in: " + ad6.getValueRecord());

        }

    }

