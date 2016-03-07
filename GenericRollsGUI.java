import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GenericRollsGUI extends JPanel implements ActionListener{

	JLabel miscRollsLabel;
	JButton d20Roll,d12Roll,d10Roll,d8Roll,d6Roll,d4Roll,percantileRoll;
	String[] modifiers = {"Strength","Dexterity", "Constitution","Intellect",
			"Wisdom","Charisma"};
	JComboBox modListForRoll = new JComboBox(modifiers);
	JTextField numOfDiceForRoll;
	JPanel genericRollsGUIBase,rollsLabelBase,buttonsBase,modAndNumField,butAndModBase;
	BaseStatsUI b;
	int modifierValue,numOfDice;
	@SuppressWarnings("unchecked")
	public GenericRollsGUI(BaseStatsUI b){
		this.b = b;
		rollsLabelBase = new JPanel();
		miscRollsLabel = new JLabel("Misc Rolls");
		rollsLabelBase.add(miscRollsLabel);
		
		buttonsBase = new JPanel(new GridLayout(3,3));
		d20Roll = new JButton("D20");
		d20Roll.addActionListener(this);
		buttonsBase.add(d20Roll);
		d12Roll = new JButton("D12");
		d12Roll.addActionListener(this);
		buttonsBase.add(d12Roll);
		d10Roll = new JButton("D10");
		d10Roll.addActionListener(this);
		buttonsBase.add(d10Roll);
		d8Roll = new JButton("D8");
		d8Roll.addActionListener(this);
		buttonsBase.add(d8Roll);
		d6Roll = new JButton("D8");
		d6Roll.addActionListener(this);
		buttonsBase.add(d6Roll);
		d4Roll = new JButton("D4");
		d4Roll.addActionListener(this);
		buttonsBase.add(d4Roll);
		percantileRoll = new JButton("D%");
		percantileRoll.addActionListener(this);
		buttonsBase.add(percantileRoll);
		JLabel blnk = new JLabel();
		buttonsBase.add(blnk);
		
		modListForRoll.setSelectedIndex(0);
		modListForRoll.addActionListener(this);
		modAndNumField = new JPanel();
		modAndNumField.add(modListForRoll);
		numOfDiceForRoll = new JTextField("1");
		modAndNumField.add(numOfDiceForRoll);
		butAndModBase = new JPanel(new FlowLayout());
		butAndModBase.add(buttonsBase);
		butAndModBase.add(modAndNumField);
		
		genericRollsGUIBase = new JPanel(new BorderLayout());
		genericRollsGUIBase.add(rollsLabelBase,BorderLayout.NORTH);
		genericRollsGUIBase.add(butAndModBase,BorderLayout.CENTER);
		
		add(genericRollsGUIBase);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == modListForRoll){
			if(modListForRoll.getSelectedIndex() == 0){
				modifierValue = Integer.parseInt(b.strMod.getText());
				System.out.println(modifierValue);
			}
			else if(modListForRoll.getSelectedIndex() == 1){
				modifierValue = Integer.parseInt(b.dexMod.getText());
			}
			else if(modListForRoll.getSelectedIndex() == 2){
				modifierValue = Integer.parseInt(b.conMod.getText());
			}
			else if(modListForRoll.getSelectedIndex() == 3){
				modifierValue = Integer.parseInt(b.intMod.getText());
			}
			else if (modListForRoll.getSelectedIndex() ==4){
				modifierValue = Integer.parseInt(b.wisMod.getText());
			}
			else {
				modifierValue = Integer.parseInt(b.charMod.getText());
			}
		}
		
		if(e.getSource() == d20Roll){
			numOfDice = Integer.parseInt(numOfDiceForRoll.getText());
			System.out.println(modifierValue);
			DiceRoll newRoll = new DiceRoll(20, modifierValue, numOfDice);
			newRoll.rollDice(modifiers[modListForRoll.getSelectedIndex()]);
		}
		
		else if(e.getSource() == d12Roll){
			numOfDice = Integer.parseInt(numOfDiceForRoll.getText());
			DiceRoll newRoll = new DiceRoll(12, modifierValue, numOfDice);
			newRoll.rollDice(modifiers[modListForRoll.getSelectedIndex()]);
		}
		else if(e.getSource() == d10Roll){
			numOfDice = Integer.parseInt(numOfDiceForRoll.getText());
			DiceRoll newRoll = new DiceRoll(10, modifierValue, numOfDice);
			newRoll.rollDice(modifiers[modListForRoll.getSelectedIndex()]);
		}
		else if(e.getSource() == d8Roll){
			numOfDice = Integer.parseInt(numOfDiceForRoll.getText());
			DiceRoll newRoll = new DiceRoll(8, modifierValue, numOfDice);
			newRoll.rollDice(modifiers[modListForRoll.getSelectedIndex()]);
		}
		else if(e.getSource() == d6Roll){
			numOfDice = Integer.parseInt(numOfDiceForRoll.getText());
			DiceRoll newRoll = new DiceRoll(6, modifierValue, numOfDice);
			newRoll.rollDice(modifiers[modListForRoll.getSelectedIndex()]);
		}
		else if(e.getSource() == d4Roll){
			numOfDice = Integer.parseInt(numOfDiceForRoll.getText());
			DiceRoll newRoll = new DiceRoll(4, modifierValue, numOfDice);
			newRoll.rollDice(modifiers[modListForRoll.getSelectedIndex()]);
		}
		else if(e.getSource() == percantileRoll){
			numOfDice = Integer.parseInt(numOfDiceForRoll.getText());
			DiceRoll newRoll = new DiceRoll(100, modifierValue, numOfDice);
			newRoll.rollDice(modifiers[modListForRoll.getSelectedIndex()]);
		}
	}
	
	public static int getModifier(){
		
		
		return 0;
		
	}
	
	
}
