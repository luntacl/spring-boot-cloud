package com.github.tangram.fee.common.util.idUtil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liutao on 2017/5/18.
 */
public class CustomerIdGenerator {

    public static String hashId(String SourceStr) {
        String hashId;
        try {
            byte[] bytes = MD5(SourceStr.getBytes("UTF-8"));
            hashId = discrete(bytes);
        } catch (Exception e) {
            hashId = null;
        }
        return hashId;
    }

    public static byte[] MD5(byte[] bySourceByte) throws NoSuchAlgorithmException {
        MessageDigest md;
        md = MessageDigest.getInstance("MD5");
        md.reset();
        md.update(bySourceByte);
        byte[] byDisByte = md.digest();
        return (byDisByte);
    }

    /**
     * 此算法借鉴于MD5加密的离散算法,将十六进制转化到十进制数字区间，同时,
     * 让首位默认为1，避免有以0开头的用户Id,末尾三位是为了增加离散度，倒数
     * 第三位是离散区间值大于10之和取10的余数；倒数第二位是所有离散区间值之和
     * 取10的余数；最后一位是离散区间值小于10之和取10的余数，理论上与md5加密
     * 碰撞率差异可以忽略,提高(5/8)^16 * 1000=0.5倍
     * @param sourceBytes
     * @return
     */
    public static String discrete(byte[] sourceBytes) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char k = 0, high_disperse = 0, mid_disperse = 0, low_disperse = 0;
        int len = sourceBytes.length;
        char str[] = new char[len + 4];
        str[k++] = hexDigits[1];
        for (int i = 0; i < len; i++) {
            char tmp = (char) ((sourceBytes[i] >>> 4) & 0x000f);
            str[k++] = hexDigits[tmp % 10];
            mid_disperse += tmp;
            if (tmp >= 10) {
                high_disperse += tmp;
            } else {
                low_disperse += tmp;
            }
        }
        //再次离散，减小碰撞概率
        str[k++] = hexDigits[high_disperse % 10];
        str[k++] = hexDigits[mid_disperse % 10];
        str[k++] = hexDigits[low_disperse % 10];
        return new String(str);
    }

    public static void main(String[] args) {
        String idType="1"; //证件类型
        String idNo="411222197708257047";
        String a = idType + idNo;
        System.out.println(hashId(a));

    }
}
