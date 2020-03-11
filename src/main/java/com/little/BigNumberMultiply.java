package com.little;

public class BigNumberMultiply {
    public static void main(String[] args) {
        String n1 = "123456";
        String n2 = "12987";
        String result = multiply(n1, n2);
        System.out.println(result);
    }

    /**
     * 计算两个大数相乘的方法
     * @param n1 乘数
     * @param n2 乘数
     * @return 相乘结果
     */
    private static String multiply(String n1, String n2) {
        //转换成int数组
        int[] n1Arr = change(n1);
        int[] n2Arr = change(n2);
        int[] result = new int[n1.length() + n2.length()];
        // 模拟乘法列式
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                result[i + j] += n1Arr[i] * n2Arr[j];
            }
        }

        //进位算法
        for (int i = result.length -1; i >0; i--) {
            result[i-1] += result[i] / 10;
            result[i] = result[i] % 10;
        }

        //将结果转化为字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length - 1; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }

    /**
     * 将字符串转化为int数组
     * @param n1 需要转化的字符串数组
     * @return int数组
     */
    private static int[] change(String n1) {
        int[] changed = new int[n1.length()];
        char[] chars = n1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            changed[i] = chars[i] - '0';
        }
        return changed;
    }
}
