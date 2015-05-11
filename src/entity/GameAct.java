package entity;

import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import util.FrameUtil;

public class GameAct {
        
        /**
         * 星球位置(玩家控制的对象)
         */
        private Point starLocation;
        
        /**
         * 星球编号(随机)
         */
        private int starType; 
        //TODO
        /**
         *星球的种类数
         */
        private static final int MAX_TYPE = 12;
        
        /**
         * 星球图片
         */
        private Image starImage;
        
        private static ArrayList<Image> TYPE_CONFIG;
        
        static{
                //TODO
                TYPE_CONFIG = new ArrayList<>();
                for (int i = 0; i < MAX_TYPE; i++) {
                        TYPE_CONFIG.add(new ImageIcon("graphics/stars/star"  + (i + 1) + ".png").getImage());
                }
        }
        
        private static final int nearSide = 64;
        
        public GameAct(int typeCode) {
                this.init(typeCode);
        }

        private void init(int typeCode) {
                //开始时的星球图像编号
                this.starType = typeCode;
                //开始时的星球图像
                this.starImage = TYPE_CONFIG.get(starType);
                int starLocationX = (int) (FrameUtil.SCREEN_SIZE.getHeight()/2);
                int starLocationY = (int) (FrameUtil.SCREEN_SIZE.getWidth()/2);
                this.starLocation = new Point(starLocationX,starLocationY);
        }
        
        public void  starMove(int moveX,int moveY) {
                int newX = this.starLocation.x + moveX;
                int newY = this.starLocation.y + moveY;
                if (isNearBorder(newX,newY)) {
                        //TODO 背景移动
                }
                starLocation.x = newX;
                starLocation.y = newY;
        }
        private boolean isNearBorder(int newX, int newY) {     
                int leftBorder = nearSide;
                int rightBorder = (int) (FrameUtil.SCREEN_SIZE.getWidth() - nearSide);
                int upBorder = nearSide;
                int downBorder = (int) (FrameUtil.SCREEN_SIZE.getHeight() - nearSide);
                return newX <= leftBorder || newX >= rightBorder || newY >= downBorder || newY <= upBorder;
        }

        public Point getStarLocation() {
                return starLocation;
        }

        public void setStarLocation(Point starLocation) {
                this.starLocation = starLocation;
        }
        

        
}
