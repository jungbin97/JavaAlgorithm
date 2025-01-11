import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> phoneSet = new HashSet<>();
        
       	for (String str : phone_book) {
            phoneSet.add(str);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (phoneSet.contains(phone_book[i].substring(0, j))) {
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }
}