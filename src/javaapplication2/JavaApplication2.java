/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication2;

import connectDB.ConnectDB;
import gui.DangNhap;
import gui.DatVe_JFrame;
import gui.TrainInfoPanel;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ploc2
 */
public class JavaApplication2 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//    SwingUtilities.invokeLater(() -> {
//                new DatVe_JFrame(null).setVisible(true);
//            });

          ConnectDB connectDB = new ConnectDB();
        try {
            connectDB.connect();
            System.out.println(ConnectDB.getInstance());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
//         TODO code application logic here
                DangNhap dn = new DangNhap();
        dn.setVisible(true);
        dn.setTitle("Đăng Nhập");
        dn.setSize(850, 600); //[812, 512]
        dn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dn.setLocationRelativeTo(null);  // Đặt cửa sổ ở giữa màn hình
    }
    
}
