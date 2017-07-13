package com.zxr.medicalaid.utils.encode;

/**
 * Created by ASUS-NB on 2017/7/7.
 */

public class EncodeUtil {


    /**
     * 十六进制字符串与byte数组之间的相互转换
     *
     * @param hex
     * @return
     * @throws IllegalArgumentException
     */
    public static final byte[] hex2byte(String hex)
            throws IllegalArgumentException {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

    public static final String byte2hex(byte b[]) {
        if (b == null) {
            throw new IllegalArgumentException(
                    "Argument b ( byte array ) is null! ");
        }
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xff);
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

//    public static String doEncrypt(String data, String keyString) {
//        MessageDigest md = null;
//        try {
//             md = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//        //生成字节Key
//        byte[] byteKey = md.digest(keyString.getBytes());
//        //Key转换
//        Key convertKey = new SecretKeySpec(byteKey, "AES");
//        Key myKey = convertKey;
//        try {
//            //加密
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, myKey);
//            byte[] encode = cipher.doFinal(data.getBytes());
//            String encodeString = EncodeUtil.byte2hex(encode);
//            return encodeString;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
