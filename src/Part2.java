import java.io.*;
import java.awt.*;
import java.awt.event.*;
public class Part2 extends Frame{
    Button b1 = new Button("Сохранить данные анкеты"); //1
    Choice ch1=new Choice(); //2
    TextField tf1 = new TextField(); //3
    Label label0 = new Label("Анкета 'О вреде курения' "); //описания
    Label label1 = new Label("Введите вашу фамилию и имя:");
    Label label2 = new Label("Как вы относитесь к курению?");
    Label label3 = new Label("Занесение ФИО в файл");
    List l1 = new List(); //4
    public Part2(){
        setLayout(null);
        setSize(600,675);
        setTitle("Анкета");
        setBackground(new Color(82, 204, 204));
        add(b1);
        b1.setBounds(210,625,180,25);
        b1.setForeground(Color.black);
        b1.setBackground(new Color(0, 252, 252));
        add(ch1);
        add(label0);
        label0.setBounds(200,35,200,20);
        add(label1);
        label1.setBounds(25,55,200,20);
        add(tf1);
        tf1.setBounds(25,75,180,20);
        add(label2);
        label2.setBounds(25,115,200,20);
        ch1.setBounds(25,135,180,20);
        ch1.add("Выберите вариант");
        ch1.add("Положительно");
        ch1.add("Отрицательно");
        ch1.add("Отношусь");
        add(label3);
        label3.setBounds(25,225,200,20);
        add(l1);
        l1.setBackground(Color.white);
        l1.setBounds(25,245,180,200);
        addWindowListener(new WindowClose());
        b1.addActionListener(new ButtonAdd());
    }
    class WindowClose extends WindowAdapter {
        public void windowClosing(WindowEvent we) {setVisible(false);}
    }
    class ButtonAdd implements ActionListener {
        int a = 0;
        public void actionPerformed(ActionEvent event) {
            if (a == 0){
                l1.add(tf1.getText(),1);
                a = 1;
                File myFile = new File("myfile.txt");
                FileOutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(myFile);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                byte[] buffer = tf1.getText().getBytes();
                try {
                    outputStream.write(buffer);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static public void main(String args[]){
        Part2 MyFrame=new Part2();
        MyFrame.setVisible(true);
    }
}
