import java.util.*;

class Solution {

    private static char[] cal = {'+', '-', '*'};
    private static char[] temp = new char[3];
    private static boolean[] visit = new boolean[3];
    private static ArrayList<Long> nums = new ArrayList<Long>();
    private static ArrayList<Character> ops = new ArrayList<Character>();
    private static long answer;

    public long solution(String expression) {
        answer = 0;

        String num = "";
        for (int i=0; i<expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                num += expression.charAt(i);
            } else {
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(expression.charAt(i));
            }
        }
        //마지막 숫자
        nums.add(Long.parseLong(num));

        dfs(0);

        return answer;
    }

    public void dfs(int start) {

        if (start == 3) {

            for (int i=0; i<start; i++) {
                System.out.print(temp[i] + " ");
            }
            System.out.println();

            math();

        } else {

            for (int i=0; i<3; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    temp[start] = cal[i];
                    dfs(start+1);
                    visit[i] = false;
                }
            }

        }

    }

    public void math() {
        // 원본 ArrayList 를 복사해준다.
        ArrayList<Long> copyNums = new ArrayList<>(nums);
        ArrayList<Character> copyOps = new ArrayList<Character>(ops);

        for (int i=0; i<temp.length; i++) {
            for (int j=0; j<copyOps.size(); j++) {
                if (temp[i] == copyOps.get(j)) {
                    Long res = calc(copyNums.remove(j), copyNums.remove(j), temp[i]);
                    copyNums.add(j, res);
                    copyOps.remove(j);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(copyNums.get(0)));

    }

    public static Long calc(Long num1, Long num2, char op) {
        long num = 0;
        switch (op) {
            case '+': {
                return num1 + num2;
            }
            case '-': {
                return num1 - num2;
            }
            case '*': {
                return num1 * num2;
            }
        }
        return num;
    }

}
