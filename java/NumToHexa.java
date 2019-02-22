public class NumToHexa {

    public static void main(String[] args) {

        int num = -1;
        System.out.println(toHex(num));

    }

    public static String toHex(int num) {

        if(num ==0){
            return "0";
        }

        String resul = "";
        //Using binary to Hex sudo code algorithm as it will handle -ve integer as wll.
        //Alternate is to use decimal to hex conversion algo ( Divide by 4 until 0, keep appending remainder)

        //In Binary To Hex Conversion. Each 4 bit of binary represent 1 digit of Hex
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

        //Take 4 bit of binary from right, find equivalent hex digit append in result
        //Repeat for remaining bits

        while (num != 0){
            //Finding 4 bit from right
            int a = num & 0xf;
            //Find equivalent hex digit and append in result
            resul = map[a] + resul;
            //Move to next 4 bit
            num = num >>> 4;
        }



        return resul;
    }
}
