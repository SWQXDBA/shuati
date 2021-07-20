package 力扣题目.二叉树;

import MyTools.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 二叉树最大宽度 {
    static Map<Long, List<Long>> map = new HashMap<>();

    public long widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        helper(root, 0, 0);
        long max = 0;
        for (Map.Entry<Long, List<Long>> entry : map.entrySet()) {
            List<Long> list = entry.getValue();
            list.sort(Long::compare);
            max = Math.max(max, list.get(list.size() - 1) - list.get(0) + 1);
        }
        return Math.toIntExact(max);
    }

    public void helper(TreeNode root, long layer, long index) {
        if (root == null) {
            return;
        }
        List<Long> layerData;

        if (!map.containsKey(layer)) {
            layerData = new ArrayList<>();
            map.put(layer, layerData);
        } else {
            layerData = map.get(layer);
        }
        layerData.add(index);
        helper(root.left, layer + 1, 2 * index - 1);
        helper(root.right, layer + 1, 2 * index);
    }
}
