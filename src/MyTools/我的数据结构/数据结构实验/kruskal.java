package MyTools.我的数据结构.数据结构实验;

import java.util.ArrayList;
import java.util.List;

/**
 * 示例邻接矩阵
 * 1-A 2-B 3-C 4-D
 * <p>
 * 1  2   3  4
 * 1   0  1   2  3
 * 2   1  0   4  6
 * 3   2  4   0  5
 * 4   3  6   5  0
 * <p>
 * 步骤
 * 1、创建临接矩阵
 * 2、邻接矩阵转顶点数组
 * 3、按照权值排序顶点数组
 * 4、获取最小生成树
 */

public class kruskal {

    /**
     * 构造
     */
    public kruskal() {

        int cost[][] = {{0, 1, 2, 3},
                {1, 0, 4, 6},
                {2, 4, 0, 5},
                {3, 6, 5, 0}};
        edge e[] = Kuruskal(sort(CreatEdge(cost)), cost.length);
    }

    /**
     * 核心算法：构造最小生成树
     *
     * @param e 顶点类数组
     * @param n 顶点数
     * @return 返回最小生成树顶点数组
     */
    public edge[] Kuruskal(edge[] e, int n) {
        List<edge> edgeList = new ArrayList();
        for (int i = 0; i < e.length; i++) {
            edge e_tmp = e[i];
            if (!Sround(e_tmp, edgeList))
                edgeList.add(e_tmp);
            if (edgeList.size() == n - 1)//最小生成树完成
                break;
        }
        edge result[] = new edge[n - 1];//列表转数组
        for (int i = 0; i < n - 1; i++)
            result[i] = edgeList.get(i);
        return result;
    }

    /**
     * 检测是否成环
     *
     * @param e     待加入的顶点
     * @param e_lst 已在树中的顶点列表
     * @return 是否成环
     */
    private boolean Sround(edge e, List<edge> e_lst) {
        boolean uu = false, vv = false;
        for (edge i : e_lst) {
            if (i.u == e.u || i.v == e.u)
                uu = true;
            if (i.u == e.v || i.v == e.v)
                vv = true;
        }
        return uu && vv;
    }

    /**
     * 从邻接矩阵创建顶点数组
     *
     * @param cost 邻接矩阵
     * @return 顶点数组
     */
    public edge[] CreatEdge(int cost[][]) {
        if (cost.length != cost[0].length)
            return null;//输入非法矩阵
        int n = cost.length;
        int e_count_Max = (n * (n - 1)) / 2;
        int p = 0;
        for (int i[] : cost)
            for (int j : i)
                if (j == 0)
                    p++;
        int e_count = e_count_Max - ((n - p) / 2);//算出矩阵中有多少条边
        edge e[] = new edge[e_count];
        int ee = 0;
        for (int i = 0; i < cost.length - 1; i++) {
            for (int j = i + 1; j < cost.length; j++) {
                if (cost[i][j] != 0) {
                    edge temp = new edge();
                    temp.u = i + 1;
                    temp.v = j + 1;
                    temp.cost = cost[i][j];
                    e[ee] = temp;
                    ee++;
                }
            }
        }
        return e;
    }

    /**
     * 本函数功能为根据顶点的权值排序
     *
     * @param e 顶点数组
     * @return 排序后的顶点数组
     */
    private edge[] sort(edge[] e) {
        for (int i = 0; i < e.length - 1; i++) {
            for (int j = i + 1; j < e.length; j++) {
                if (e[i].cost > e[j].cost) {
                    edge temp = e[i];
                    e[i] = e[j];
                    e[j] = temp;
                }
            }
        }
        return e;
    }

    /**
     * 顶点类
     */
    class edge {
        int u, v, cost;
        //顶点u,v,权值
    }


}