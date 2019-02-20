public static void main(String[] args) {

        String s = "{[]}";

        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty() || stack.pop() != map.get(s.charAt(i))) {
                    return false;
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }

        return false;
    }
