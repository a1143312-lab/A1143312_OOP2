import javax.swing.*;
import java.awt.*;

public class GoodLogin extends JFrame {
    
    public GoodLogin() {
        setTitle("登入");
        setSize(300, 200);
        
        // 修正 2: 移除 null layout，改用 FlowLayout 讓元件自動排列，避免畫面空白
        setLayout(new FlowLayout());

        JLabel l1 = new JLabel("帳號:");
        // 設定輸入框寬度，否則在 FlowLayout 下會縮成一團
        JTextField t1 = new JTextField(15); 
        
        JLabel l2 = new JLabel("密碼:");
        // 建議: 將 JTextField 改為 JPasswordField 來隱藏密碼字元
        JPasswordField t2 = new JPasswordField(15); 
        
        JButton btn = new JButton("登入");

        add(l1); 
        add(t1); 
        add(l2); 
        add(t2); 
        add(btn);

        btn.addActionListener(e -> {
            // 修正 1: 使用 .equals() 來比較字串內容
            String password = new String(t2.getPassword());
            if ("admin".equals(t1.getText()) && "".equals(password)) {
                System.out.println("登入成功");
            } else {
                System.out.println("登入失敗");
            }
        });

        // 修正 3: 將 setVisible 移到所有元件都 add 完畢的最後一步
        setVisible(true);
    }

    public static void main(String[] a) { 
        new GoodLogin(); 
    }
}