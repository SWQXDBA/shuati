import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.setVisible(true);
        jFrame.setSize(800, 20);
        jFrame.setTitle("登录");
        jFrame.setLocationRelativeTo(null);
        JLabel label = new JLabel("账户");
        label.setFont(new Font("宋体", Font.BOLD, 20));
        jFrame.add(label);
    }
}

