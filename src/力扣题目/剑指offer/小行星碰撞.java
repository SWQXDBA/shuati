package 力扣题目.剑指offer;

import java.util.*;

//对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
//
//找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/XagZNi
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class 小行星碰撞 {

    //模拟解法 超时了 没过
    static int removed = 0;
    static boolean destroied;

    public static void main(String[] args) {
        int[] arr = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(arr)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        removed = 0;
        List<List<Integer>> asteroidsList = new ArrayList<>();
        //用于组合答案顺序
        Deque<Integer> resultLeft = new LinkedList<>();
        Deque<Integer> resultRight = new LinkedList<>();
        for (int asteroid : asteroids) {
            asteroidsList.add(new ArrayList<>() {{
                add(asteroid);
            }});
            //增加中间节点 避免正负数互相错过
            asteroidsList.add(new ArrayList<>());
        }
        //取出最后多出来的
        asteroidsList.remove(asteroidsList.size() - 1);
        //移动完不能马上加进去 要缓存一下。
        List<List<Integer>> temp = new ArrayList<>();
        for (int i = 0; i < asteroidsList.size(); i++) {
            temp.add(new ArrayList<>());
        }
        do {
            destroied = false;
            //move
            for (int i = 0; i < asteroidsList.size(); i++) {
                final List<Integer> currentNode = asteroidsList.get(i);

                if (currentNode.isEmpty()) {
                    continue;
                }
                final Integer asteroid = currentNode.remove(0);

                if (i == 0 && asteroid < 0) {
                    resultLeft.addLast(asteroid);
                    continue;
                }
                if (i == asteroidsList.size() - 1 && asteroid > 0) {
                    resultRight.addFirst(asteroid);
                    continue;
                }
                if (asteroid < 0) {
                    temp.get(i - 1).add(asteroid);

                } else {
                    temp.get(i + 1).add(asteroid);
                }

            }
            //把temp中的元素放进来 进行判断
            for (int i = 0; i < asteroidsList.size(); i++) {
                List<Integer> list = asteroidsList.get(i);
                if (!temp.get(i).isEmpty()) {
                    list.addAll(temp.get(i));
                    temp.get(i).clear();

                }
                doDestroy(list);
            }
            //如果未摧毁任何元素 则有可能已经执行完毕了 尝试提前结束
            if (!destroied) {
                boolean done = true;
                int state = 0;//1表示正数 -1表示负数
                for (final List<Integer> currentNode : asteroidsList) {
                    if (currentNode.isEmpty()) {
                        continue;
                    }
                    final Integer asteroid = currentNode.get(0);
                    if (state == 0) {
                        state = asteroid > 0 ? 1 : -1;
                    } else {
                        if (asteroid > 0 && state < 0 || asteroid < 0 && state > 0) {
                            done = false;
                            break;
                        }
                    }
                }
                if (done) {
                    if (state > 0) {
                        for (int i = asteroidsList.size() - 1; i > 0; i--) {
                            final List<Integer> currentNode = asteroidsList.get(i);

                            if (currentNode.isEmpty()) {
                                continue;
                            }
                            final Integer asteroid = currentNode.remove(0);
                            resultRight.addFirst(asteroid);
                        }
                    } else {
                        for (int i = 0; i < asteroidsList.size(); i++) {
                            final List<Integer> currentNode = asteroidsList.get(i);

                            if (currentNode.isEmpty()) {
                                continue;
                            }
                            final Integer asteroid = currentNode.remove(0);
                            resultLeft.addLast(asteroid);
                        }
                    }

                    break;
                }

            }

        } while (removed + resultLeft.size() + resultRight.size() < asteroids.length);

        int[] res = new int[resultLeft.size() + resultRight.size()];

        int index = 0;
        for (Integer integer : resultLeft) {
            res[index++] = integer;
        }
        for (Integer integer : resultRight) {
            res[index++] = integer;
        }
        return res;
    }

    public static void doDestroy(List<Integer> node) {
        if (node.size() < 2) {
            return;
        }
        node.sort(Integer::compare);
        if (node.get(0) < 0 && node.get(1) > 0) {
            destroied = true;
            int res = Math.abs(node.get(0)) > node.get(1) ? node.get(0) : node.get(1);
            if (node.get(0) + node.get(1) == 0) {
                res = 0;
            }
            node.clear();
            if (res != 0) {
                node.add(res);
                removed++;
            } else {
                removed += 2;
            }

        }
    }

}
