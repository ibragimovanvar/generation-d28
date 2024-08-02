import java.util.HashSet;
import java.util.Set;

public class MainLeeetcode {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
    public static int firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();

        boolean found = false;

        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && i != j){
                    found = true;
                    break;
                }
            }
            if(found != true && !set.contains(s.charAt(i))){
                return i;
            }

            found = false;
            set.add(s.charAt(i));
        }

        return -1;
    }
}
