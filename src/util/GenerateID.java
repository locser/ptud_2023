/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HUY
 */
public class GenerateID {
    private static String lastDate = "";
    private static int counter;
    
    public GenerateID() {
        
    }
    
    public static String dateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy");
        String datePart = dateFormat.format(new Date());
        return datePart;
    }
    public static String sinhMa(String ten) {
       Date datenow = new Date();
       SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyHHmmss");
       String formattedDate = dateFormat.format(datenow);
       String maPhatSinh = formattedDate;
       return ten + maPhatSinh;
    }
}
