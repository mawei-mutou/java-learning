package date20200104.playgame03;

import java.awt.*;

/**
 * created with IntelliJ IDEA
 * author      : YaoDong
 * date        : 2020/1/4
 * time        : 22:17
 * description :
 */
public class Plane extends GameObject {

    public void drawSelf(Graphics g) {
        g.drawImage(img, (int) x, (int) y, null);
        x++;
    }

    public Plane(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }


}
