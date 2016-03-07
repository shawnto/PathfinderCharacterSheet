import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


	public class SavingThrowsGUI extends JPanel{

		
		JTextField[] fortitudeFields;
		JTextField[] reflexFields;
		JTextField[] willFields;
		final int NUM_OF_FIELDS = 6;
		
		
		JLabel AC,touch,flatFloot,fortitude,reflex,will;
		
		JPanel armorClassPane,savingThrowsPane,exPane,basePane;

		
		CharClass n;
		public SavingThrowsGUI( CharClass n){
			
			this.n = n;
			AC = new JLabel("AC");
			touch = new JLabel("Touch");
			flatFloot = new JLabel("Flat-Footed");
			fortitude = new JLabel("Fortitude");
			reflex = new JLabel("Reflex");
			will = new JLabel("Will");
			
		
			JLabel savingThrowsLabel = new JLabel("Saving Throws");
			JLabel savingThrowTotal = new JLabel("Total");
			JLabel baseSave = new JLabel("Base Save");
			JLabel abilMod = new JLabel("Ability Modifier");
			JLabel magMod = new JLabel("Magic Modifier");
			JLabel miscMod = new JLabel("Misc Modifier");
			JLabel tempMod = new JLabel("Temporary Modifier");
			
			savingThrowsPane = new JPanel();
			savingThrowsPane.setLayout(new GridLayout (10,3));
			
			savingThrowsPane.add(savingThrowsLabel);
			JLabel b = new JLabel();
			JLabel b1 = new JLabel();
			//JLabel b2 = new JLabel();
			savingThrowsPane.add(b);
			savingThrowsPane.add(b1);
			
			
			
			savingThrowsPane.add(fortitude);
			savingThrowsPane.add(reflex);
			savingThrowsPane.add(will);
			
			fortitudeFields = new JTextField[NUM_OF_FIELDS];
			for(int i = 0; i < NUM_OF_FIELDS; i++){
				fortitudeFields[i] = new JTextField();
				savingThrowsPane.add(fortitudeFields[i]);
			}
			
			
			reflexFields = new JTextField[NUM_OF_FIELDS];
			for(int i = 0; i < NUM_OF_FIELDS;i++){
				reflexFields[i] = new JTextField();
				savingThrowsPane.add(reflexFields[i]);
				
			}
			
			
			willFields = new JTextField[NUM_OF_FIELDS];
			for(int i = 0; i < NUM_OF_FIELDS;i++){
				willFields[i] = new JTextField();
				savingThrowsPane.add(willFields[i]);
			}
			
			JPanel labelPanel = new JPanel(new GridLayout(10,1,1,12));
			JLabel b2 = new JLabel();
			labelPanel.add(b2);
			JLabel b3 = new JLabel();
			labelPanel.add(b3);
			labelPanel.add(savingThrowTotal);
			labelPanel.add(baseSave);
			labelPanel.add(abilMod);
			labelPanel.add(magMod);
			labelPanel.add(miscMod);
			labelPanel.add(tempMod);
			
			basePane = new JPanel();
			
			//sbaePane.setLayout(new GridLayout(2,1));
			
			
			//basePane.add(armorClassPane);
			basePane.add(savingThrowsPane);
			basePane.add(labelPanel);
			//add(basePane);
			//JScrollPane scrollPane = new JScrollPane(basePane);
			
			//scrollPane.getViewport().add(basePane);
			//scrollPane.createHorizontalScrollBar();
			
			//scrollPane.createViewport();
			add(basePane);
			//add(scrollPane);
			//basePane.revalidate();
			//basePane.repaint();
			
			
		}
		
	}
