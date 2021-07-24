package 作业.暑假21年;

import java.util.Arrays;

public class 车队 {
    static public int carFleet(int target, int[] position, int[] speed) {
        Car[] cars = new Car[position.length];
        Car.setTarget(target);
        for (int i = 0; i < position.length; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (o1, o2) -> o2.position - o1.position);
        int cnt = 1, i = 0;
        while (++i < cars.length) {//++i使得对比的是进入循环体的i的数值
            if (cars[i].time > cars[i - 1].time) {//两辆车不能同时抵达 车队+1
                cnt++;
            } else {
                cars[i].time = cars[i - 1].time;//让后一部车的抵达时间和前一辆车的抵达时间相同 组成一个车队
            }
        }
        return position.length == 0 ? 0 : cnt;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        System.out.println(carFleet(target, position, speed));

    }

    static class Car {
        static int target;
        int position;
        int speed;
        float time;

        public Car(int position, int speed) {
            this.position = position;
            this.speed = speed;
            time = (target - position) * 1.0f / speed;
        }

        static void setTarget(int t) {
            target = t;
        }

    }
}
