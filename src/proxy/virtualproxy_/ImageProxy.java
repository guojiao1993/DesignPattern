package proxy.virtualproxy_;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageProxy implements Icon {
    ImageIcon imageIcon;
    URL imageURL;
    Thread retrievalThread;
    boolean retrieving = false;

    public ImageProxy(URL imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if(imageIcon != null) {
            imageIcon.paintIcon(c,g,x,y);
        } else {
            g.drawString("加载中，请稍候", (c.getWidth() - 86) / 2, (c.getHeight() - 14) / 2);
            c.repaint();
            if(!retrieving) {
                retrieving = true;
                retrievalThread = new Thread(() -> {
                    ImageProxy.this.imageIcon = new ImageIcon(imageURL, "头像");
                    c.repaint();
                });
                retrievalThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if(imageIcon != null) {
            return imageIcon.getIconWidth();
        }
        return 200;
    }

    @Override
    public int getIconHeight() {
        if(imageIcon != null) {
            return imageIcon.getIconHeight();
        }
        return 200;
    }
}
