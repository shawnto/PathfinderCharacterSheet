import javax.swing.JOptionPane;

public class DiceRoll {
	private int numOfSides,modifierForRoll,numOfDice;
	private boolean didCrit;
	public DiceRoll(){
		numOfSides = 20;
		modifierForRoll = 0;
		numOfDice = 1;
	}
	
	public DiceRoll(int numOfSides){
		this.numOfSides = numOfSides;
		modifierForRoll = 0;
		numOfDice = 1;
	}
	
	public DiceRoll(int numOfSides, int modifierForRoll){
		this.numOfSides = numOfSides;
		this.modifierForRoll = modifierForRoll;
		numOfDice = 1;
	}
	
	public DiceRoll(int numOfSides,int modifierForRoll,int numOfDice){
		this.numOfSides = numOfSides;
		this.modifierForRoll = modifierForRoll;
		this.numOfDice = numOfDice;
	}
	
	
	
	public void rollDice(String modifier){
		String rollInfo = "";
		int result =0;//for javac
		int diceRolls[] = new int[numOfDice];
		didCrit = false;
		if(numOfDice > 1){
		for(int i = 0; i<numOfDice;i++){
			int temp;
			temp = (int)(Math.random()*numOfSides) + 1;
			if (temp == numOfSides){
				didCrit = true;
				System.out.println("CRITICAL");
			}
			result += temp;
			diceRolls[i] = temp;
			rollInfo += " roll " + (i + 1) + ": " + diceRolls[i] + "%n";
			
		}
		}
		
		else {
			result = (int)(Math.random()*numOfSides)+ 1;
		    if (result == numOfSides)
		    	didCrit = true;
			
		}
		
		rollInfo = String.format(rollInfo);
		
		JOptionPane.showMessageDialog(null,"You rolled: " + "\n" + rollInfo + "\n" +
		result + "(" + modifier + ")" + " + " + (modifierForRoll) +"(modifier)" + 
		"\n" + "for a total of: " + "\n" + (result + modifierForRoll) + " " + modifier);
		//return result;
		
	}

	
	
	
}
