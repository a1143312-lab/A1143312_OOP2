import javax.swing.*;
import java.awt.*;

public class Exercise1{
    static JFrame frm =new JFrame("骰子模擬器");
    static JPanel panel=new JPanel();
    static JLabel labelUp=new JLabel("已擲 N 次,總和 M,平均X.XX",JLabel.CENTER);
    static JLabel labelCenter=new JLabel("目前點數:",JLabel.CENTER);
    static JButton button=new JButton("擲骰子");

    public static void main(String args[]){
        
        BorderLayout border=new BorderLayout();
        frm.setLayout(border);
        frm.setSize(400,320);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelUp.setFont(new Font("微軟正黑體",Font.BOLD,30));
        frm.add(labelUp,BorderLayout.NORTH);
        
        labelCenter.setFont(new Font("微軟正黑體",Font.BOLD,60));
        frm.add(labelCenter,BorderLayout.CENTER);

        button.setFont(new Font("微軟正黑體",Font.BOLD,20));
        panel.add(button,BorderLayout.CENTER);
        frm.add(panel,BorderLayout.SOUTH);


        frm.setVisible(true);

    }
}
