package yzbtest.date20200105.PlayGameyzb;
 
import java.awt.Graphics;
import java.awt.Image;
 
/*
 * 爆炸类
 */
public class Explode {
    double x,y;
    static Image[] imgs = new Image[16];
    static {
        for(int i=0;i<16;i++){
            imgs[i] = GameUtil.getImage("explode/e" +(i+1)+".gif");
            imgs[i].getWidth(null);
        }
    }
     
    int count;
     
    public void draw(Graphics g){
        if(count<=15){
            g.drawImage(imgs[count], (int)x, (int)y, null);
            count++;
            if(count==15){
                count=0;
            }
        }
    }
     
    public Explode(double x,double y){
        this.x = x;
        this.y = y;
    }
}