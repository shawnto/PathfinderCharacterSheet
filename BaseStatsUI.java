import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.EventListener;

import javax.swing.*;



public class BaseStatsUI extends JPanel implements ActionListener, PropertyChangeListener{

	//int[] dummieStats = new int[6];
	JPanel basePanel;
	JTextField strength,dexterity,con,intellect, wisdom, charisma;
	JTextField strMod, dexMod,conMod,intMod,wisMod,charMod;
	JLabel strLab,dexLab,conLab,intLab,wisLab,charLab,stats,modifiers,empty;
	
	
	CharClass n;
	SkillsGUI sg;
	HitPointGUI hpGUI;
	SavingThrowsGUI st;
	public BaseStatsUI(CharClass n,SkillsGUI sg,HitPointGUI hpGui){
		 DiceGUI d = new DiceGUI(n);
		 this.n = n;
		 this.st = st;
		this.hpGUI = hpGUI;
		this.sg = sg;
		strength = new JTextField(Integer.toString(n.getStr()));
		strength.addActionListener(this);
		strength.addPropertyChangeListener(this);
		dexterity = new JTextField(Integer.toString(n.getDex()));
		dexterity.addActionListener(this);
		dexterity.addPropertyChangeListener(this);
		con  = new JTextField(Integer.toString(n.getCon()));
		con.addActionListener(this);
		intellect = new JTextField(Integer.toString(n.getIntel()));
		intellect.addActionListener(this);
		wisdom = new JTextField(Integer.toString(n.getWis()));
		wisdom.addActionListener(this);
		charisma = new JTextField(Integer.toString(n.getCha()));
		charisma.addActionListener(this);
		strMod = new JTextField("0");
		strMod.addActionListener(this);
		
		dexMod = new JTextField("0");
		dexMod.addActionListener(this);
		
		conMod = new JTextField("0");
		conMod.addActionListener(this);
		intMod = new JTextField("0");
		intMod.addActionListener(this);
		wisMod = new JTextField("0");
		wisMod.addActionListener(this);
		charMod = new JTextField("0");
		charMod.addActionListener(this);
		strLab = new JLabel("Strength");
		dexLab = new JLabel("Dex");
		conLab = new JLabel("Con");
		intLab = new JLabel("int");
		wisLab = new JLabel("wis");
		charLab = new JLabel("char");
		stats = new JLabel("  Stats");
		modifiers = new JLabel("  Modifiers");
		empty = new JLabel();
		
		
		
		basePanel = new JPanel();
		basePanel.setLayout(new GridLayout(7,3,10,10));
		
		basePanel.add(empty);
		basePanel.add(stats);
		basePanel.add(modifiers);
		basePanel.add(strLab);
		basePanel.add(strength);
		basePanel.add(strMod);
		basePanel.add(dexLab);
		basePanel.add(dexterity);
		basePanel.add(dexMod);
		basePanel.add(conLab);
		basePanel.add(con);
		basePanel.add(conMod);
		basePanel.add(intLab);
		basePanel.add(intellect);
		basePanel.add(intMod);
		basePanel.add(wisLab);
		basePanel.add(wisdom);
		basePanel.add(wisMod);
		basePanel.add(charLab);
		basePanel.add(charisma);
		basePanel.add(charMod);
		
		
		JPanel secBase = new JPanel();
		secBase.add(basePanel);
		secBase.add(d);
		
		add(secBase);
		
		
		
	}
	//When value is entered into stat field, modifer is adjusted. 
	//@Param ActionEvent e
	//RESULT: [someModifier].setText, SkillsGui.[someSkill].setText (score)
	//
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == strength){
			int modValue =0;//for javac
			int k = Integer.parseInt(strength.getText());
			n.setStr(k);
			if(k<=5){
				modValue = -3;
				n.setStrMod(modValue);
				System.out.println(modValue + n.getStrMod());
				
				//loop through skillsGUI's parallel array, to find 
				//proper index to set new skills score. 
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 1){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getStrMod();
						sg.skillsValue[i].setText(Integer.toString(modValue));
						
					}
				}
				
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setStrMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 1){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getStrMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
						
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setStrMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 1){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getStrMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setStrMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 1){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getStrMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			strMod.setText(Integer.toString(modValue));
		}
		else if(e.getSource() == dexterity){
			int modValue =0;//for javac
			int k = Integer.parseInt(dexterity.getText());
			n.setDex(k);
			if(k<=5){
				modValue = -3;
				n.setDexMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 2){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
						
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setDexMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 2){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
						
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setDexMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 2){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue));
						
					}
				}
			}
			else{
				modValue = 3;n.setDexMod(modValue);
				n.setDexMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 2){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
						
					}
					
				}
			}
			dexMod.setText(Integer.toString(modValue));
			//hpGUI.dexInitMod.setText(Integer.toString(n.getDexMod()));
		}
		else if(e.getSource() == con){
			int modValue =0;//for javac
			int k = Integer.parseInt(con.getText());
			n.setCon(k);
			if(k<=5){
				modValue = -3;
				n.setConMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 3){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setConMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 3){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setConMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 3){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setConMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 3){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			conMod.setText(Integer.toString(modValue));
		}
		else if(e.getSource() == intellect){
			int modValue =0;//for javac
			int k = Integer.parseInt(intellect.getText());
			n.setIntel(k);
			if(k<=5){
				modValue = -3;
				n.setIntelMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 4){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setIntelMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 4){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setIntelMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 4){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setIntelMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 4){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			intMod.setText(Integer.toString(modValue));
		}
		else if(e.getSource() == wisdom){
			int modValue =0;//for javac
			int k = Integer.parseInt(wisdom.getText());
			n.setWis(k);
			if(k<=5){
				modValue = -3;
				n.setWisMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setWisMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setWisMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setWisMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			wisMod.setText(Integer.toString(modValue));
		}
		else if(e.getSource() == charisma){
			int modValue =0;//for javac
			int k = Integer.parseInt(charisma.getText());
			n.setCha(k);
			if(k<=5){
				modValue = -3;
				n.setChaMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 6){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setChaMod(modValue);for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setChaMod(modValue);for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setChaMod(modValue);for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			charMod.setText(Integer.toString(modValue));
		}
		
		
		
	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getSource() == strength){
			int modValue =0;//for javac
			int k = Integer.parseInt(strength.getText());
			n.setStr(k);
			if(k<=5){
				modValue = -3;
				n.setStrMod(modValue);
				System.out.println(modValue + n.getStrMod());
				
				//loop through skillsGUI's parallel array, to find 
				//proper index to set new skills score. 
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 1){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getStrMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
				
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setStrMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 1){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getStrMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setStrMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 1){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getStrMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setStrMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 1){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getStrMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			strMod.setText(Integer.toString(modValue));
		}
		else if(evt.getSource() == dexterity){
			int modValue =0;//for javac
			int k = Integer.parseInt(dexterity.getText());
			n.setDex(k);
			if(k<=5){
				modValue = -3;
				n.setDexMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 2){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
						
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setDexMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 2){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
						
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setDexMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 2){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue));
						
					}
				}
			}
			else{
				modValue = 3;n.setDexMod(modValue);
				n.setDexMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 2){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
						
					}
					
				}
			}
			dexMod.setText(Integer.toString(modValue));
			//hpGUI.dexInitMod.setText(Integer.toString(n.getDexMod()));
		}
		else if(evt.getSource() == con){
			int modValue =0;//for javac
			int k = Integer.parseInt(con.getText());
			n.setCon(k);
			if(k<=5){
				modValue = -3;
				n.setConMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 3){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setConMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 3){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setConMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 3){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setConMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 3){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			conMod.setText(Integer.toString(modValue));
		}
		else if(evt.getSource() == intellect){
			int modValue =0;//for javac
			int k = Integer.parseInt(intellect.getText());
			n.setIntel(k);
			if(k<=5){
				modValue = -3;
				n.setIntelMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 4){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setIntelMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 4){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setIntelMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 4){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setIntelMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 4){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			intMod.setText(Integer.toString(modValue));
		}
		else if(evt.getSource() == wisdom){
			int modValue =0;//for javac
			int k = Integer.parseInt(wisdom.getText());
			n.setWis(k);
			if(k<=5){
				modValue = -3;
				n.setWisMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setWisMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setWisMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setWisMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			wisMod.setText(Integer.toString(modValue));
		}
		else if(evt.getSource() == charisma){
			int modValue =0;//for javac
			int k = Integer.parseInt(charisma.getText());
			n.setCha(k);
			if(k<=5){
				modValue = -3;
				n.setChaMod(modValue);
				for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 6){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k>5 && k<=12){
				modValue = 1;
				n.setChaMod(modValue);for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else if(k> 12 && k<16){
				modValue = 2;
				n.setChaMod(modValue);for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			else{
				modValue = 3;
				n.setChaMod(modValue);for(int i = 0; i < sg.NUM_OF_SKILLS;i++){
					if(sg.modifiers[i] == 5){
						int temp = Integer.parseInt(sg.skillsValue[i].getText());
						temp += n.getDexMod();
						sg.skillsValue[i].setText(Integer.toString(modValue)); 
					}
				}
			}
			charMod.setText(Integer.toString(modValue));
		}
		
		
	}
	
	
	
	
}
