public class PowerOfThree {

    public static void main(String[] args) {
        int n = 15;
        System.out.println(powerOfThree(n));
        
        //Max value of three power
        int maxThree = 1162261467;
        System.out.println(maxThree % n == 0);
    }

    public static boolean powerOfThree(int n){
        if(n==0){
            return false;
        }

        while(n%3 == 0){
            n=n/3;
        }

        if(n==1){
            return true;
        }

        return false;
    }
}
