package entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Random;
import ui.Img;
import util.FrameUtil;

public class BattleAct {
        private GameAct act;
        /**
         * 随机数生成器
         */
        private Random random = new Random();
        /**
         * （画出的）攻击图片的大小
         */
        private static final int BATTLE_SIZE = 70;
        /**
         * 表示原图偏离基准线的角度
         */
        private static final int[] BASE_ANGLE = { 45,45,135,45,30,225,180,45 };
        
        /**
         * 表示percent小于该值时认为是发展初期
         */
        private double beginningOfLevel = 0.1;
        /**
         * 第一次攻击的的等级（随机）
         * 第二次攻击的的等级（由现在文明等级确定）
         */
        private int battleLevel;
        /**
         * 表示两次攻击的运行位置
         */
        private Point battleLocation = new Point();
        /**
         * 当前偏离基准线的角度
         */
        private int angle;
        private int numOfBattle;
        private int side ;
        
        /**
         * @param numOfBattle 表明是第几次攻击
         */
        public BattleAct(GameAct act, int numOfBattle) {
                this.act = act;
                this.side = act.getNearside() ;
                this.numOfBattle = numOfBattle;
                this.battleLevel = 7;
//                this.battleLevel = this.numOfBattle == 0 ? random.nextInt(act.getNowLevel() + 1) + 1 : act.getNowLevel();
                this.angle = BASE_ANGLE[this.battleLevel];
                this.battleLocation = directionToPoint(random.nextInt(4));             
        }
        
        /**
         * 画出开始时攻击的图
         */
        public void beginBattle(Graphics g, Point directionVector) {               
                if(act.getPercent() > beginningOfLevel || act.getNowLevel() == 0)
                        return;
                g.drawImage(fixImg(Img.BATTLES.get(this.battleLevel),directionVector), battleLocation.x,
                                battleLocation.y, BATTLE_SIZE, BATTLE_SIZE, null);
        }
        
        /**
         * 将battle向directionVector所指的方向移动|directionVector|个像素
         * @param g 画笔
         */
        public void battleMove(Graphics g, Point directionVector) {
                // TODO 加判断
                this.battleLocation.x += directionVector.x;
                this.battleLocation.y += directionVector.y;
                g.drawImage(fixImg(Img.BATTLES.get(this.battleLevel),
                                directionVector), this.battleLocation.x,
                                this.battleLocation.y, BATTLE_SIZE,
                                BATTLE_SIZE, null);
        }
               
        /**
         * 定位
         * @return battleLocation到target间的方向向量
         */
        public Point fixPosition(Point target) {
                int vectorX = target.x - this.battleLocation.x;
                int vectorY = target.y - this.battleLocation.y;
                return minVector(vectorX, vectorY) ;
        }
        
        public boolean isOutOfBound() {
                int x1 = this.side;
                int x2 = FrameUtil.SCREEN_SIZE.getSize().width - this.side
                                - BATTLE_SIZE;
                int y1 = this.side;
                int y2 = FrameUtil.SCREEN_SIZE.getSize().height - this.side
                                - BATTLE_SIZE;
                return this.battleLocation.x > x2 || this.battleLocation.x < x1
                                || this.battleLocation.y > y2
                                || this.battleLocation.y < y1;
        }
        
        private BufferedImage fixImg(BufferedImage image,Point directionVector) {
                double directionRadian;
                if (directionVector.x >= 0 && directionVector.y >= 0) {
                        directionRadian = Math.atan(directionVector.getY()
                                        / directionVector.getX());
                } else if (directionVector.x < 0) {
                        directionRadian = Math.atan(directionVector.getY()
                                        / directionVector.getX())
                                        + Math.PI;
                } else {
                        directionRadian = Math.atan(directionVector.getY()
                                        / directionVector.getX())
                                        + 2 * Math.PI;
                }
                this.angle = (int) (directionRadian/Math.PI * 180 - BASE_ANGLE[this.battleLevel]);
                return PicRound.picRound(image, this.angle);
        }
        
        /**
         * 将方向向量化为需要的步长
         */
        private Point minVector(int vectorX,int vectorY){
                int battleMoveStep = 5;
                if(vectorX == 0 || vectorY == 0)
                        return vectorX == 0 ? new Point(0,battleMoveStep) : new Point(battleMoveStep,0);
                double length = Math.sqrt(vectorX * vectorX + vectorY * vectorY);
                //TODO
                double newX = battleMoveStep * vectorX / length;
                double newY = battleMoveStep * vectorY / length;
                return new Point((int)newX,(int)newY);
        }
        
        /**
         * 将direction表示的方向转化为坐标
         * @param direction 0 表示左上角，逆时针方向
         */
        private Point directionToPoint(int direction){
                int x1 = this.side;
                int x2 = FrameUtil.SCREEN_SIZE.getSize().width
                                - this.side - BATTLE_SIZE;
                int y1 = this.side;
                int y2 = FrameUtil.SCREEN_SIZE.getSize().height
                                - this.side - BATTLE_SIZE;
                
                Point[] points = { new Point(x1, y1), new Point(x2, y1),
                                new Point(x1, y2), new Point(x2, y2) };        
                return points[direction];
        }

        public Point getBattleLocation() {
                return battleLocation;
        }

        
        
}
