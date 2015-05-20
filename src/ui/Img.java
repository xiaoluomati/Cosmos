package ui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

public class Img {
	
	private Img() {}
	
	public static final ImageIcon EXIT_LIGHT = new ImageIcon("graphics/button/exitlight.png");
	
	public static final ImageIcon EXIT_DARK = new ImageIcon("graphics/button/exitdark.png");
	
	public static final ImageIcon GAME_EXIT_DARK = new ImageIcon("graphics/button/gameExitDark.png");
	
	public static final ImageIcon GAME_EXIT_LIGHT = new ImageIcon("graphics/button/gameExitLight.png");
	
	public static final Image BG_START = new ImageIcon("graphics/background/bg00.jpg").getImage();
	
	public static final Image BG_GAME = new ImageIcon("graphics/background/bg02.jpg").getImage();
		
	public static final ArrayList<Image> STARS;
        	
        static{
                //背景图片数组
                File dir = new File("graphics/stars");
                File[] files = dir.listFiles();
                STARS = new ArrayList<Image>();
                for (File file : files) {
                        if(file.isDirectory())
                                continue;                       
                        STARS.add(new ImageIcon(file.getPath()).getImage());
                }
        }
        
        public static final ArrayList<BufferedImage> BATTLES;
        
        static{
                //攻击图片数组
                File dir = new File("graphics/battle");
                File[] files = dir.listFiles();
                BATTLES = new ArrayList<BufferedImage>();
                for (File file : files) {
                        if(file.isDirectory())
                                continue;                       
                        Image image = new ImageIcon(file.getPath()).getImage();
                        BufferedImage bufferedImage = new BufferedImage(
                                        image.getWidth(null),
                                        image.getHeight(null),
                                        BufferedImage.TYPE_INT_ARGB);
                        Graphics g = bufferedImage.createGraphics();  
                        g.drawImage(image, 0, 0, null);  
                        g.dispose();  
                        BATTLES.add(bufferedImage);
                }
        }
}
