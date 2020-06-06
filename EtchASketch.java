import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class EtchASketch extends Canvas {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    int x, y;
    Color cur;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Use the arrow keys!");
        frame.setSize(1024, 768);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new EtchASketch());
        frame.setVisible(true);
    }

    public EtchASketch() {
        enableEvents(java.awt.AWTEvent.KEY_EVENT_MASK);
        requestFocus();
        x = 500;
        y = 400;
        cur = Color.black;
    }

    public void paint(Graphics g) {
        g.setColor(cur);
        g.fillOval(x, y, 25, 25);
    }

    public void update(Graphics g) {
        paint(g);
    }

    public void processKeyEvent(KeyEvent e) {
        // this method automatically gets called with they press a key
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_UP)
                y -= 10;
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                y += 10;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                x += 10;
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
                x -= 10;

            // and we manually call paint() again to redraw
            repaint();
        }

        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_F1)
                cur = Color.red;
            if (e.getKeyCode() == KeyEvent.VK_F2)
                cur = Color.green;
            if (e.getKeyCode() == KeyEvent.VK_F3)
                cur = Color.blue;
            if (e.getKeyCode() == KeyEvent.VK_F5)
                cur = Color.black;
        }

    }

    public boolean isFocusable() {
        return true;
    }
}