package com.qiux.tspringboot.util;

import com.google.crypto.tink.*;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadFactory;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;
import com.google.crypto.tink.proto.KeyTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 * @author qiuxian
 * @date 2021/10/7
 */
@Component
public class TinkCryptoUtil implements InitializingBean {

    private KeysetHandle keysetHandle;

    private String keysetFilename = "my_keyset.json";

    private Aead priviAead;

//    private String gcpKeysetFilename =  "my_gcp_keyset.json";

    /**
     * 注册
     */
    public void register() {

        try {
            TinkConfig.register();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用AEAD原语实现注册
     */
    public void registerAEAD() {
        try {
            AeadConfig.register();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自定义初始化注册
     */
    public void registerOwn() {

//        Registry.registerKeyManager(new MyHeadManager());

    }

    //生成密钥集
    public KeysetHandle createKeySet() {

        KeyTemplate keyTemplate = AeadKeyTemplates.AES128_GCM;
        KeysetHandle keysetHandle = null;
        try {
            keysetHandle = KeysetHandle.generateNew(keyTemplate);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return keysetHandle;

    }

    public void save2File() {
        //创建AES对应的keysetHandle
        //写入json文件

        try {
            CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withFile(new File(keysetFilename)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public void save2FileBaseKMS() throws IOException, GeneralSecurityException {
//
//        //使用gcp-kms方式对称密钥加密
//        String masterKeyUri = "gcp-kms://projects/tink-examples/locations/global/keyRings/foo/cryptoKeys/bar";
//        GcpKmsClient gcpKmsClient = new GcpKmsClient();
//        gcpKmsClient.withDefaultCredentials();
//        keysetHandle.write(JsonKeysetWriter.withFile(new File(gcpKeysetFilename)),gcpKmsClient.getAead(masterKeyUri));
//
//    }

    //加载加密的密钥集
    public KeysetHandle loadKey() {

//        String masterKeyUri = "aws-kmsL://arn:aws:us-east-1:007084425826:key/84a65985-f868-4bfc-83c2-366618acf147";
        KeysetHandle keysetHandle1 = null;
        try {
            keysetHandle1 = CleartextKeysetHandle.read(JsonKeysetReader.withFile(new File(keysetFilename)));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return keysetHandle1;
    }

    /**
     * 使用AEAD通过认证加密
     *
     * @param plaintext
     * @param aad
     * @return
     */
    public byte[] enAeadAES(byte[] plaintext, byte[] aad) throws UnsupportedEncodingException {

        try {
            //用私钥加密明文
            byte[] ciphertext = priviAead.encrypt(plaintext, aad);

            //解密明文
            return ciphertext;

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return null;

    }

    /**
     * 使用AEAD通过认证解密
     */
    public String decAeadAES(byte[] ciphertext, byte[] aad) {

        try {

            //用私钥解密明文
            byte[] decrypt = priviAead.decrypt(ciphertext, aad);
            //解密明文
            return new String(decrypt);

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.qiux.tspringboot.util");
        context.start();
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        TinkCryptoUtil tinkCryptoUtil = beanFactory.getBean(TinkCryptoUtil.class);
//        tinkCryptoUtil.save2File();

//        KeysetHandle keysetHandle = tinkCryptoUtil.loadKey();
//        KeysetInfo keysetInfo = keysetHandle.getKeysetInfo();
//        System.out.println(keysetInfo);

        byte[] bytes = tinkCryptoUtil.enAeadAES(new String("hello world").getBytes("utf-8"), null);
        System.out.println("aeadAES: " + bytes);


        String decAeadAES = tinkCryptoUtil.decAeadAES(bytes, null);
        System.out.println("decAeadAES:" + decAeadAES);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        registerAEAD();
        keysetHandle = createKeySet();
        priviAead = AeadFactory.getPrimitive(keysetHandle);
    }

}
