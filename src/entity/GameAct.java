package entity;

import java.awt.Image;
import java.awt.Point;
import ui.Img;
import util.FrameUtil;

public class GameAct {
//      TODO
        /**
         *星球的种类数
         */
        public static final int MAX_TYPE = 10;
        /**
         * 星球图像
         */
        public static final int STAR_SIZE = 50;
        /**
         * 星球的左上角坐标(玩家控制的对象)
         */
        private Point starLocation;       
        /**
         * 星球编号(随机)
         */
        private int starType;      
        /**
         * 星球图片
         */
        private Image starImage  ;
        /**
         * 现在的文明发展等级
         */
        private int nowLevel;
        /**
         * 现在的文明发展程度(进度条比例)
         */
        private double percent;
        
        private static final int nearSide = 64;
        
        public GameAct(int typeCode) {
                this.init(typeCode);                
        }

        private void init(int typeCode) {
                //开始时的星球图像编号
                this.starType = typeCode;
                //开始时的星球图像
                this.starImage = Img.STARS.get(starType);
                
                int starLocationX = (int) (FrameUtil.SCREEN_SIZE.getWidth() - STAR_SIZE)/2;
                int starLocationY = (int) (FrameUtil.SCREEN_SIZE.getHeight() - STAR_SIZE)/2;
                this.starLocation = new Point(starLocationX,starLocationY);
        }
        
        public void  starMove(int moveX,int moveY) {
                int newX = this.starLocation.x + moveX;
                int newY = this.starLocation.y + moveY;
                if (isNearBorder(newX,newY)) {
                        //TODO 背景移动
                        return;
                }
                starLocation.x = newX;
                starLocation.y = newY;
        }
        private boolean isNearBorder(int newX, int newY) {     
                int leftBorder = nearSide;
                int rightBorder = (int) (FrameUtil.SCREEN_SIZE.getWidth() - nearSide - STAR_SIZE);
                int upBorder = nearSide;
                int downBorder = (int) (FrameUtil.SCREEN_SIZE.getHeight() - nearSide - STAR_SIZE);
                return newX <= leftBorder || newX >= rightBorder || newY >= downBorder || newY <= upBorder;
        }

        public Point getStarLocation() {
                return starLocation;
        }

        //TODO
        public void setStarLocation(Point starLocation) {
                this.starLocation = starLocation;
        }
        
        public int getStarType() {
                return starType;
        }

        public Image getStarImage() {
                return starImage;
        }

        public int getNowLevel() {
                return nowLevel;
        }

        public double getPercent() {
                return percent;
        }
        
}
