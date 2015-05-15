package entity;

import java.util.Random;

public class BattleAct {
//        private GameAct act;
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
        
        public BattleAct(GameAct act) {
//                this.act = act;
                battleLevel1 = random.nextInt(act.getNowLevel()) + 1;
                battleLevel2 = act.getNowLevel();
        }

        public int getBattleLevel1() {
                return battleLevel1;
        }

        public int getBattleLevel2() {
                return battleLevel2;
        }
        
}
