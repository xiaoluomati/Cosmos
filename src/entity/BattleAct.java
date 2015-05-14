package entity;

import java.util.Random;

public class BattleAct {
        private GameAct act;
        /**
         * 第一次攻击的的等级（随机）
         */
        private int battleLevel1;
        /**
         * 第二次攻击的的等级（由现在文明等级确定）
         */
        private int battleLevel2;
        /**
         * 随机数生成器
         */
        private Random random = new Random();
        private int direction;
        
        public BattleAct(GameAct act) {
                this.act = act;
                this.battleLevel1 = random.nextInt(act.getNowLevel()) + 1;
                this.battleLevel2 = act.getNowLevel();
                this.direction = random.nextInt(4);
        }

        public void beginBattle() {
                //表示进度条小于该值时认为其在发展初期
                double beginningOfALevel = 0.1;
                if(this.act.getPercent() > beginningOfALevel || this.act.getNowLevel() == 0)
                        return;
                
        }
        
        public int getBattleLevel1() {
                return battleLevel1;
        }

        public int getBattleLevel2() {
                return battleLevel2;
        }
        
}