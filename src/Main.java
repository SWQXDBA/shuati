class test {
    public static void main(String[] args) {
        long num = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            num++;
            //    System.out.println();
        }
        long end = System.currentTimeMillis();
        long time1 = end - start;
        System.out.println(time1);

    }
     
}


