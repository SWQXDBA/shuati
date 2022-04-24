package 笔试题;

import java.util.Stack;

public class 简化路径 {
    public static void main(String[] args) {
        System.out.println(pathConvert("/home/"));
        System.out.println(pathConvert("/../"));
        System.out.println(pathConvert("/home//foo/"));
        System.out.println(pathConvert("/a/./b/../../c/"));
        System.out.println(pathConvert("/a/../../b/../c//.//"));
        System.out.println(pathConvert("/a//b////c/d//././/.."));
        System.out.println("自建测试用例:");
        System.out.println(pathConvert("//////"));
        System.out.println(pathConvert("/a/././././"));
        System.out.println(pathConvert("/a/b/c/a/b/c"));

    }

    public static String pathConvert(String source) {
        Stack<String> stack = new Stack<>();
        final String[] strings = source
                //去掉多余的'/'
                .replaceAll("/+", "/")
                //切分路径
                .split("/");

        for (String str : strings) {
            if ("".equals(str) || ".".equals(str)) {
                continue;
            }
            if ("..".equals(str)) {
                //当前路径不为'/'时 才可以回退到上一级
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stack.forEach(str -> stringBuilder.append("/").append(str));

        return stringBuilder.toString();
    }
}
