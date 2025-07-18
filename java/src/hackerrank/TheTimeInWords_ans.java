package hackerrank;

public class TheTimeInWords_ans {
    public static void main(String[] args) {

    }

    public static String ones[] = {"", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN","EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN","quarter", "SIXTEEN","SEVENTEEN", "EIGHTEEN", "NINETEEN"};
    public static String clock = " o' clock";
    public static String twenty  = "twenty ";
    public static String thirty = "half";
    public static String past = " past ";
    public static String to = " to ";
    // Complete the timeInWords function below.

    static String timeInWords(int h, int m) {
        if(m == 0) return ones[h].toLowerCase()+clock;
        if(m == 15) return ones[m].toLowerCase() +past+ ones[h].toLowerCase();
        if(m == 45) return ones[15].toLowerCase() +to+ ones[h+1].toLowerCase();
        if(m == 30) return thirty+ past +ones[h].toLowerCase();
        else return getMinutes(m, h);
    }

    static String getHours(int h){
        return ones[h].toLowerCase();
    }
    static String getMinutes(int m, int h){
        if(m > 30){
            if(m > 40){
                return ones[60-m].toLowerCase()+ " minutes"+ to + getHours(h+1);
            }else{
                return twenty + ones[(60-m)%20].toLowerCase() + " minutes"+ to + getHours(h+1);
            }
        }
        if(m < 30){
            if(m <= 19){
                if(m ==1) return ones[m].toLowerCase() + " minute"+ past+ getHours(h);
                else return ones[m].toLowerCase() + " minutes"+ past+ getHours(h);
            }else{
                return twenty+ones[m%20].toLowerCase() + " minutes"+ past+ getHours(h);
            }
        }
        return "";
    }

}
