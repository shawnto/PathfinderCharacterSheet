import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;


//import FileChooser.SaveL;


public class MainMenu extends JFrame implements ActionListener{

	JFrame base;
	JMenuBar menuBar;
	JMenu fMenu;
	JMenuItem load,save;
	JScrollPane t;
	JTabbedPane tabs;
	JComponent tab1,tab2;
	CharClass n;
	BaseStatsUI b;
	HitPointGUI hitPoints;
	CharInfoGUI charInfo;
	SkillsGUI s;
	static int NUM_OF_SKILLS = 41;
	
	public MainMenu() throws FileNotFoundException, IOException, ClassNotFoundException{
		
		base =  new JFrame("Pathfinder Char Sheet");
		base.setSize(800, 600);
		base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		base.setLayout(new GridLayout(1,2,1,1));
		//t = new JScrollPane();
		JPanel baseRight = new JPanel();
		JPanel baseLeft = new JPanel();
		
		menuBar = new JMenuBar();
		fMenu = new JMenu("File");
		load = new JMenuItem("Load");
		save = new JMenuItem("Save");
		  load.addActionListener(this);
		   // p.add(open);
		    save.addActionListener(this);
		tabs = new JTabbedPane();
		
		fMenu.add(load);
		fMenu.add(save);
		menuBar.add(fMenu);
		base.setJMenuBar(menuBar);
		
		 n = new CharClass(1,1,1,1,1,1);
		s = new SkillsGUI(n);
		hitPoints = new HitPointGUI(n);
		 SurvivalStats ss = new SurvivalStats();
	     b = new BaseStatsUI(n,s,hitPoints);
	    GenericRollsGUI g = new GenericRollsGUI(b);
	    SavingThrowsGUI st = new SavingThrowsGUI(n);
	    SpeedGUI spd = new SpeedGUI();
	    MiscInfoGUI miscInfo = new MiscInfoGUI(n);
	    charInfo = new CharInfoGUI(n,b);
	    JPanel statsTab = new JPanel(new GridLayout(2,1,1,1));
	    JPanel tab1 = new JPanel();
	    Dimension leftPanelDim = new Dimension (675,275);
	    Dimension tab1Dim = new Dimension(25,400);
	   
	    b.setPreferredSize(leftPanelDim);
	    spd.setPreferredSize(leftPanelDim);
	    hitPoints.setPreferredSize(leftPanelDim);
	    charInfo.setPreferredSize(leftPanelDim);
	   // g.setPreferredSize(leftPanelDim);
	   
	   statsTab.add(ss);
	   statsTab.add(st);
	   tab1.add(statsTab);
	   tab1.setPreferredSize(tab1Dim);
	  
	    tabs.addTab("Stats", tab1);
	    tabs.addTab("Skills",s);
	    //tabs.addTab("Misc Rolls", g);
	    tabs.addTab("Other Info", miscInfo);
	    
		baseLeft.add(tabs);
		baseRight.setLayout(new FlowLayout());
		 
		JPanel exPane = new JPanel();
		JPanel exPaneLeft = new JPanel();
		JPanel rightInlay = new JPanel(new GridLayout(4,1,1,1));
		rightInlay.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.WHITE ),"Important Stats"));
		rightInlay.add(charInfo);
		rightInlay.add(g);
		rightInlay.add(hitPoints);
		//rightInlay.add(spd);
		
		rightInlay.add(b);
		
		
		baseRight.add(rightInlay);
		exPane.add(baseRight);
		exPaneLeft.add(baseLeft);
		JScrollPane rightScrollPane = new JScrollPane(exPane);
		JScrollPane leftScrollPane = new JScrollPane(exPaneLeft);
		
		
		base.add(rightScrollPane);
		base.add(leftScrollPane);
		base.pack();
		base.setVisible(true);
		
		
		
		
		
		
		
		
	}
	

public void loadStats() throws AWTException{
	
	b.strength.setText(Integer.toString(n.getStr()));
	b.strength.requestFocusInWindow();
	
	b.dexterity.setText(Integer.toString(n.getDex()));
	
	b.con.setText(Integer.toString(n.getCon()));
	
	b.intellect.setText(Integer.toString(n.getIntel()));
	
	b.wisdom.setText(Integer.toString(n.getIntel()));
	//b.wisdom.requestFocusInWindow();
	//rob.keyPress(KeyEvent.VK_ENTER);
	b.charisma.setText(Integer.toString(n.getCha()));
	//b.charisma.requestFocusInWindow();
	//rob.keyPress(KeyEvent.VK_ENTER);
	hitPoints.HP.setText(Integer.toString(n.hitPoints.getTotalHp()));
	hitPoints.currentHP.setText(Integer.toString(n.hitPoints.getCurrentHP()));
	charInfo.charName.setText(n.getCharName());
	charInfo.charRace.setSelectedIndex(n.getRaceName());
	tabs.setSelectedIndex(1);
	for(int i = 0; i < NUM_OF_SKILLS;i++){
		
		
		s.skillsBoxes[i].setSelected(n.getSkill(i)); 
	
	}
	
	
	
}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == load){
			JFileChooser c = new JFileChooser();
			int rVal = c.showOpenDialog(MainMenu.this);
			if (rVal == JFileChooser.APPROVE_OPTION) {
	    	  @SuppressWarnings("resource")
			ObjectInputStream obIn;
			try {
				obIn = new ObjectInputStream(new FileInputStream(c.getSelectedFile().getName()));
				n = ((CharClass) obIn.readObject());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	try {
				loadStats();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
			
			}
			
			if (rVal == JFileChooser.CANCEL_OPTION) {
		        //filename.setText("You pressed cancel");
		        //dir.setText("");
		      }
		}
			
		if(e.getSource() == save){
			 JFileChooser c = new JFileChooser();
		      // Save Character
		      int rVal = c.showSaveDialog(MainMenu.this);
		      if (rVal == JFileChooser.APPROVE_OPTION) {
		    	  @SuppressWarnings("resource")
				ObjectOutputStream obOut;
				try {
					obOut = new ObjectOutputStream(new FileOutputStream(c.getSelectedFile().getName()));
					obOut.writeObject(n);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	  
		     //   filename.setText(c.getSelectedFile().getName());
		      //  dir.setText(c.getCurrentDirectory().toString());
		      }
		      if (rVal == JFileChooser.CANCEL_OPTION) {
		       
		      }
			
		}
		
	}
}//set Stats when new char is loaded.
		
	
	
	

	
	

