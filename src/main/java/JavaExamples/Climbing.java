package JavaExamples;


public class Climbing {


    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

//            int sum = 0;
//            int count = 0;
//            for(int i=0;i<n;i++){
//
//                char[] s1 = s.toCharArray();
//
//                if(s1[i]=='U'){
//                    if(++sum==0)
//                        count++;
//                    {System.out.println("U sum " +sum + "count " + count);}
//                }
//                else {sum--;
//                {                System.out.println("D sum  " +sum + "count " + count);}}
//
//            }
//            System.out.println(count);
//            return count;
        int v = 0;     // # of valleys
        int lvl = 0;   // current level
        for (char c : s.toCharArray()) {
            if (c == 'U') ++lvl;
            {
                System.out.println("U " + lvl);
            }
            if (c == 'D') --lvl;
            {
                System.out.println("D " + lvl);
            }

            // if we just came UP to sea level
            if (lvl == 0 && c == 'U')
                ++v;
            {
                System.out.println(v);
            }
        }
        System.out.print(v);
        return (v);
    }

    public static void main(String[] args) {
        int n = 10;
        String s = "UDDDUDUUDU ";

        int result = countingValleys(n, s);

    }
}
