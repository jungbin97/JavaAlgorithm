import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        func(0, N);
    }

    static void func(int depth, int N) {
        String indent = "____".repeat(depth);
        System.out.println(indent+"\"재귀함수가 뭔가요?\"");

        if (depth == N) {
            System.out.println(indent+ "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        } else {
            System.out.println(indent+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(indent+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(indent+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            func(depth+1, N);
        }
        System.out.println(indent+ "라고 답변하였지.");
    }
    
}

// "재귀함수가 뭔가요?"
// "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
// 마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
// 그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."


// (k X ____)"재귀함수가 뭔가요?"
// (k X ____)"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.
// (k X ____)마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.
// (k X ____)그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어."
// (k+1 X ____)"재귀함수가 뭔가요?"
// (k+1 X ____) "재귀함수는 자기 자신을 호출하는 함수라네" => base condtion
// (k+1 X ____) 라고 답변하였지.
// (k X ____) 라고 답변하였지.

// func(k)
// base condition(k+1 == N)