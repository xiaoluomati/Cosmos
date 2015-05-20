package ui;

import java.awt.*;
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
        
        public static final ArrayList<Image> BATTLES;
        
        static{
                //攻击图片数组
                File dir = new File("graphics/battle");
                File[] files = dir.listFiles();
                BATTLES = new ArrayList<Image>();
                for (File file : files) {
                        if(file.isDirectory())
                                continue;                       
                        BATTLES.add(new ImageIcon(file.getPath()).getImage());
                }
        }
}
