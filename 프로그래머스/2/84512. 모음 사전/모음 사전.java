import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static String[] charArr = new String[] {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        int answer = 0;
        
        
        dfs("", 0);
        
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(word)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public static void dfs(String str, int index) {
        list.add(str);
        // 탈출 조건
        if (index == 5) {
            return;
        }
        
        for (int i = 0; i < charArr.length; i++) {
            dfs(str+charArr[i], index+1);
        }
    }
}


// A -> AA ... -> UUUUU 사전순 단어 수록
// 몇번째 순서인가?


// AAAAE
// A -> AA -> AAA -> AAAA -> AAAAA -> AAAAE = 6번째


// AAAE
// AAAAE -> AAAAI -> AAAAO -> AAAAU -> AAAE = 10번째


// dfs로 순서대로 생성