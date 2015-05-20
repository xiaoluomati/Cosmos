package entity;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;
import ui.Img;
import util.FrameUtil;

public class BattleAct {
        private GameAct act;
        /**
         * 第一次攻击的的等级（随机）
         * 第二次攻击的的等级（由现在文明等级确定）
         */
        private int[] battleLevel = new int [2];
        /**
         * 随机数生成器
         */
        private Random random = new Random();
        /**
         * （画出的）攻击图片的大小
         */
        private static final int BATTLE_SIZE = 50;
        /**
         * 表示原图偏离基准线的角度
         */
        private static int[] baseAngle = { 270, 225, 0, 0, 0, 180, 0, 15 };
        private double beginningOfLevel = 0.1;
        private int[] battleLocation = new int[2];
        private static int side ;
        
        public BattleAct(GameAct act) {
                this.act = act;
                battleLevel[0] = random.nextInt(act.getNowLevel() + 1) + 1;
                battleLevel[1] = act.getNowLevel();
                battleLocation[0] = random.nextInt(4);
                battleLocation[1] = random.nextInt(4);
                this.side = act.getNearside() ;
        }
        
        
        public void beginBattle(Graphics g,int numOfBattle) {               
                if(act.getPercent() > beginningOfLevel || act.getNowLevel() == 0)
                        return;
                Point point = this.directionToPoint(battleLocation[numOfBattle]);
                g.drawImage(Img.BATTLES.get(battleLevel[numOfBattle]), point.x, point.y,
                                BATTLE_SIZE, BATTLE_SIZE, null);
        }
        
        public void battleMove(Graphics g,int numOfBattle,Point beginning,Point ending) {
                int vectorX = ending.x - beginning.x;
                int vectorY = ending.y - beginning.y;
                Point directionVector = minVector(vectorX, vectorY) ;
                //TODO
//                int tempTimes = 5;
//                for (int i = 1; i <= tempTimes; i++) {
//                        g.drawImage(Img.BATTLES.get(battleLevel[numOfBattle]),
//                                        beginning.x + directionVector.x  , beginning.y + directionVector.y , 
//                                        BATTLE_SIZE, BATTLE_SIZE, null);
//                }
                
        }
        
        private Point minVector(int vectorX,int vectorY){
                double a = vectorX,b = vectorY;
                while(vectorX != vectorY){
                        if(vectorX > vectorY)
                                vectorX = vectorX - vectorY;
                        else
                                vectorY = vectorY - vectorX;
                }
                a /= vectorX;
                b /= vectorX;
                while(a > 5 || b > 5){
                        a -= 1;
                        b -= b/a;            
                }
                return new Point((int)a,(int)b);
        }
        
        public Point directionToPoint(int direction){
                int x1 = this.act.getNearside();
                int x2 = FrameUtil.SCREEN_SIZE.getSize().width
                                - this.act.getNearside() - BATTLE_SIZE;
                int y1 = this.act.getNearside();
                int y2 = FrameUtil.SCREEN_SIZE.getSize().height
                                - this.act.getNearside() - BATTLE_SIZE;
                
                Point[] points = { new Point(x1, y1), new Point(x2, y1),
                                new Point(x1, y2), new Point(x2, y2) };        
                return points[direction];
        }
        
}
