package dto;

import java.awt.Point;

public class Player {
        private String name;
        private int level;
        private double percent ;
        private Point location;
        
        public Player(String name,int level, double percent, Point location){
                this.name = name;
                this.level = level;
                this.location = location;
                this.percent = percent;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public int getLevel() {
                return level;
        }

        public void setLevel(int level) {
                this.level = level;
        }

        public double getPercent() {
                return percent;
        }

        public void setPercent(double percent) {
                this.percent = percent;
        }

        public Point getLocation() {
                return location;
        }

        public void setLocation(Point location) {
                this.location = location;
        }
        
        
}
