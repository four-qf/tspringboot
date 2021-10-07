package com.qiux.tspringboot.util;

import com.google.common.base.Strings;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @author qiuxiansecretKey
 * @date 2021/10/7
 */
public class DeEncoderCipherUtil {

    //加密、解密模式
    private final static String CIPHER_MODE = "DES";

    //DES 密钥
    public static String DEFAULT_DES_KEY = "";

    /**
     * 字节加密方法
     * @param originalContent 明文
     * @param key 加密密钥的byte数组
     * @return 密文的byte数组
     */
    private static byte[] encrypt (byte[] originalContent, byte[] key) throws Exception {

        //1.生成可信任的随机数源
        SecureRandom secureRandom = new SecureRandom();

        //2.基于密钥数据创建DESKeySpec对象
        DESKeySpec desKeySpec = new DESKeySpec(key);

        //3.创建密钥工厂，将DESKeySpec转换成SecretKey对象来保存对称密钥
        SecretKeyFactory instance = SecretKeyFactory.getInstance(CIPHER_MODE);
        SecretKey secretKey = instance.generateSecret(desKeySpec);

        //4.Cipher对象实际完成加密操作，指定其支持的相应的加密和解密算法
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);

        //5.用密钥初始化Cipher对象，ENCRYPT_MODE表示加密模式
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, secureRandom);

        //返回密文
        return cipher.doFinal(originalContent);
    }

    /**
     * 字节解密方法
     * @param ciphertextByte
     * @param key
     * @return
     */
    private static byte[] decrypt(byte[] ciphertextByte, byte[] key) throws Exception {
        //1.生成可信任的随机数源
        SecureRandom secureRandom = new SecureRandom();
        //2.基于密钥数据创建DESKeySpec对象
        DESKeySpec desKeySpec = new DESKeySpec(key);
        //3.创建密钥工厂，将DESKeySpec转换成SecretKey对象来保存对称密钥
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(CIPHER_MODE);
        SecretKey secretKey = secretKeyFactory.generateSecret(desKeySpec);
        //4.Cipher对象实际完成加密操作，指定其支持的相应的加密和解密算法
        Cipher cipher = Cipher.getInstance(CIPHER_MODE);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, secureRandom);

        return cipher.doFinal(ciphertextByte);
    }


    public static String encrypt(String originalContent, String key) {
        //明文或加密密钥为空时
        if (Strings.isNullOrEmpty(originalContent) || Strings.isNullOrEmpty(key)) {
            return null;
        }

        try {
            byte[] encrypt = encrypt(originalContent.getBytes(), key.getBytes());
            return new BASE64Encoder().encode(encrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String cipherText, String key) throws Exception {

        BASE64Decoder base64Decoder = new BASE64Decoder();
        byte[] bytes = base64Decoder.decodeBuffer(cipherText);

        byte[] decrypt = decrypt(bytes, key.getBytes());


        return new String(decrypt);

    }

    public static void main(String[] args) throws Exception {

        String secretKey = " 2019届校园招聘开启啦！内推简历扔过来呀！";

        String encrypt = DeEncoderCipherUtil.encrypt("2019届校园招聘开启啦！", secretKey);

        System.out.println(encrypt);

        String decrypt = DeEncoderCipherUtil.decrypt(encrypt, secretKey);

        System.out.println("decrypt:" + decrypt);
    }

}
