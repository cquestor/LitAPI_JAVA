package com.cquestor.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {

    /**
     * AES-CBC(Base64)
     * 
     * @param content 待加密内容
     * @param key     加密密钥
     * @param iv      加密偏移量
     * @return 加密结果
     * @throws Exception 加密异常
     */
    public static String AES(String content, String key, String iv) throws Exception {
        byte[] bContent = content.getBytes("UTF-8");
        byte[] bKey = key.getBytes("UTF-8");
        byte[] bIv = iv.getBytes("UTF-8");
        SecretKeySpec keySpec = new SecretKeySpec(bKey, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(bIv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] result = cipher.doFinal(bContent);
        return Base64.getEncoder().encode(result).toString();
    }
}
