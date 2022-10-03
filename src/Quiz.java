import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Quiz implements ActionListener {
    //array of questions
    String[] questions ={
            "How would you describe yourself?",
            "What's your favorite color",
            "If you had to pick a career what would it be? ",
            "If you need help solving a problem who do you go to?"
    };

    //stores all possible answers (array of arrays)

    String [][] options ={
            {"Creative","Logical","Wise","Empathetic"},
            {"Orange","Blue","Red","Green"},
            {"Artist","Mathmatetician","Politics","Sports Coach"},
            {"Coworker or Supervisor","Google","Stack Overflow","All of the above"}

    };
    //skipped on guess and correct guess because we are not measuring that way see video at 12:24
    char answer;
    int index;
    int total_questions=questions.length;
    int result;
    //to keep count of how many times their answer corresponded with a personality type
    int a=0;
    int b=0;
    int c=0;
    int d=0;

    //GUI
    JFrame frame = new JFrame();

    //text
    JTextField textfield = new JTextField();
    JTextArea textarea= new JTextArea();
    //buttons
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    //answer labels
    JLabel answer_labelA=new JLabel ();
    JLabel answer_labelB=new JLabel ();
    JLabel answer_labelC=new JLabel ();
    JLabel answer_labelD=new JLabel ();
    //category selection
    // JLabel numberA=newJ

    JTextField percentage = new JTextField ();


    //create constructor
    public Quiz(){
        //frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(255,182,193));
        frame.setLayout(null);

        frame.add(textfield);
        frame.add(textarea);

        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);

        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);

//    frame.add(percentage);

//text fields
        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(127, 255, 212));
        textfield.setForeground(new Color(8, 143, 143));
        textfield.setFont(new Font("Ink Free",Font.PLAIN,30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
        textfield.setText("What Kind of Techie Are you??");

//text area
        textarea.setBounds(0,50,650,50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(127, 255, 212));
        textarea.setForeground(new Color(8, 143, 143));
        textarea.setFont(new Font("Ink Free",Font.PLAIN,25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        textarea.setText("Sample Text");

        //buttons
        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("Ink Free",Font.PLAIN,25));
        buttonA.setFocusable(true);
        buttonA.addActionListener(this);
        buttonA.setText("A");
//FOR EACH BUTTON CHANGE Y AXIS BY 100 PX SO ITS NOT ONTOP OF EACHOTHER
        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("Ink Free",Font.PLAIN,25));
        buttonB.setFocusable(true);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("Ink Free",Font.PLAIN,25));
        buttonC.setFocusable(true);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("Ink Free",Font.PLAIN,25));
        buttonD.setFocusable(true);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        //ANSWER LABELS
        answer_labelA.setBounds(125,100,500,100);
        answer_labelA.setBackground(new Color(255,182,193));
        answer_labelA.setForeground(new Color(255,255,255));
        answer_labelA.setFont(new Font("Ink Well",Font.PLAIN,25));
//        answer_labelA.setText("TESTING");
//DONT FORGET TO MOVE DOWN BY 100PX ON Y AXIS
        answer_labelB.setBounds(125,200,500,100);
        answer_labelB.setBackground(new Color(255,182,193));
        answer_labelB.setForeground(new Color(255,255,255));
        answer_labelB.setFont(new Font("Ink Well",Font.PLAIN,25));
//        answer_labelB.setText("TESTING");

        answer_labelC.setBounds(125,300,500,100);
        answer_labelC.setBackground(new Color(255,182,193));
        answer_labelC.setForeground(new Color(255,255,255));
        answer_labelC.setFont(new Font("Ink Well",Font.PLAIN,25));
//        answer_labelC.setText("TESTING");

        answer_labelD.setBounds(125,400,500,100);
        answer_labelD.setBackground(new Color(255,182,193));
        answer_labelD.setForeground(new Color(255,255,255));
        answer_labelD.setFont(new Font("Ink Well",Font.PLAIN,25));
//        answer_labelD.setText("TESTING ");
        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(255,255,255));
        percentage.setForeground(new Color(255,255,255));
        percentage.setFont(new Font("Ink Well",Font.PLAIN,25));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);
        //call this method to begin quiz
        nextQuestion();


    }

    //method to go to next question
    public void nextQuestion(){
        if(index>=total_questions){
            results();
        }else{
            textfield.setText("Question" + (index+1));
            //displays question being asked
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
        }

    }
    // triggers when button clicking
    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            a += 1;
        } else if (e.getSource() == buttonB) {
            b += 1;
        } else if (e.getSource() == buttonC) {
            c += 1;
        } else if (e.getSource() == buttonC) {
            c += 1;
        }

        //to go to next q increase index
        buttonA.setEnabled(true);
        buttonB.setEnabled(true);
        buttonC.setEnabled(true);
        buttonD.setEnabled(true);
        index++;
        nextQuestion();
    }

    //display results
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        //Make function to see which category has most of the answers
        int max1=Math.max(a,b);
        int max2=Math.max(c,d);
        int finalResult=Math.max(max1,max2);

        if(finalResult==a){
            System.out.println("You have a more creative personality type");
        }else if(finalResult==b){
            System.out.println("You have a logical personality type");
        }else if(finalResult==c){
            System.out.println("You have a wise personality type");
        }else{
            System.out.println("You have a emphatitic poerosality type"  );
        }


    }
}
