package com.qiux.tspringboot.util;

import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.PublicKeySign;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.signature.PublicKeySignFactory;
import com.google.crypto.tink.signature.PublicKeyVerifyFactory;
import com.google.crypto.tink.signature.SignatureKeyTemplates;

import java.security.GeneralSecurityException;
import java.util.Base64;

/**
 * @author qiuxian
 * @date 2021/10/7
 */
public class TinkSignatureUtil {

    public static void signatures(byte[] data) throws GeneralSecurityException {
        TinkConfig.register();

        //1.创建escsa对应的KeysetHandle对象
        KeysetHandle privateKeysetHandle = KeysetHandle.generateNew(SignatureKeyTemplates.ECDSA_P256);

//        System.out.println("privateKeysetINfo" + privateKeysetHandle.getKeysetInfo().getKeyInfo(0));
        //获取私钥
        PublicKeySign signer = PublicKeySignFactory.getPrimitive(privateKeysetHandle);

        //用私钥签名
        byte[] signature = signer.sign(data);
        String encode = Base64.getEncoder().encodeToString(data);
        System.out.println(encode);


        //签名验证
        //获取公钥对应的KeysetHandle对象
        KeysetHandle publicKeysetHandle = privateKeysetHandle.getPublicKeysetHandle();

//        System.out.println("publicKeysetHandle" + publicKeysetHandle.getKeysetInfo().getKeyInfo(0));

        //获取私钥
        PublicKeyVerify verify = PublicKeyVerifyFactory.getPrimitive(publicKeysetHandle);

        byte[] decode = Base64.getDecoder().decode(encode);

        //校验签名
        verify.verify(signature, decode);

    }


    public static void main(String[] args) throws GeneralSecurityException {
        try {
            TinkSignatureUtil.signatures(new String("hello world").getBytes());
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }


}
