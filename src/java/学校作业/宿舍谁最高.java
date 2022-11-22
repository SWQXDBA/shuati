package 学校作业;

import java.util.*;

public class 宿舍谁最高 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s;//为了提交
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Set<Family> families = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int susheNum = scanner.nextInt();
                String name = scanner.next();
                int h = scanner.nextInt();
                int wei = scanner.nextInt();
                Stu stu = new Stu(name, h, wei);
                Family family = new Family();
                family.num = susheNum;
                if (!families.contains(family)) {
                    family.stus.add(stu);
                    families.add(family);
                } else {
                    for (Iterator<Family> it = families.iterator(); it.hasNext(); ) {
                        Family f = (Family) it.next();
                        if (f.num == susheNum)
                            f.stus.add(stu);
                    }
                }

            }

            Family[] fs = new Family[families.size()];
            int i = 0;
            for (Family x : families) {
                fs[i] = x;
                i++;
            }
            Arrays.sort(fs);
            for (Family x : fs) {
                if (x.getMax() != null) {
                    Stu stu = x.getMax();
                    System.out.printf("%06d %s %d %d\n", x.num, stu.name, stu.height, stu.weifht);
                }
            }


        }
    }

    static class Family implements Comparable<Family> {
        public int num;
        public List<Stu> stus = new ArrayList<>();

        public Stu getMax() {
            int max = 0;
            Stu maxt = null;
            for (Stu stu : stus) {
                if (stu.getHeight() >= max) {
                    maxt = stu;
                    max = stu.getHeight();
                }

            }
            return maxt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Family)) return false;
            Family family = (Family) o;
            return num == family.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }

        @Override
        public int compareTo(Family o) {
            return this.num - o.num;
        }
    }

    static class Stu implements Comparable<Stu> {
        String name;
        int height;
        int weifht;

        public Stu(String name, int height, int weifht) {
            this.name = name;
            this.height = height;
            this.weifht = weifht;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWeifht() {
            return weifht;
        }

        public void setWeifht(int weifht) {
            this.weifht = weifht;
        }

        @Override
        public int compareTo(Stu o) {
            return this.height - o.getHeight();
        }
    }
}
