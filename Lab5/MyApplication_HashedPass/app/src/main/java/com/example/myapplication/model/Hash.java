package com.example.myapplication.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
    public static String hashPassword(String password) {
        try {
            // Khởi tạo đối tượng MessageDigest với thuật toán SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Chuyển đổi mật khẩu thành mảng byte và băm nó
            byte[] hashedBytes = digest.digest(password.getBytes());

            // Chuyển đổi mảng byte thành chuỗi Hex
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();  // trả về chuỗi hash dưới dạng hex
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
