import java.util.*;
import java.awt.event.*;
import javax.swing.*;

class EmptyyException extends Exception 
{
    public EmptyyException(String s) 
	{
        super(s);
    }
}

class Human 
{
    String Name;
    int count;
    int id;
    
    Human() 
	{
        Name = null;
        count = 0;
        id = 0;
    }
    
    Human(String Name, int count, int id) 
	{
        this.Name = Name;
        this.count = count;
        this.id = id;
    }
}

class Goalkeeper extends Human 
{
    int Total_stopping_shots;
    int stoprate;
    
    public Goalkeeper(int Total_stopping_shots) 
	{
        this.Total_stopping_shots = Total_stopping_shots;
        stoprate = Total_stopping_shots / count;
    }
    
    public Goalkeeper(int Total_stopping_shots, int stoprate) 
	{
        this.Total_stopping_shots = Total_stopping_shots;
        this.stoprate = stoprate;
    }
    
    public Goalkeeper(String Name, int count, int id, int Total_stopping_shots) 
	{
        this.Name = Name;
        this.count = count;
        this.id = id;
        this.Total_stopping_shots = Total_stopping_shots;
        stoprate = Total_stopping_shots / count;
    }
    
    public Goalkeeper(String Name, int count, int id, int Total_stopping_shots, int stoprate) 
	{
        this.Name = Name;
        this.count = count;
        this.id = id;
        this.Total_stopping_shots = Total_stopping_shots;
        this.stoprate = stoprate;
    }
}

class FieldPlayer extends Human 
{
    int goal_count;
    
    public FieldPlayer(int goal_count) 
	{
        this.goal_count = goal_count;
    }
    
    public FieldPlayer(String Name, int count, int id, int goal_count) 
	{
        this.Name = Name;
        this.count = count;
        this.id = id;
        this.goal_count = goal_count;
    }
}

class Empty1Exception extends Exception 
{
    public Empty1Exception() 
	{
        super();
    }
    
    public Empty1Exception(String st) 
	{
        super(st);
    }
}

public class FDB implements ActionListener 
{
    ArrayList<FieldPlayer> Arraylist1;
    ArrayList<Goalkeeper> Arraylist2;

    Scanner sc;

    int pos, tpos;
    int fpnum, gknum, fppos, gkpos;
    FieldPlayer fp;
    Goalkeeper gk;
    int tnum;

    JFrame f;
    JLabel l1, l2, l3, l4, l5;
    JRadioButton rb1, rb2;
    JTextField t1, t2, t3, t4;
    JTextArea ta;
    ButtonGroup bg;
    JButton b1, b2, b3, b4, b5, b6, b7;

    public DB() 
	{
        f = new JFrame("Foodball Board Details");
        bg = new ButtonGroup();
        rb1 = new JRadioButton("FieldPlayer");
        rb1.setBounds(20, 30, 60, 30);
        rb2 = new JRadioButton("Goalie");
        rb2.setBounds(80, 30, 60, 30);
        bg.add(rb1);
        bg.add(rb2);
        f.add(rb1);
        f.add(rb2);

        l1 = new JLabel("Name");
        l1.setBounds(20, 60, 40, 30);
        f.add(l1);
        t1 = new JTextField();
        t1.setBounds(60, 60, 50, 30);
        f.add(t1);

        l2 = new JLabel("ID");
        l2.setBounds(20, 90, 40, 30);
        f.add(l2);
        t2 = new JTextField();
        t2.setBounds(60, 90, 50, 30);
        f.add(t2);

        l3 = new JLabel("Count");
        l3.setBounds(20, 120, 40, 30);
        f.add(l3);
        t3 = new JTextField();
        t3.setBounds(60, 120, 50, 30);
        f.add(t3);

        l4 = new JLabel("Stopp/Goal Count");
        l4.setBounds(20, 150, 40, 30);
        f.add(l4);
        t4 = new JTextField();
        t4.setBounds(60, 150, 50, 30);
        f.add(t4);

        l5 = new JLabel("Player Details");
        l5.setBounds(20, 200, 40, 30);
        f.add(l1);
        ta = new JTextArea();
        ta.setBounds(30, 240, 60, 60);
        f.add(ta);
        b1 = new JButton("Insert");
        b1.setBounds(20, 350, 80, 30);
        f.add(b1);
        b2 = new JButton("Search");
        b2.setBounds(100, 350, 80, 30);
        f.add(b2);
        b3 = new JButton("BestPlayer");
        b3.setBounds(180, 350, 80, 30);
        f.add(b3);
        b4 = new JButton("<<");
        b4.setBounds(260, 350, 50, 30);
        f.add(b4);
        b5 = new JButton("<");
        b5.setBounds(310, 350, 50, 30);
        f.add(b5);
        b6 = new JButton(">");
        b6.setBounds(360, 350, 50, 30);
        f.add(b6);
        b7 = new JButton(">>");
        b7.setBounds(410, 350, 50, 30);
        f.add(b7);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);
    }

    void Insert(JRadioButton rb) 
	{
        pos++;
        tnum++;
        String t1s = t1.getText();
        int t2n = Integer.parseInt(t2.getText());
        int t3n = Integer.parseInt(t3.getText());
        int t4n = Integer.parseInt(t4.getText());
        
        if (rb.getText() == "FieldPlayer") 
		{
            fpnum++;
            fp = new FieldPlayer(t1s, t2n, t3n, t4n);
            Arraylist1.add(fp);
        } else if (rb.getText() == "Goalie") 
		{
            gknum++;
            gk = new Goalkeeper(t1s, t2n, t3n, t4n);
            Arraylist2.add(gk);
        }
    }

    void Search() 
	{
        int flag = 0;
        int t2n = Integer.parseInt(t1.getText());
        ta.setText("Student Information");
        
        for (int i = 0; i <= fppos; i++) 
		{
            fp = Arraylist1.get(i);
            if (fp.id == t2n) 
			{
                ta.append("Name: " + fp.Name + "\nID: " + fp.id + "\nCount: " + fp.count + "GoalCount: " + fp.goal_count);
                pos = i;
                flag = 1;
            }
        }
        
        for (int j = 0; j <= fppos; j++) 
		{
            gk = Arraylist2.get(j);
            if (gk.id == t2n) 
			{
                ta.append("Name: " + gk.Name + "\nID: " + gk.id + "\nStoppingshots: " + gk.Total_stopping_shots + "Stoprate: " + gk.stoprate);
                pos = j;
                flag = 1;
            }
        }
        
        if (flag == 0) 
		{
            ta.setText("No StudentData Found");
        }
    }

    void BestPlayer() 
	{
        int c = Integer.parseInt(t3.getText());
        int bp1 = 0, bp2 = 0;
        int flag1, flag2;
        ta.setText("Best Player");
        
        for (int i = 0; i <= fpnum; i++) 
		{
            fp = Arraylist1.get(i);
            if (bp1 < fp.count) 
			{
                bp1 = fp.count;
                flag1 = i;
                fppos = i;
            }
        }
        ta.append("Best Field Player\n");
        if (Arraylist1 != null && !Arraylist1.isEmpty()) 
		{
            fp = Arraylist1.get(fppos);
            ta.append("Name: " + fp.Name + "\nID: " + fp.id + "\nCount: " + fp.count + " GoalCount: " + fp.goal_count + "\n");
        }

        for (int i = 0; i <= gknum; i++) 
		{
            gk = Arraylist2.get(i);
            if (bp2 < gk.stoprate) 
			{
                bp2 = gk.stoprate;
                flag2 = i;
                gkpos = i;
            }
        }
        ta.append("\nBest Goalie\n");
        if (Arraylist2 != null && !Arraylist2.isEmpty()) 
		{
            gk = Arraylist2.get(gkpos);
            ta.append("Name: " + gk.Name + "\nID: " + gk.id + "\nStoppingshots: " + gk.Total_stopping_shots + " Stoprate: " + gk.stoprate + "\n");
        }
    }

    void displayfirst() 
	{
        fppos = 0;
        if (Arraylist1 != null && !Arraylist1.isEmpty()) 
		{
            fp = Arraylist1.get(0);
            ta.setText("Field Player Details\n");
            ta.append("Name: " + fp.Name + "\nID: " + fp.id + "\nCount: " + fp.count + " GoalCount: " + fp.goal_count + "\n");
        }
    }

    void displaypre() 
	{
        fppos--;
        if (fppos < 0) 
		{
            fppos = 0;
        }
        if (Arraylist1 != null && !Arraylist1.isEmpty()) 
		{
            fp = Arraylist1.get(fppos);
            ta.setText("Field Player Details\n");
            ta.append("Name: " + fp.Name + "\nID: " + fp.id + "\nCount: " + fp.count + " GoalCount: " + fp.goal_count + "\n");
        }
    }

    void displaynext() 
	{
        fppos++;
        if (Arraylist1 == null || Arraylist1.isEmpty()) return;
        if (fppos >= Arraylist1.size()) 
		{
            fppos = 0;
        }
        fp = Arraylist1.get(fppos);
        ta.setText("Field Player Details\n");
        ta.append("Name: " + fp.Name + "\nID: " + fp.id + "\nCount: " + fp.count + " GoalCount: " + fp.goal_count + "\n");
    }

    void displaylast() 
	{
        if (Arraylist1 != null && !Arraylist1.isEmpty()) 
		{
            fppos = Arraylist1.size() - 1;
            fp = Arraylist1.get(fppos);
            ta.setText("Field Player Details\n");
            ta.append("Name: " + fp.Name + "\nID: " + fp.id + "\nCount: " + fp.count + " GoalCount: " + fp.goal_count + "\n");
        }
    }

    public void actionPerformed(ActionEvent e) 
	{
        if (e.getSource() == b1) 
		{
            try {
                if ((!t1.getText().isEmpty()) && (!t2.getText().isEmpty()) && (!t3.getText().isEmpty()) && (!t4.getText().isEmpty())) {
                    if (rb1.isSelected()) 
					{
                        Insert(rb1);
                    } else if (rb2.isSelected()) 
					{
                        Insert(rb2);
                    }
                } 
				else 
				{
                    throw new EmptyyException("Empty");
                }
            } 
			catch (EmptyyException ey) 
			{
                ta.append("ERROR: Exception Occurred\n");
            }
        }

        if (e.getSource() == b2) 
		{
            Search();
        }
        if (e.getSource() == b3) 
		{
            BestPlayer();
        }
        if (e.getSource() == b4) 
		{
            displayfirst();
        }
        if (e.getSource() == b5) 
		{
            displaypre();
        }
        if (e.getSource() == b6) 
		{
            displaynext();
        }
        if (e.getSource() == b7) 
		{
            displaylast();
        }
    }

    public static void main(String[] args) 
	{
        DB db = new DB();
    }
}
