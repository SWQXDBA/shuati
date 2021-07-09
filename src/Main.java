class Main {
    public static void main(String[] args) {
        int[] ARR = {200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 199, 198, 197};
        for (int i : ARR) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            });
            thread.start();

        }

    }

}



