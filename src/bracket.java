import java.util.*;
import java.util.stream.Collectors;

public class bracket {
    public static boolean balancedBrackets(String str) {
        // TODO:
        // 스택 peek 0,1번 가득 차있으면 유효성 검사
        // 안차있으면
        // 1. 여는 괄호인 경우 stack에 push
        // 2. 닫는 괄호인 경우 stack.peek() 해서 1번자리에 삽입
        // 해서 queue 엘리먼트 head면 0번에 tail이면 1번에 넣고
        // pop 했다가 다시 push
        String[] strSpl = str.split("");
        Queue<String> queue = new LinkedList<>(Arrays.asList(strSpl));
        Stack<int[]> stack = new Stack<>();
        String[] headsArr = {" ","(","{","["};
        String[] tailsArr = {" ",")","}","]"};
        List<String> heads = new ArrayList<>(Arrays.asList(headsArr)); // 소 중 대 순으로 1 2 3 되도록
        List<String> tails = new ArrayList<>(Arrays.asList(tailsArr));

        while( queue.size() > 0 ) {


            System.out.println(queue.toString());
            String currEle = queue.poll();

            if (heads.contains(currEle)) {
                 int[] newQue = {heads.indexOf(currEle),0};
                stack.add(newQue);
            }
            else if (tails.contains(currEle) && stack.size() > 0) {
                int[] lastStackEle = stack.pop();
                lastStackEle[1] = tails.indexOf(currEle);
                stack.push(lastStackEle);
            }
            else return false;
            int[] stackEle = stack.pop();
            if (stackEle[1] - stackEle[0] != 0) {
                stack.push(stackEle);
            }
            for (int i = 0; i < stack.size(); i++) System.out.print(Arrays.toString(stack.get(i)) + ", ");
            System.out.println(" ");
        }
        return stack.size() == 0;

    }


    public static void main(String[] args) {
        System.out.println(balancedBrackets("[[[{{{((()))}}}]]]"));


    }
}
