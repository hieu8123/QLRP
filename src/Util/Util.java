/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author 21522
 */
public class Util {
     public static void scaleIMG(String linkanhString, JLabel lbLabel){
        ImageIcon icon = new ImageIcon(linkanhString);        
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(lbLabel.getWidth(), lbLabel.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaleIcon = new ImageIcon(imgScale);
        lbLabel.setIcon(scaleIcon);
    }
}
