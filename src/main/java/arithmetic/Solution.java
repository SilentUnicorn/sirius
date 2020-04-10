package arithmetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public static List<String> generateParenthesis(int n) {
        int flag = 0;
        int countLift = 0;
        int countRight = 0;
        List<String> content = new ArrayList();
        String result = "";
        add(content, countLift, countRight, flag, result, "(", n);
        add(content, countLift, countRight, flag, result, ")", n);
        return content;
    }
    private static void add(List<String> content, int countLift, int countRight,int flag,String result, String s, int n){
        if (n <= 0){
            return;
        }
        if ("(".equals(s)){
            countLift++;
            flag += 1;
        }else{
            countRight++;
            flag -= 1;
            if (flag < 0){
                return;
            }
        }
        result += s;
        if (countLift == n && countRight == n && flag==0){
            content.add(result);
            return;
        }else if (countLift <= n && countRight <= n){
            add(content, countLift, countRight, flag, result, "(", n);
            add(content, countLift, countRight, flag, result, ")", n);
        }else{
            return;
        }

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
