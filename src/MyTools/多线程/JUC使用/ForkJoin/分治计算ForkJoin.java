package MyTools.多线程.JUC使用.ForkJoin;

import MyTools.工具类.RandomTool;
import MyTools.工具类.Sleeper;
import MyTools.我的数据结构.MySort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class 分治计算ForkJoin {
    public static void main(String[] args) {
        Integer[] array = RandomTool.generateRandomArray(i -> Math.abs(i % 10), 10000000, Integer[].class);
        Integer[] array2 = Arrays.copyOf(array, array.length);
        Integer[] array3 = Arrays.copyOf(array, array.length);
        {
            long startTime, endTime;
            startTime = System.currentTimeMillis();
            Arrays.parallelSort(array2);
            endTime = System.currentTimeMillis();
            System.out.println("并行排序用了" + (endTime - startTime));
        }

        Sleeper.sleep(1000);
        {
            long startTime, endTime;
            startTime = System.currentTimeMillis();
            ForkJoinPool pool = new ForkJoinPool(6);
            Task task = new Task(array, 0, array.length);
            //execute不会阻塞等待结果 需要手动task.join

//            pool.execute(task);
            // invoke方法内部调用了 task.join
//            task.join();
            pool.invoke(task);
            endTime = System.currentTimeMillis();
            System.out.println("Fork线程池归并排序用了" + (endTime - startTime));
        }
        Sleeper.sleep(1000);
        {
            long startTime, endTime;
            startTime = System.currentTimeMillis();
            MySort.mergeSort(array3, Integer::compare);
            endTime = System.currentTimeMillis();
            System.out.println("单线程归并排序用了" + (endTime - startTime));
        }


    }

    static class Task extends RecursiveAction {
        Integer[] array;
        int left;
        int right;

        public Task(Integer[] array, int left, int right) {
            this.array = array;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (right - left <= 1) {
                return;
            }
            int mid = (left + right) / 2;
            Task t1 = new Task(array, left, mid);

            Task t2 = new Task(array, mid, right);

            t1.fork();
            t2.fork();
            t1.join();
            t2.join();
            merge(left, mid, right);
        }

        private void merge(int left, int mid, int right) {
            int capacity = right - left;
            Integer[] temp = new Integer[capacity];
            int pleft = left;
            int pright = mid;
            int index = 0;
            while (pleft < mid && pright < right) {
                while (pleft < mid && pright < right && array[pleft] <= array[pright]) {
                    temp[index++] = array[pleft++];
                }
                while (pleft < mid && pright < right && array[pleft] > array[pright]) {
                    temp[index++] = array[pright++];
                }
            }
            while (pleft < mid) {
                temp[index++] = array[pleft++];
            }
            while (pright < right) {
                temp[index++] = array[pright++];
            }
            for (int i = 0; i < capacity; i++) {
                array[left + i] = temp[i];
            }
//            if (capacity >= 0) System.arraycopy(temp, 0, array, left, capacity);
        }
    }
}
