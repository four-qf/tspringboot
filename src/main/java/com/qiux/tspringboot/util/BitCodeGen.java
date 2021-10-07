package com.qiux.tspringboot.util;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.LegacyAddress;
import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.MainNetParams;

/**
 * @author qiuxian
 * @date 2021/10/7
 */
public class BitCodeGen {

    public static void main(String[] args) {
        NetworkParameters params = MainNetParams.get();
        ECKey key = new ECKey();
        System.out.println("private key：" + key.getPrivateKeyAsHex()  );
        System.out.println("public key：" + key.getPublicKeyAsHex()  );
        Address address = LegacyAddress.fromKey(params, key);
        System.out.println("adress:" + ((LegacyAddress) address).toBase58());

    }

}
