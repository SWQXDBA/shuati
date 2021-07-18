package MyTools.我的数据结构;

import java.util.*;

public class MySort {
    private static <T> void swap(T[] arr, int i1, int i2) {
        T tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static <T> void insertSort(T[] array, Comparator<T> c) {
        insertSortHelper(array, c, 1);
    }

    private static <T> void insertSortHelper(T[] array, Comparator<T> c, int gap) {
        for (int i = 1; i < array.length; i++) {//i:有序和无序部分的界限 这里不是i+=gap的原因是需要遍历整个数组
            T val = array[i];
            int index = i - gap;
            for (; index >= 0 && c.compare(array[index], val) > 0; index -= gap) {//搬移元素
                //不写==是为了稳定性
                array[index + gap] = array[index];//搬运 把比要插入的元素val"大"的往后搬运
            }
            array[index + gap] = val;//插入
        }
    }

    public static <T> void selectSort(T[] array, Comparator<T> c) {
        for (int i = 0; i < array.length; i++) {//刚开始整个数组都是"未排序的" 所以从i=0开始
            int max = i;
            //选出最"大"元素的下标
            for (int j = i; j < array.length; j++) {
                if (c.compare(array[max], array[j]) > 0) {
                    max = j;
                }
            }
            T maxT = array[max];
            //搬运元素
            for (int j = max - 1; j >= i; j--) {
                array[j + 1] = array[j];
            }
            //插入元素
            array[i] = maxT;
        }
    }

    //堆排序会把最"小"的元素插入最后的有序部分，所以最终结果和堆的poll顺序相反。大的会先出来
    public static <T> void heapSort(T[] array, Comparator<T> c) {
        createHeap(array, c);
        int index = array.length - 1;//已经有序的数据范围(index,array.length]
        while (index >= 0) {
            swap(array, 0, index);
            index--;
            shiftDown(array, index, 0, c);
        }
    }

    private static <T> void shiftDown(T[] arr, int length, int parent, Comparator<T> c) {
        int child = parent * 2 + 1;
        while (child <= length) {//length位置本身处在无序的范围中
            if (child + 1 <= length && c.compare(arr[child], arr[child + 1]) < 0) {
                child++;
            }
            if (c.compare(arr[parent], arr[child]) < 0) {
                swap(arr, child, parent);
            } else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }
//堆排序没有往数组中进行插入新元素的操作 不需要向上调整

    private static <T> void createHeap(T[] arr, Comparator<T> c) {
        for (int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, arr.length - 1, i, c);
        }
    }

    public static <T> void shellSort(T[] array, Comparator<T> c) {
        int gap = array.length / 2;
        while (gap > 1) {
            insertSortHelper(array, c, gap);
            gap /= 2;
        }
        insertSortHelper(array, c, 1);
    }

    static <T> boolean test(Sorter sorter) {
        Long time = System.currentTimeMillis();
        for (int k = 0; k < 10; k++) {
            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 30000; i++) {
                list.add(random.nextInt() % 10000);
            }
            Integer[] arr = list.toArray(new Integer[0]);
            sorter.sort(arr, Integer::compare);
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] - arr[i] < 0) {
                    System.out.println(arr[i] + "error" + arr[i + 1]);
                    System.out.println(Arrays.toString(arr));
                    return false;
                }
            }
        }
        System.out.println("sort over,used " + (System.currentTimeMillis() - time) + "mills");
        return true;

    }

    public static void main(String[] args) {
        System.out.println("selectSort::");
        System.out.println(test(MySort::selectSort));
        System.out.println("heapSort::");
        System.out.println(test(MySort::heapSort));
        System.out.println("insertSort::");
        System.out.println(test(MySort::insertSort));
        System.out.println("shellSort::");
        System.out.println(test(MySort::shellSort));
        System.out.println("ArraysSort::");
        System.out.println(test(Arrays::sort));
        System.out.println("ArraysParallelSort::");
        System.out.println(test(Arrays::parallelSort));
    }

    private interface Sorter {
        <T> void sort(T[] arr, Comparator<T> c);
    }
}
