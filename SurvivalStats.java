import javax.swing.*;
import java.awt.*;

public class SurvivalStats extends JPanel{

	
	
	JTextField acTotal,armorBonus,shieldBonus,dexMod,sizeMod,natArmor,deflectMod,
	miscACMod,touchField,flatFootField, exMods;
	
	
	
	
	JLabel AC,touch,flatFloot;
	
	JPanel armorClassPane,ACBasePanel;

	
	public SurvivalStats(){
		
		
		AC = new JLabel("AC");
		touch = new JLabel("Touch");
		flatFloot = new JLabel("Flat-Footed");
		
		
		
		
		acTotal = new JTextField("Total");
		armorBonus = new JTextField("Armor Bonus");
		shieldBonus =	new JTextField("Shield Bonus");
		dexMod = new JTextField("Dex Modifier");
		sizeMod	= new JTextField("Size Modifier");
		natArmor = new JTextField("Natural Armor");
		deflectMod	= new JTextField("Deflection Modifier");
		miscACMod	= new JTextField("Misc Mod");
		touchField	= new JTextField("Touch");
		flatFootField	= new JTextField("FF");
		exMods= new JTextField("Modifiers");
		
		
		armorClassPane = new JPanel(new GridLayout(4,5,1,1));
		armorClassPane.add(AC);
		armorClassPane.add(acTotal);
		armorClassPane.add(shieldBonus);
		armorClassPane.add(dexMod);
		armorClassPane.add(sizeMod);
		armorClassPane.add(natArmor);
		armorClassPane.add(deflectMod);
		armorClassPane.add(miscACMod);
		
		armorClassPane.add(touch);
		armorClassPane.add(touchField);
		JLabel blank = new JLabel();
		armorClassPane.add(blank);
		JLabel blank2 = new JLabel();
		armorClassPane.add(blank2);
		armorClassPane.add(flatFloot);
		armorClassPane.add(flatFootField);
		JLabel filler = new JLabel();
		//armorClassPane.add(filler);
		armorClassPane.add(exMods);
		
		
		
		
		//add(basePane);
		//JScrollPane scrollPane = new JScrollPane(basePane);
		
		//scrollPane.getViewport().add(basePane);
		//scrollPane.createHorizontalScrollBar();
		
		//scrollPane.createViewport();
		add(armorClassPane);
		//add(scrollPane);
		//basePane.revalidate();
		//basePane.repaint();
		
		
	}
	
}
