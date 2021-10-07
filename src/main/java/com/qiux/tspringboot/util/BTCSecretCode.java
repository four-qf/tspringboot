package com.qiux.tspringboot.util;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import com.google.common.primitives.Bytes;
import org.bitcoinj.core.Base58;
import org.bouncycastle.crypto.digests.RIPEMD160Digest;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.ECPoint;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiuxian
 * @date 2021/10/7
 */
public class BTCSecretCode {

    private static String PUBLIC_KEY = "PUBLIC_KEY";

    private static String PRIVATE_KEY = "PRIVATE_KEY";

    private static String KEY_ALGORITHM = "EC";

    /**
     * 椭圆曲线算法
     */
    private static String SECP256 = "secp256k1";

    private static String CIP_SHA256 = "SHA-256";

    private static String CIP_RIPEMD160 = "RipeMD160";


    public static Map<String, Object> initKey() throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        ECGenParameterSpec ecSpec = new ECGenParameterSpec(SECP256);
        keyPairGenerator.initialize(ecSpec);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        //公钥
        PublicKey publicKey = keyPair.getPublic();
        //私钥
        PrivateKey privateKey = keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    public static String getPublicKey(Map<String, Object> map) {
        ECPublicKey ecPublicKey = (ECPublicKey) map.get(PUBLIC_KEY);
        ECPoint ecPoint = ecPublicKey.getW();
        String sx = adjustTo64(ecPoint.getAffineX().toString(16)).toUpperCase();
        String sy = adjustTo64(ecPoint.getAffineY().toString(16)).toUpperCase();
        String bcPub = "04" + sx + sy;

        return bcPub;
    }

    /**
     * 获取私钥
     * @param map
     * @return
     */
    public static String getPrivateKey(Map<String, Object> map) {
        ECPrivateKey privateKey = (ECPrivateKey) map.get(PRIVATE_KEY);
        String priKeyStr = adjustTo64(privateKey.getS().toString(16)).toUpperCase();
        return priKeyStr;
    }

    public static String getAddress(String publicKey) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchProviderException {

        //1.公钥sha256加密
        MessageDigest shaDigst = MessageDigest.getInstance(CIP_SHA256);
        byte[] digest = shaDigst.digest(publicKey.getBytes("UTF-8"));
        System.out.println("sha:" + ByteArrayUtil.toHexString(digest).toUpperCase());

        //2.进行RIPEMD160加密
//        MessageDigest ripMessageDigest = MessageDigest.getInstance("RipeMD160");
//        byte[] ripDigest = ripMessageDigest.digest(digest);

        RIPEMD160Digest d = new RIPEMD160Digest();
        d.update (digest, 0, digest.length);
        byte[] ripDigest = new byte[d.getDigestSize()];
        d.doFinal (ripDigest, 0);


        //3.生成主网地址需要在开头加0x00
        byte[] ripDigPre = new byte[ripDigest.length + 1];
        ripDigPre[0] = 0;
        for(int i = 0; i < ripDigest.length; i++) {
            ripDigPre[i+1] =  ripDigest[i];
        }
        System.out.println("0x00 + RIPEMD160(SHA256(key)) :" + ByteArrayUtil.toHexString(ripDigPre));

        //4.Base58Check编码
        //4.1 生成checksum：sha256(sha256(0x00+key))
        byte[] shaPre1 = shaDigst.digest(ripDigPre);
        byte[] digest2 = shaDigst.digest(shaPre1);
        //4.2 完整的checkcode：0x00+key+checksum前四个字节
        byte[] checkcode = new byte[25];
        checkcode = Bytes.concat(ripDigPre, ByteUtils.subArray(digest2,0,4));

        //4.3 Base58(checkcode)
        String adress = Base58.encode(checkcode);


        return adress;
    }


    /**
     * 填充密钥位数到64
     * @param s
     * @return
     */
    private static String adjustTo64(String s) {
        switch (s.length()) {
            case 62: return "00" + s;
            case 63: return "0" + s;
            case 64: return "0" + s;
            default:
                throw new IllegalArgumentException("not a valid key : " + s);
        }
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> secretMap = BTCSecretCode.initKey();
        String privateKey = BTCSecretCode.getPrivateKey(secretMap);
        System.out.println("private key: " + privateKey);

        String publicKey = BTCSecretCode.getPublicKey(secretMap);
        System.out.println("public key: " + publicKey);

        String address = BTCSecretCode.getAddress(publicKey);
        System.out.println("address:" + address);

    }

}
