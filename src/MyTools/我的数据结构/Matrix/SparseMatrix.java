package MyTools.我的数据结构.Matrix;

public class SparseMatrix<T> {
    int capacity = 100;
    int size = 0;
    int rowMax = 0;
    int colMax = 0;
    Object[] list = new Object[capacity];

    public SparseMatrix(int capacity) {
        this.capacity = capacity;
    }

    public SparseMatrix() {
    }

    public static void main(String[] args) {
        SparseMatrix<Integer> matrix = new SparseMatrix<>();
        matrix.add(1, 2, 12);
        matrix.add(1, 3, 9);
        matrix.add(3, 1, -3);
        matrix.add(3, 6, 14);
        matrix.add(4, 3, 24);
        matrix.add(5, 2, 18);
        matrix.add(5, 1, 15);
        matrix.add(6, 5, -7);
        System.out.println(matrix);
        System.out.println("------------------");
        matrix.transposition();
        System.out.println(matrix);

    }

    public void add(int row, int col, T value) {
        if (row >= rowMax) {
            rowMax = row;
        }
        if (col >= colMax) {
            colMax = col;
        }
        list[size++] = new Unit<T>(row, col, value);

    }

    public void transposition() {
        int[] num = new int[colMax];
        int[] start = new int[colMax];
        for (int i = 0; i < size; i++) {
            Unit<T> tUnit = (Unit<T>) list[i];
            num[tUnit.col - 1]++;
        }
        start[0] = 0;
        for (int i = 1; i < colMax; i++) {
            start[i] = start[i - 1] + num[i - 1];
        }
        Object[] newList = new Object[capacity];
        for (int i = 0; i < size; i++) {
            Unit<T> tUnit = (Unit<T>) list[i];
            tUnit.transposition();
            //这里的row就是原来的col
            newList[start[tUnit.row - 1]++] = tUnit;
        }
        list = newList;

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Unit<T> tUnit = (Unit<T>) list[i];
            builder.append(tUnit.row).append(" ").append(tUnit.col).append(" ").append(tUnit.value);
            builder.append("\n");
        }


        return builder.toString();
    }

    static class Unit<T> implements Comparable<Unit<T>> {
        public int col;
        public int row;
        public T value;

        public Unit(int row, int col, T value) {
            this.col = col;
            this.row = row;
            this.value = value;
        }

        public void transposition() {
            int t = col;
            col = row;
            row = t;
        }


        @Override
        public int compareTo(Unit<T> o) {
            if (row == o.row) {
                return col - o.col;
            }
            return this.row - o.row;
        }
    }


}
