package MyTools.我的数据结构;

import java.util.Arrays;

public class MyString {
    int maxSize = 128;
    char[] value;

    public MyString(char[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public MyString(String str) {
        this(str.toCharArray());
    }

    public int length() {
        return value.length;
    }

    public boolean equals(MyString str) {
        if (value.length != str.length()) {
            return false;
        }
        for (int i = 0; i < value.length; i++) {
            if (value[i] != str.value[i]) {
                return false;
            }
        }
        return true;
    }


    public MyString concat(MyString str) {
        char[] v = new char[value.length + str.value.length];
        int i = 0;
        for (char c : value) {
            v[i++] = c;
        }
        for (char c : str.value) {
            v[i++] = c;
        }
        return new MyString(v);
    }

    public char charAt(int i) {
        return value[i];
    }

    public int find(MyString str, int k) {
        if (k >= length()) {
            return -1;
        }
        return find(value, str.value, k);

    }

    public MyString replace(MyString from, MyString to) {
        int index = find(this.value, from.value, 0);

        if (index == -1) {
            return new MyString(this.value);
        }
        char[] newValue = new char[value.length - from.length() + to.length()];
        int i = 0;
        for (; i < index; i++) {
            newValue[i] = value[i];
        }
        for (int j = 0; j < to.length(); j++, i++) {
            newValue[i] = to.value[j];
        }
        for (int j = index + from.length(); j < value.length; j++, i++) {
            newValue[i] = value[j];
        }
        //替换多个
        return new MyString(newValue).replace(from, to);

    }

    private int find(char[] v1, char[] v2, int k) {
        for (int i = k; i < v1.length; i++) {

            if (v1.length - k < v2.length) {
                return -1;
            }

            int start = i;
            int pstart = 0;
            boolean flag = true;

            while (pstart < v2.length) {
                if (v1[start] == v2[pstart]) {
                    start++;
                    pstart++;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return new String(value);
    }
}
