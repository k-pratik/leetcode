import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "pwwkew";

        final char[] strArray = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0; i<strArray.length;i++){
            if(map.containsKey(strArray[i])){
                i=map.get(strArray[i]);
                res=Math.max(res,map.size());
                map=new HashMap<>();
            }else{
                map.put(strArray[i],i);
            }
        }

        System.out.println(Math.max(res,map.size()));
    }
}
