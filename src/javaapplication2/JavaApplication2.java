/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import connectDB.ConnectDB;
import gui.DangNhap;
import javax.swing.JFrame;

/**
 *
 * @author ploc2
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                DangNhap dn = new DangNhap();
        dn.setVisible(true);
        dn.setTitle("Đăng Nhập");
        dn.setSize(850, 600); //[812, 512]
        dn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dn.setLocationRelativeTo(null);  // Đặt cửa sổ ở giữa màn hình

        ConnectDB connectDB = new ConnectDB();
        try {
            connectDB.connect();
            System.out.println(ConnectDB.getInstance());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    
}
