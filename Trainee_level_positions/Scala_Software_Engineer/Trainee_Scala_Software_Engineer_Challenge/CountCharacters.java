import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 18.12.18.
 */
public class CountCharacters {

    public static void main(String[] args) {
        new CountCharacters().countCharacters("Hello- World!");
    }

    private void countCharacters(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.replaceAll("[^A-z]", "").toCharArray()){
            map.merge(Character.toLowerCase(c),1,Integer::sum);
        }
        System.out.println(map);
    }
}
