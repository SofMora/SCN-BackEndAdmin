package com.admin.scnadmin.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

public class AESUtil {

    private static final String SECRET_KEY = "$Lenguajes2025$$"; // Puedes cambiarla por otra más fuerte
    private static final SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");

    // Método para cifrar el texto
    public String encrypt(String text) throws Exception {
        // Crear el objeto Cipher para AES
        Cipher cipher = Cipher.getInstance("AES");
        // Inicializar el cifrador con la clave
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        // Cifrar el texto en bytes
        byte[] encryptedBytes = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        // Codificar los bytes cifrados en Base64 y convertir a String
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public String decrypt(String encryptedText) throws Exception {
        // Decodificar el texto cifrado de Base64 a bytes
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        // Desencriptar los bytes y convertirlos de nuevo a texto
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
