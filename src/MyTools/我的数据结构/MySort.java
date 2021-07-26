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

    public static <T> void countingSort(T[] tarray, Comparator<T> c) {
        if (tarray.length == 0) {
            return;
        }
        if (!(tarray instanceof Integer[])) {
            System.out.println("计数排序只用于整数");
            return;
        }
        Integer[] array = (Integer[]) tarray;
        Integer max = array[0];
        Integer min = array[0];
        //找出最大和最小的元素 以他们的差值作为数组范围
        for (Integer i : array) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        int capacity = max - min + 1;
        int[] tmp = new int[capacity];
        //计数
        for (Integer i : array) {
            tmp[i - min]++;
        }
        int index = 0;
        for (int i = 0; i < capacity; i++) {
            if (tmp[i] != 0) {
                for (int j = 0; j < tmp[i]; j++) {
                    array[index++] = i;
                }
            }
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
            swap(array, i, max);
        }
    }

    public static <T> void bubbleSort(T[] array, Comparator<T> c) {
        boolean flag = true;
        for (int i = array.length - 1; i >= 0; i--, flag = true) {
            for (int j = 0; j < i; j++) {
                if (c.compare(array[j], array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                    flag = false;
                }
            }
            //如果这一次遍历都没有出现过交换，则认为已经是有序的了，结束排序
            if (flag) {
                return;
            }
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

    public static <T> void quickSort(T[] array, Comparator<T> c) {
        partition(array, 0, array.length - 1, c);
    }

    public static <T> void partition(T[] array, int left, int right, Comparator<T> c) {
        if (left >= right)//终止条件：排序区间为0
            return;
        T base = array[left];//选择基准值
        int i = left, j = right;
        while (i < j) {
            //找到一个比基准值小的元素
            while (i < j && c.compare(array[j], base) >= 0) {
                j--;
            }
            //找到一个比基准值大的元素
            while (i < j && c.compare(array[i], base) <= 0) {
                i++;
            }
            //互相交换，让小的在前，大的在后面
            swap(array, i, j);//当结束的时候，由于是右边的指针j先走，因此会停留在一个小于基准值的元素上(最后一步把j移动到i上)，此时i和j重叠，交换自己也没有关系
        }
        //然后把这个比基准值小的停留元素和基准值交换，(基准值在left，因此这个停留的值会被交换到最左边，符合小于基准值的要求)
        swap(array, left, i);
        partition(array, left, i - 1, c);
        partition(array, i + 1, right, c);

    }

    static <T> void mergeSort(T[] array, Comparator<T> c) {
        merge(array, 0, array.length / 2, array.length, c);
    }

    @SuppressWarnings("unchecked")
    static <T> void merge(T[] array, int left, int mid, int right, Comparator<T> c) {
        if (mid - left >= 1) {
            merge(array, left, (left + mid) / 2, mid, c);
            merge(array, mid, (right + mid) / 2, right, c);
        }
        int length = right - left;
        Object[] tmp = new Object[length];
        int i = left, j = mid;
        int index = 0;
        while (i < mid && j < right) {
            if (c.compare(array[j], array[i]) > 0) {
                tmp[index++] = array[i++];
            } else {
                tmp[index++] = array[j++];
            }
        }
        while (i < mid) {
            tmp[index++] = array[i++];
        }
        while (j < right) {
            tmp[index++] = array[j++];
        }
        for (i = left; i < right; i++) {
            array[i] = (T) tmp[i - left];
        }
    }

    static private <T> boolean testSorter(Sorter sorter, int digit, int dataCounts) {
        for (int k = 0; k < digit; k++) {
            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            //(1<<13)是并行排序启动的界限
            for (int i = 0; i < dataCounts; i++) {
                list.add(random.nextInt() % 100000);
            }
            Integer[] arr = list.toArray(new Integer[0]);
            sorter.sort(arr, Integer::compare);
//进行排序算法正确性的验证
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i + 1] - arr[i] < 0) {
                    System.out.println(arr[i] + "error" + arr[i + 1]);
                    System.out.println(Arrays.toString(arr));
                    return false;
                }
            }
            ///////////////////////////////////////////////
        }
        return true;
    }

    static public <T> void testTime(Sorter sorter, int digit, int dataCounts) {
        long start = System.currentTimeMillis();
        for (int k = 0; k < digit; k++) {
            Random random = new Random();
            List<Integer> list = new ArrayList<>();
            //(1<<13)是并行排序启动的界限
            for (int i = 0; i < dataCounts; i++) {
                list.add(random.nextInt() % 10000000);
            }
            Integer[] arr = list.toArray(new Integer[0]);
            sorter.sort(arr, Integer::compare);

            ///////////////////////////////////////////////
        }
        System.out.println((System.currentTimeMillis() - start) + "mills");


    }

    //测试排序算法的正确性
    public static boolean testSort(Sorter sorter) {
        return testSorter(sorter, 100, 100);
    }

    private static void compareSorts(int digit, int dataCounts) {
        //选择和插入和冒泡在数据量大的时候较慢 测试的时候可以注释掉
        System.out.print("insertSort::");
        testTime(MySort::insertSort, digit, dataCounts);
        System.out.print("selectSort::");
        testTime(MySort::selectSort, digit, dataCounts);
        System.out.print("bubbleSort::");
        testTime(MySort::bubbleSort, digit, dataCounts);

        //   堆排序和希尔排序在数据量极大的时候较慢 测试的时候可以注释掉
        System.out.print("heapSort::");
        testTime(MySort::heapSort, digit, dataCounts);
        System.out.print("shellSort::");
        testTime(MySort::shellSort, digit, dataCounts);

        System.out.print("mergeSort::");
        testTime(MySort::mergeSort, digit, dataCounts);

        System.out.print("quickSort::");
        testTime(MySort::quickSort, digit, dataCounts);
        System.out.print("ArraysSort::");
        testTime(Arrays::sort, digit, dataCounts);
        System.out.print("ArraysParallelSort::");
        testTime(Arrays::parallelSort, digit, dataCounts);
    }

    private static void unCompareSorts(int digit, int dataCounts) {
        System.out.print("countingSort::");
        testTime(MySort::countingSort, digit, dataCounts);
    }

    private static void largeDataSorts(int digit, int dataCounts) {
        System.out.print("countingSort::");
        testTime(MySort::countingSort, digit, dataCounts);
        //   堆排序和希尔排序在数据量极大的时候较慢 测试的时候可以注释掉
        System.out.print("heapSort::");
        testTime(MySort::heapSort, digit, dataCounts);
        System.out.print("shellSort::");
        testTime(MySort::shellSort, digit, dataCounts);


        System.out.print("mergeSort::");
        testTime(MySort::mergeSort, digit, dataCounts);

        System.out.print("quickSort::");
        testTime(MySort::quickSort, digit, dataCounts);
        System.out.print("ArraysSort::");
        testTime(Arrays::sort, digit, dataCounts);
        System.out.print("ArraysParallelSort::");
        testTime(Arrays::parallelSort, digit, dataCounts);
    }

    private static void millionsDataSorts(int digit, int dataCounts) {
        System.out.print("countingSort::");
        testTime(MySort::countingSort, digit, dataCounts);
        System.out.print("quickSort::");
        testTime(MySort::quickSort, digit, dataCounts);
        System.out.print("ArraysSort::");
        testTime(Arrays::sort, digit, dataCounts);
        System.out.print("ArraysParallelSort::");
        testTime(Arrays::parallelSort, digit, dataCounts);
    }

    public static void runTest(SortWay way, int digit, int dataCounts) {

        if (way == SortWay.all) {//启用全部排序
            unCompareSorts(digit, dataCounts);
            compareSorts(digit, dataCounts);
        } else if (way == SortWay.compareSorts) {//启用所有比较排序
            compareSorts(digit, dataCounts);
        } else if (way == SortWay.unCompareSorts) {//启用所有非比较排序
            unCompareSorts(digit, dataCounts);
        } else if (way == SortWay.smallDataSorts) {//启用所有排序
            unCompareSorts(digit, dataCounts);
            compareSorts(digit, dataCounts);
        } else if (way == SortWay.largeDataSorts) {//取消选择和插入和冒泡排序
            largeDataSorts(digit, dataCounts);
        } else if (way == SortWay.millionsDataSorts) {//取消选择和插入和冒泡和堆排序和希尔排序
            millionsDataSorts(digit, dataCounts);
        }
    }



    public enum SortWay {
        all,
        compareSorts,
        unCompareSorts,
        smallDataSorts,
        largeDataSorts,
        millionsDataSorts
    }

    public interface Sorter {
        <T> void sort(T[] arr, Comparator<T> c);
    }
}
