import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CharInfoGUI extends JPanel implements ActionListener{

	
	//Stores the characters race, and adds appropriate bonuses.
	String[] charRaceList = {"Elf","Dwarf","Gnome","Half-Elf","Human","Half-Orc","Halfing"};
	@SuppressWarnings("unchecked")
	JComboBox charRace = new JComboBox(charRaceList);
	JTextField charName;
	CharClass n;
	BaseStatsUI b;
	JPanel charInfoBase;
	public CharInfoGUI(CharClass n,BaseStatsUI b){
		this.b = b;
		this.n = n;
		charName = new JTextField(20);
		charName.setBorder(BorderFactory.createTitledBorder("Character Name"));
		charName.addActionListener(this);
		charRace.setSelectedIndex(n.getRaceName());
		charRace.addActionListener(this);
		charRace.setBorder(BorderFactory.createTitledBorder("Race"));

		charInfoBase = new JPanel();
		charInfoBase.add(charName);
		charInfoBase.add(charRace);
		
		add(charInfoBase);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == charName){
			n.setCharName(charName.getText());
		}
		if(e.getSource() == charRace){
			//System.out.println(e.getSource() );
			n.setRaceName(charRace.getSelectedIndex());
			if(charRace.getSelectedIndex() == 0){
				n.setDex(n.getDex()+2);
				String temp = Integer.toString(n.getDex());
				b.dexterity.setText(temp);
				n.setCon(n.getDex()-2);
				temp = Integer.toString(n.getCon());
				b.con.setText(temp);
				n.setIntel(n.getIntel()+2);
				temp = Integer.toString(n.getIntel());
				b.intellect.setText(temp);
				
			}
			else if(charRace.getSelectedIndex() == 1){
				
				n.setCon(n.getCon()+2);
				String temp = Integer.toString(n.getCon());
				b.con.setText(temp);
				n.setWis(n.getWis()+2);
				temp = Integer.toString(n.getWis());
				b.wisdom.setText(temp);
				n.setCha(n.getCha()-2);
				temp = Integer.toString(n.getCha());
				b.charisma.setText(temp);
			}
			else if(charRace.getSelectedIndex() == 2){
				
				n.setCon(n.getCon()+2);
				String temp = Integer.toString(n.getCon());
				b.con.setText(temp);
				n.setWis(n.getWis()+2);
				temp = Integer.toString(n.getWis());
				b.wisdom.setText(temp);
				n.setCha(n.getCha()-2);
				temp = Integer.toString(n.getCha());
				b.charisma.setText(temp);
			}
			else if(charRace.getSelectedIndex() == 3){
				
				n.setCon(n.getCon()+2);
				String temp = Integer.toString(n.getCon());
				b.con.setText(temp);
				n.setWis(n.getWis()+2);
				temp = Integer.toString(n.getWis());
				b.wisdom.setText(temp);
				n.setCha(n.getCha()-2);
				temp = Integer.toString(n.getCha());
				b.charisma.setText(temp);
			}
			else if(charRace.getSelectedIndex() == 4){
				n.setCon(n.getCon()+2);
				String temp = Integer.toString(n.getCon());
				b.con.setText(temp);
				n.setWis(n.getWis()+2);
				temp = Integer.toString(n.getWis());
				b.wisdom.setText(temp);
				n.setCha(n.getCha()-2);
				temp = Integer.toString(n.getCha());
				b.charisma.setText(temp);
			}
			else if(charRace.getSelectedIndex() == 5){
				n.setCon(n.getCon()+2);
				String temp = Integer.toString(n.getCon());
				b.con.setText(temp);
				n.setWis(n.getWis()+2);
				temp = Integer.toString(n.getWis());
				b.wisdom.setText(temp);
				n.setCha(n.getCha()-2);
				temp = Integer.toString(n.getCha());
				b.charisma.setText(temp);
			}
		}
		
	}
	/*Race elf = new Race("Elf",0,2,-2,2,0,0);
	Race dwarf = new Race("Dwarf",0,0,2,0,2,-2);
	Race gnome = new Race("Gnome",-2,0,2,0,0,2);
	Race halfelf = new Race("Half-Elf",0,0,0,0,0,0);
	Race human = new Race("Human",0,0,0,0,0,0);
	Race halforc = new Race("Half-Orc",0,0,0,0,0,0);
	Race halfling = new Race("Halfling",-2,2,0,0,0,2);*/
}
