import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class SkillsGUI extends JPanel implements ActionListener, PropertyChangeListener{
	
	//String[] skillNames;
	
	
	
	
	
	static int NUM_OF_SKILLS = 41; 
	JCheckBox[] skillsBoxes;
	JLabel[] skillsLabel;
	JPanel skillsBase;
	JScrollPane skillsBar;
	JTextField[] skillsValue;
	JButton[] rollCheck;
	//parrallel array for skill modifiers. 
	//1-strength,2-dex,3-con,4-int,5-wis,6-cha
	int[] modifiers =  {2,4,6,1,4,4,4,6,2,6,2,2,6,5,6,4,4,4,4,4,4,4,4,
			4,4,4,5,6,6,5,5,2,5,2,4,2,5,1,6,0,0};
	
	//needs getters and setters for versatility
	int specialBonus;
	
	String[] skillNames = {"acrobatics", "appraise", "bluff", "climb", "craftOne",
			"craftTwo","craftThree","diplomacy","disableDevice", "disguise"
			,"escapeArtist","fly","handleAnimal","heal","intimidate",
			"knowledgeArcana","knowledgeDung",
			"knowledgeEngineering","knowledgeGeography","knowledgeHistory",
			"knowledgeLocal","knowledgeNature","knowledgeNobility","knowledgePlanes",
			"knowledgeReligion","linguistics","perception","perform1","perform2","profession1",
			"profression2","ride", "senseMotive","sleightOHand","spellCraft",
			"stealth","survival", "swim","useMagDev",
			"classSkill", "trainedOnly"};
	
	CharClass n;
	
	public SkillsGUI(CharClass n){
		this.n = n;
		specialBonus = 3;
		//parallel array for skill modifiers. 
		//1-Strength,2-Dex,3-Con,4-Int,5-Wis,6-Cha
		
		skillsBar = new JScrollPane();
		
		skillsBase = new JPanel();
		
		skillsBase.setLayout(new GridLayout(22,8));
		skillsBoxes = new JCheckBox[NUM_OF_SKILLS];
		skillsValue = new JTextField[NUM_OF_SKILLS];
		rollCheck = new JButton[NUM_OF_SKILLS];
		
		
		for(int i = 0; i < NUM_OF_SKILLS; i++){
			skillsBoxes[i] = new JCheckBox(skillNames[i]);
			skillsBase.add(skillsBoxes[i]);
			skillsBoxes[i].addActionListener(this);
			skillsValue[i] = new JTextField("0",5);
			//skillsBoxes[i].addPropertyChangeListener(this);
			skillsBase.add(skillsValue[i]);
			rollCheck[i] = new JButton("R");
			
			rollCheck[i].addActionListener(this);
			skillsBase.add(rollCheck[i]);
			
			
		}
		
		//skillsBar.setLayout(new GridLayout(41,2));
	  
		skillsBar.add(skillsBase);
		skillsBar.setViewportView(skillsBase);
		skillsBar.createVerticalScrollBar();
		
		add(skillsBar);
		
		
	}

	@Override
	//if R is clicked, pull value, roll d20, and add give result.
	//if Box is checked/uncheck, add/remove specialization modifier.
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < NUM_OF_SKILLS;i++){
			if(e.getSource() == rollCheck[i]){
				String k = "";
				String skillDesc = " ";
				k = skillsValue[i].getText();
				skillDesc += skillNames[i];
				int temp = Integer.parseInt(k);
				DiceRoll n = new DiceRoll(20,temp);
				n.rollDice(skillDesc);
				
				
			}
			else{
				String k = "";
				int temp = 0; //for javac
				
					if(e.getSource() == skillsBoxes[i]){
						if(skillsBoxes[i].isSelected()){
						temp = Integer.parseInt(skillsValue[i].getText());
						temp += specialBonus;
						k = Integer.toString(temp);
						skillsValue[i].setText(k);
						n.setSkill(true,i);
						break;
						}
						else{
							temp = Integer.parseInt(skillsValue[i].getText());
							temp -= specialBonus;
							k = Integer.toString(temp);
							skillsValue[i].setText(k);
							n.setSkill(false, i);
							break;
						
					}
				}
				
				
			}
			
		}
		
		
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		for(int i = 0; i < NUM_OF_SKILLS;i++){
			
			if(evt.getSource() == rollCheck[i]){
				String k = "";
				String skillDesc = " ";
				k = skillsValue[i].getText();
				skillDesc += skillNames[i];
				int temp = Integer.parseInt(k);
				DiceRoll n = new DiceRoll(20,temp);
				n.rollDice(skillDesc);
				
				
			}
			else{
				String k = "";
				int temp = 0; //for javac
				
					if(evt.getSource() == skillsBoxes[i]){
						if(skillsBoxes[i].isSelected()){
						temp = Integer.parseInt(skillsValue[i].getText());
						temp += specialBonus;
						k = Integer.toString(temp);
						skillsValue[i].setText(k);
						n.setSkill(true,i);
						break;
						}
						else{
							temp = Integer.parseInt(skillsValue[i].getText());
							temp -= specialBonus;
							k = Integer.toString(temp);
							skillsValue[i].setText(k);
							n.setSkill(false, i);
							break;
						
					}
				}
				
				
			}
			
		}
		
	}	
	
}

	
	

