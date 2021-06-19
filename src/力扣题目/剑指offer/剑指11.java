package 力扣题目.剑指offer;

public class 剑指11 {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] < numbers[i])
                return numbers[i + 1];
        }
        return numbers[0];
    }


}
