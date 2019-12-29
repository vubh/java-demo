package com.example.v3.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.Charset;
import java.security.Key;

public class DESUtil {

    public static void main(String[] args) {
        DESUtil des = DESUtil.createInstace("asfadfadsafa");
        String encStr = des.getEncString("google");
        System.out.println("密文：" + encStr);
        String desStr = des.getDesString(encStr);
        System.out.println("明文：" + desStr);
    }


    Key key;

    /**
     * 密钥
     */
    private static byte[] BOSS_SECRET_KEY = {(byte) 0xb2, 0x0b, 0x13, (byte) 0xb2, (byte) 0xe7,
            0x51, 0x0d, 0x75, (byte) 0xc2, 0x4e, (byte) 0xe2, (byte) 0xdd,
            (byte) 0x4b, 0x24, 0x36, (byte) 0xa8, (byte) 0x28, 0x13, 0x0b, (byte) 0x51, 0x31, 0x0d, 0x75, (byte) 0xc1};

    private DESUtil() {
        setKey(BOSS_SECRET_KEY);
    }

    private DESUtil(byte[] str) {
        setKey(str);
    }

    private DESUtil(String key) {
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes(Charset.forName("UTF-8")));
            SecretKeyFactory keyFactory;
            keyFactory = SecretKeyFactory.getInstance("DES");
            this.key = keyFactory.generateSecret(dks);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error initializing DESTOOLS class. Cause: " + e);
        }
    }

    public static DESUtil instance = new DESUtil();

    public static DESUtil getInstace() {
        return instance;
    }

    public static DESUtil createInstace(String key) {
        instance = new DESUtil(key);
        return instance;
    }

    /**
     * 根据参数生成KEY
     */
    public void setKey(byte[] strKey) {
        try {
            DESKeySpec dks = new DESKeySpec(BOSS_SECRET_KEY);
            SecretKeyFactory keyFactory;
            keyFactory = SecretKeyFactory.getInstance("DES");
            this.key = keyFactory.generateSecret(dks);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error initializing DESTOOLS class. Cause: " + e);
        }
    }

    /**
     * 加密String明文输入,String密文输出
     */
    public String getEncString(String strMing) {
        byte[] byteMi = null;
        byte[] byteMing = null;
        String strMi = "";
        BASE64Encoder base64en = new BASE64Encoder();
        try {
            byteMing = strMing.getBytes("UTF8");
            byteMi = this.getEncCode(byteMing);
            strMi = base64en.encode(byteMi);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error initializing DESTOOLS class. Cause: " + e);
        } finally {
            base64en = null;
            byteMing = null;
            byteMi = null;
        }
        return strMi;
    }

    /**
     * 解密 以String密文输入,String明文输出
     *
     * @param strMi
     * @return
     */
    public String getDesString(String strMi) {
        BASE64Decoder base64De = new BASE64Decoder();
        byte[] byteMing = null;
        byte[] byteMi = null;
        String strMing = "";
        try {
            byteMi = base64De.decodeBuffer(strMi);
            byteMing = this.getDesCode(byteMi);
            strMing = new String(byteMing, "UTF8");
        } catch (Exception e) {
            throw new RuntimeException("Error initializing DESTOOLS class. Cause: " + e);
        } finally {
            base64De = null;
            byteMing = null;
            byteMi = null;
        }
        return strMing;
    }

    /**
     * 加密以byte[]明文输入,byte[]密文输出
     *
     * @param byteS
     * @return
     */
    private byte[] getEncCode(byte[] byteS) {
        byte[] byteFina = null;
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byteFina = cipher.doFinal(byteS);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error initializing DESTOOLS class. Cause: " + e);
        } finally {
            cipher = null;
        }
        return byteFina;
    }

    /**
     * 解密以byte[]密文输入,以byte[]明文输出
     *
     * @param byteD
     * @return
     */
    private byte[] getDesCode(byte[] byteD) {
        Cipher cipher;
        byte[] byteFina = null;
        try {
            cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byteFina = cipher.doFinal(byteD);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error initializing DESTOOLS class. Cause: " + e);
        } finally {
            cipher = null;
        }
        return byteFina;
    }
}
