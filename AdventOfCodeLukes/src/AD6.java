import java.math.BigInteger;

public class AD6 {
    private int value;
    private long valueRecord;

    public AD6() {
        calculateRecords();
    } /**in that constructor we start calculateRecords**/
    public int getValue() {
        return value;
    }
    public long getValueRecord() {
        return valueRecord;
    }
    public void calculateRecords() {
            valueRecord = 0;
            value = numberTimesBeat(54, 446);
            value *= numberTimesBeat(81, 1292);
            value *= numberTimesBeat(70, 1035);
            value *= numberTimesBeat(88, 1007);
            valueRecord = numberTimesBeatBig(54817088, new BigInteger("446129210351007"));
    } /**in this metod above we have the input for the exercise**/

    public static int numberTimesBeat(int time, int record) {
        int w = 0;
        for (int i = 0; i < time; i++) {
            int timeRemain = time - i;
            if (i * timeRemain > record) {
                w++;
            }
        }
        return w;
    }/**this metod is givin us the number of timess to beat
     @rerurn w is output**/
    public static long numberTimesBeatBig(int time, BigInteger record) {
        long wBig = 0;
        for (int i = 0; i < time; i++) {
            BigInteger timeRemainB = BigInteger.valueOf(time - i);
            if (timeRemainB.multiply(BigInteger.valueOf(i)).compareTo(record) > 0) {
                wBig++;
            }
        }
        return wBig;
    } /**
     metod above is doing how many ways we can beat the record in this time
     we need to create big integers because the number is to big for int and long
     @return wBig is output
     **/
}
