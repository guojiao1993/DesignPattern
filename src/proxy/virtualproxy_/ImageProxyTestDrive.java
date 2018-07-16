package proxy.virtualproxy_;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ImageProxyTestDrive {
    JFrame frame = new JFrame("网易云音乐");
    ImageComponent imageComponent;
    JMenuBar menuBar;
    JMenu menu;
    Map<String ,String> cds = new HashMap<String, String>();

    public ImageProxyTestDrive() throws Exception {
        cds.put("冯提莫", "http://p1.music.126.net/34Yh1_tFVfUsngtUoi1T-A==/19006157998131408.jpg?param=180y180");
        cds.put("陈一发儿", "http://p1.music.126.net/3aBS-5MbmtCR4Ax0MbTm9w==/109951163032972993.jpg?param=180y180");
        cds.put("花粥", "http://p2.music.126.net/eD690wKbHxUckzgt4Svpvg==/19019352137706499.jpg?param=180y180");
        cds.put("大图", "http://pic67.nipic.com/file/20150522/21011915_190723147712_2.jpg");
        menu = new JMenu("音乐人");
        Iterator<Map.Entry<String, String>> iterator = cds.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            JMenuItem menuItem = new JMenuItem(next.getKey());
            menu.add(menuItem);
            menuItem.addActionListener((e) -> {
                URL url = null;
                try {
                    url = new URL(cds.get(e.getActionCommand()));
                } catch (MalformedURLException e1) {
                    e1.printStackTrace();
                }
                imageComponent.setIcon(new ImageProxy(url));
            });
        }
        menuBar = new JMenuBar();
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        imageComponent = new ImageComponent(new ImageProxy(new URL(cds.get("花粥"))));
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(533,234,300,300);
        frame.setResizable(false);
        frame.validate();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new ImageProxyTestDrive();
    }
}
