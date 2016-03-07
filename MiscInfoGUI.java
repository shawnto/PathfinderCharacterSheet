import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MiscInfoGUI extends JPanel{
CharClass n;
JTextArea charInfo;
JPanel basePanel;

	public MiscInfoGUI(CharClass n){
		
		this.n = n;
		charInfo = new JTextArea("Insert Extra info here: Items, Weapons, spells, etc",40,80);
		JScrollPane infoNest = new JScrollPane(charInfo);
		
		basePanel = new JPanel();
		basePanel.add(infoNest);
		add(basePanel);
		
	}
	
}
