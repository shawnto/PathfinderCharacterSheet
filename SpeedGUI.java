import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridLayout;


public class SpeedGUI extends JPanel {
	
	JTextField baseSpeed, wArmor,flyMan,swim,climb,burrow,tempSpeedMods;
	
	JLabel speedLabel;
	
	JPanel speedGUIBase;
	
	public SpeedGUI(){
		
		
		
		baseSpeed = new JTextField();
		wArmor = new JTextField();
		flyMan = new JTextField();
		swim = new JTextField();
		climb = new JTextField();
		burrow = new JTextField();
		
		speedGUIBase = new JPanel();
		
		speedGUIBase.add(baseSpeed);
		speedGUIBase.add(wArmor);
		speedGUIBase.add(flyMan);
		speedGUIBase.add(swim);
		speedGUIBase.add(climb);
		speedGUIBase.add(burrow);
		
		
		add(speedGUIBase);
		
	}

}
