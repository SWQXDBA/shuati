package MyTools.我的数据结构.数据结构实验;

import MyTools.我的数据结构.MyString;

public class 实验二串 {
    public static void main(String[] args) {
        MyString str = new MyString("输入结点值的顺序必须对应二叉树结点前序遍历的顺序。并约定以输入序列中不可能出现的值作为空结点的值以结束递归".toCharArray());
        System.out.println("输出S1串" + str);

        System.out.println("“二叉树”出现的位序: " + str.find(new MyString("二叉树"), 0));
        str = str.replace(new MyString("顺序"), new MyString("次序"));
        System.out.println("替换后的S1串:" + str);
        MyString str2 = new MyString("例如用“@”或用“-1”表示字符序列或正整数序列空结点。");
        MyString str3 = str.concat(str2);
        System.out.println("S串: " + str3);
        System.out.println("S的长度: " + str3.length());
        System.out.println("判断S1串和S串是否相等: " + str.equals(str3));
    }
}
