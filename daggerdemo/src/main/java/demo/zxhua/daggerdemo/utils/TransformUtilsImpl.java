package demo.zxhua.daggerdemo.utils;

/**
 * Created by Zxhua on 2017/9/27 0027.
 */

public class TransformUtilsImpl implements TransformUtils {

    @Override
    public String strToBinstr(String str) {
        char[] strChars = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strChars.length; i++) {
            result.append(Integer.toBinaryString(strChars[i])).append(" ");
        }
        return result.toString();
    }

    @Override
    public String binstrToStr(String binstr) {
        String[] tempStr = strToStrArray(binstr);
        char[] tempChar = new char[tempStr.length];
        for (int i = 0; i < tempStr.length; i++) {
            tempChar[i] = binstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }

    @Override
    public char binstrToChar(String binstr) {
        int[] binstrInts = binstrToIntArray(binstr);
        int sum = 0;
        for (int i = 0; i < binstrInts.length; i++) {
            sum += binstrInts[binstrInts.length - 1 - i] << i;
        }
        return (char) sum;
    }

    @Override
    public int[] binstrToIntArray(String binstr) {
        char[] binstrInts = binstr.toCharArray();
        int[] result = new int[binstrInts.length];
        for (int i = 0; i < binstrInts.length; i++) {
            result[i] = binstrInts[i] - 48;
        }

        return result;
    }

    @Override
    public String[] strToStrArray(String str) {
        return str.split(" ");
    }

}
