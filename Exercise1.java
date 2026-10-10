import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Exercise1{
    static JFrame frm =new JFrame("骰子模擬器");
    static JPanel panel=new JPanel();
    static JLabel labelUp=new JLabel("已擲 N 次,總和 M,平均X.XX",JLabel.CENTER);
    static JLabel labelCenter=new JLabel("目前點數:",JLabel.CENTER);
    static JButton button=new JButton("擲骰子");
    static int dice=0;
    static int count=0;
    static float sum=0;
    static float avg=0;

    public static void main(String args[]){

        BorderLayout border=new BorderLayout();
        frm.setLayout(border);
        frm.setSize(400,320);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelUp.setFont(new Font("微軟正黑體",Font.BOLD,25));
        frm.add(labelUp,BorderLayout.NORTH);
        
        labelCenter.setFont(new Font("微軟正黑體",Font.BOLD,60));
        frm.add(labelCenter,BorderLayout.CENTER);

        button.setFont(new Font("微軟正黑體",Font.BOLD,20));
        panel.add(button,BorderLayout.CENTER);
        button.addActionListener(new Dice());

        frm.add(panel,BorderLayout.SOUTH);


        frm.setVisible(true);

    }

    static class Dice implements ActionListener{
        Random random=new Random();
        public void actionPerformed(ActionEvent e){
            dice=random.nextInt(6)+1;
            count++;
            sum+=dice;
            avg=sum/count;
            
            if(dice==6){
                labelUp.setForeground(Color.GREEN);
            }
            else if(dice==1){
                labelUp.setForeground(Color.RED);
            }
            else{
                labelUp.setForeground(Color.BLACK);
            }

            labelUp.setText("已擲"+count+"次,總和:"+sum+",平均:"+String.format("%.2f",avg));
            labelCenter.setText("目前點數:"+dice);
        }
    } 
}
