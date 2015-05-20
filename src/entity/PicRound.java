package entity;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class PicRound {
        
        private PicRound(){          
        }
        
        public static BufferedImage picRound (BufferedImage bufferedImage, int angle){
                double radian = angle * Math.PI / 180;
                return picRound(bufferedImage, radian);
        }
        public static BufferedImage picRound (BufferedImage bufferedImage, double radian){
                final int CENTER_X = bufferedImage.getWidth() / 2;
                final int CENTER_Y = bufferedImage.getHeight() / 2;
                
                BufferedImage newBufferedImage = new BufferedImage(                             
                                bufferedImage.getWidth() << 1,
                                bufferedImage.getHeight() << 1,
                                bufferedImage.getType());
                
                for (int i = 0; i < (CENTER_X << 1); i++) {
                        for (int j = 0; j < (CENTER_Y << 1); j++) {
                                Point resPoint = transPoint(i, j, CENTER_X,
                                                CENTER_Y, radian);
                                newBufferedImage.setRGB(resPoint.x
                                                + (CENTER_X >> 1), resPoint.y
                                                + (CENTER_Y >> 1),
                                                bufferedImage.getRGB(i, j));
                        }
                }
                return newBufferedImage;                
        }
        private static Point transPoint(int x,int y,int centerX,int centerY,double radian) {
                int newX = x - centerX;
                int newY = y - centerY;
                double cosRad = Math.cos(radian);
                double sinRad = Math.sin(radian);                
                int resultX = (int) (newX * cosRad - newY * sinRad + 0.5);
                int resultY = (int) (newX * sinRad + newY * cosRad+ 0.5);
                
                return new Point(resultX + centerX ,resultY + centerY);
        }
}
