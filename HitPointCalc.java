
public class HitPointCalc {

	private int totalHP,dR,currentHP,nonlethalDamage;
	
	public HitPointCalc(){
		totalHP = 0;
		dR = 0;
		currentHP = 0;
		nonlethalDamage = 0;	
	}
	
	
	
	public HitPointCalc(int totalHP,int dR,int currentHP, int nonlethalDamage){
		
		this.totalHP = totalHP;
		this.dR = dR;
		this.currentHP = currentHP;
		this.nonlethalDamage = nonlethalDamage;
		
		
	}
	
	public int getTotalHp(){
		return totalHP;
	}
	
	public int getTotalDR(){
		return dR;
	}
	
	public int getCurrentHP(){
		return currentHP;
	}
	
	public int getNonlethalDamage(){
		return nonlethalDamage;
	}
	
	public void setTotalHp(int hp){
		this.totalHP = hp;
	}
	
	public void setTotalDR(int dr){
		this.dR = dr;
	}
	
	public void setCurrentHP(int hp){
		this.currentHP = hp;
	}
	
	public void setNonlethalDamage(int dmg){
		this.nonlethalDamage = dmg;
	}

}
