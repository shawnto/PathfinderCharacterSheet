import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HitPointGUI extends JPanel implements ActionListener{
	
	JTextField totalHP,DR,currentHP,nonLethalDmg,totalInit,miscInit,dexInitMod;
	JLabel HP,initiative;
	JPanel criticalStatsPane,basePanel;
	CharClass n;
	BaseStatsUI bs;
	public HitPointGUI(CharClass n){
		this.n = n;
		
		HP = new JLabel("Hit Points");
		initiative = new JLabel("Initiative");
		
		totalHP = new JTextField(Integer.toString(n.hitPoints.getTotalHp()));
		DR = new JTextField("DR");
		currentHP = new JTextField(Integer.toString(n.hitPoints.getCurrentHP()));
		nonLethalDmg = new JTextField("Nonlethal Damage");
		totalInit = new JTextField("Total");
		miscInit = new JTextField("Misc Init Mod");
		
dexInitMod = new JTextField(Integer.toString(n.getDexMod()));
dexInitMod.addActionListener(this);
		
		criticalStatsPane = new JPanel();
		criticalStatsPane.setLayout(new GridLayout(2,5));
		criticalStatsPane.add(HP);
		
		criticalStatsPane.add(totalHP);
		criticalStatsPane.add(DR);
		criticalStatsPane.add(currentHP);
		criticalStatsPane.add(nonLethalDmg);
		
		criticalStatsPane.add(initiative);
		criticalStatsPane.add(totalInit);
		criticalStatsPane.add(dexInitMod);
		criticalStatsPane.add(miscInit);
		
		basePanel = new JPanel();
		basePanel.add(criticalStatsPane);
		basePanel.setBorder(BorderFactory.createEtchedBorder(0, Color.WHITE, Color.GRAY));
		add(basePanel);
		
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == dexInitMod){
			
			int tempPoints = Integer.parseInt(totalInit.getText());
			tempPoints += n.getDexMod();
			String k = Integer.toString(tempPoints);
		    totalInit.setText(k);
		   
		}
		
	}

}
