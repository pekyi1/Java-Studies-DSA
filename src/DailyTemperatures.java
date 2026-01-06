import java.util.Stack;
import java.util.Arrays;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            //check if the stack is empty and if the current temperature value
            //is greater than the temperature value in the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay; //calculate the index by subtracting
                //current index from previous temp index and place it in the new array
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] temps1 = {70, 71, 80, 70, 65, 78};
        System.out.println(Arrays.toString(dailyTemperatures(temps1)));
    }
}
