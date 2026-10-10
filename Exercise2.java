import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercise2 {
    static JFrame frm=new JFrame("單位換算器");
    static JPanel pan1=new JPanel();
    static JPanel pan2=new JPanel(new GridLayout(2,1,5,5));
    static JPanel pan2_1=new JPanel();
    static JPanel pan2_2=new JPanel();
    static JPanel pan3=new JPanel();
    static JComboBox<String> cob=new JComboBox<>(new String[]{"長度","重量","溫度"});
    static JTextField tf1=new JTextField(10);//10指的是能放進多少字
    static JTextField tf2=new JTextField(10);
    static JComboBox<String> cob1=new JComboBox<>();
    static JComboBox<String> cob2=new JComboBox<>();
    static JButton btn=new JButton("點我換算");

    public static void main(String[] args){
        BorderLayout BorderLayout=new BorderLayout();
        frm.setLayout(BorderLayout);
        frm.setSize(480,280);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] length={"公尺","公分","英吋","英尺"};
        String[] weight={"公斤","公克","磅","盎司"};
        String[] temp={"攝氏","華氏","克氏"};
        
        //把介面設成三個panel分別上中下，中間的再分成兩個，一上一下
        pan1.add(cob);
        frm.add(pan1,BorderLayout.NORTH);
        pan2_1.add(tf1);
        pan2_1.add(cob1);
        tf2.setEditable(false);//唯讀
        pan2_2.add(tf2);
        pan2_2.add(cob2);
        pan2.add(pan2_1);
        pan2.add(pan2_2);
        frm.add(pan2,BorderLayout.CENTER);
        pan3.add(btn);
        frm.add(pan3,BorderLayout.SOUTH);

        cob.addActionListener(e ->{//用來監聽使用者有沒有切換單位，處理切換時要做甚麼
            String selectedtype =(String) cob.getSelectedItem();//去抓取目前被選中的選項，把它轉成字串
            DefaultComboBoxModel<String> sormodel;//宣告一個管理選單資料的類別變數，並規定裡面只能裝字串
            DefaultComboBoxModel<String> tarmodel;
            
            if("長度".equals(selectedtype)){
                sormodel=new DefaultComboBoxModel<>(length);//<>的意思是泛型
                tarmodel=new DefaultComboBoxModel<>(length);
            }
            else if("重量".equals(selectedtype)){
                sormodel=new DefaultComboBoxModel<>(weight);
                tarmodel=new DefaultComboBoxModel<>(weight);
            }
            else{
                sormodel= new DefaultComboBoxModel<>(temp);
                tarmodel=new DefaultComboBoxModel<>(temp);
            }

            cob1.setModel(sormodel);//更新下方兩個選單的單位
            cob2.setModel(tarmodel);
        });

        cob.setSelectedIndex(0);//程式剛啟動先手動觸發一次讓下方單位有預設值

        btn.addActionListener(e ->{
            try{
                double input=Double.parseDouble(tf1.getText());//抓取使用者在tf1裡面打的字，再將其轉為Double型態以做計算

                //取得目前選擇的類型和來源單位、目標單位
                String type=(String)cob.getSelectedItem();
                String from=(String)cob1.getSelectedItem();
                String to=(String)cob2.getSelectedItem();

                double result=0;
                double valueInM=0;
                double valueInKg=0;
                double valueInC=0;

                if("長度".equals(type)){//先全部換成公尺再轉
                    if("公尺".equals(from)){
                        valueInM=input;
                    }
                    else if("公分".equals(from)){
                        valueInM=input/100.0;
                    }
                     else if("英吋".equals(from)){
                        valueInM=input*0.0254;
                    }
                     else if("英尺".equals(from)){
                        valueInM=input*0.3048;
                    }
                
                if("公尺".equals(to)){
                    result=valueInM;
                }
                else if("公分".equals(to)){
                    result=valueInM*100.0;
                }
                else if("英吋".equals(to)){
                    result=valueInM/0.0254;
                }
                else if("英尺".equals(to)){
                    result=valueInM/0.3048;
                }
                
             } else if("重量".equals(type)){//先全部換成公斤再轉
                if("公斤".equals(from)){
                        valueInKg=input;
                    }
                    else if("公克".equals(from)){
                        valueInKg=input/1000.0;
                    }
                     else if("磅".equals(from)){
                        valueInKg=input*0.45359;
                    }
                     else if("盎司".equals(from)){
                        valueInKg=input*0.02835;
                    }
                    
                if("公斤".equals(to)){
                    result=valueInKg;
                }
                else if("公克".equals(to)){
                    result=valueInKg*1000.0;
                }
                else if("磅".equals(to)){
                    result=valueInKg/0.45359;
                }
                else if("盎司".equals(to)){
                    result=valueInKg/0.02835;
                }
             }else if("溫度".equals(type)){//先全部換成攝氏再轉
                if("攝氏".equals(from)){
                        valueInC=input;
                    }
                    else if("華氏".equals(from)){
                        valueInC=(input-32)*(5.0/9.0);
                    }
                     else if("克氏".equals(from)){
                        valueInC=input-273.15;
                    }
                     
                if("攝氏".equals(to)){
                    result=valueInC;
                }
                else if("華氏".equals(to)){
                    result=valueInC*(9.0/5.0)+32;
                }
                else if("克氏".equals(to)){
                    result=valueInC+273.15;
                }
            }    
            
            tf2.setText(String.format("%.2f",result));//tf2印出字串答案
            }catch(NumberFormatException ex){//抓錯
                tf2.setText("請輸入有效數字!");
            }
        });

        frm.setVisible(true);
    }

}
