import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DiceGUI extends JPanel implements ActionListener{
	
	JPanel diceGUIBase;
	JTextField strRes, dexRes,conRes,intRes,wisRes,charRes;
	JButton strRoll, dexRoll, conRoll, intRoll, wisRoll, charRoll;
	JLabel result, rollBlank; 
	CharClass n;
	public DiceGUI(CharClass n){
		this.n = n;
		//Text fields for roll results
		strRes = new JTextField();
		strRes.setEditable(false);
		dexRes = new JTextField();
		dexRes.setEditable(false);
		conRes = new JTextField();
		conRes.setEditable(false);
		intRes = new JTextField();
		intRes.setEditable(false);
		wisRes = new JTextField();
		wisRes.setEditable(false);
		charRes = new JTextField();
		charRes.setEditable(false);
		
		//buttons to roll, need image for button
		strRoll = new JButton("R");
		strRoll.addActionListener(this);
		dexRoll = new JButton("R");
		dexRoll.addActionListener(this);
		conRoll = new JButton("R");
		conRoll.addActionListener(this);
		intRoll = new JButton("R");
		intRoll.addActionListener(this);
		wisRoll = new JButton("R");
		wisRoll.addActionListener(this);
		charRoll = new JButton("R");
		charRoll.addActionListener(this);
		
		result = new JLabel();
		rollBlank = new JLabel();
		
		diceGUIBase = new JPanel();
		diceGUIBase.setLayout(new GridLayout(7,2,10,9));
		//diceGUIBase.add(result);
		diceGUIBase.add(rollBlank);
		//diceGUIBase.add(strRes);
		diceGUIBase.add(strRoll);
		//diceGUIBase.add(dexRes);
		diceGUIBase.add(dexRoll);
		//diceGUIBase.add(conRes);
		diceGUIBase.add(conRoll);
		//diceGUIBase.add(intRes);
		diceGUIBase.add(intRoll);
		//diceGUIBase.add(wisRes);
		diceGUIBase.add(wisRoll);
		//diceGUIBase.add(charRes);
		diceGUIBase.add(charRoll);
		
		add(diceGUIBase);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == strRoll){
			int temp = n.getStrMod();
			//int temp = Integer.parseInt(k);
			DiceRoll roll = new DiceRoll(20,temp);
			//System.out.println(roll.rollDice());
			roll.rollDice(" Strength");
			
		}
		if (e.getSource() == dexRoll){
			int temp = n.getDexMod();
			//int temp = Integer.parseInt(k);
			DiceRoll roll = new DiceRoll(20,temp);
			//System.out.println(roll.rollDice());
			roll.rollDice(" Dex");
			
		}
		
		if (e.getSource() == conRoll){
			int temp = n.getConMod();
			//int temp = Integer.parseInt(k);
			DiceRoll roll = new DiceRoll(20,temp);
			//System.out.println(roll.rollDice());
			roll.rollDice(" Con");
			
			
		}
		if (e.getSource() == intRoll){
			int temp = n.getIntelMod();
			//int temp = Integer.parseInt(k);
			DiceRoll roll = new DiceRoll(20,temp);
			//System.out.println(roll.rollDice());
			roll.rollDice(" Int");
			
		}
		if (e.getSource() == wisRoll){
			int temp = n.getWisMod();
			//int temp = Integer.parseInt(k);
			DiceRoll roll = new DiceRoll(20,temp);
			//System.out.println(roll.rollDice());
			roll.rollDice(" Wisdom");
			
		}
		if (e.getSource() == charRoll){
			int temp = n.getChaMod();
			//int temp = Integer.parseInt(k);
			DiceRoll roll = new DiceRoll(20,temp);
			//System.out.println(roll.rollDice());
			roll.rollDice(" Cha");
			
		}
		
		
	}
	
	
}
