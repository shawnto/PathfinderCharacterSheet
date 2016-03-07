
//Holds base character stats.

@SuppressWarnings("serial")
public class CharClass implements java.io.Serializable {
	static int NUM_OF_SKILLS = 41;
	int str,dex,con,intel,wis,cha,raceName;
	
	int strMod,dexMod,conMod,intMod,wisMod,chaMod;
	HitPointCalc hitPoints;
	String charName;
	//Skills, parallel array for Skills. Boolean to flag selected. 
	boolean[] skills = new boolean[NUM_OF_SKILLS];
	public CharClass(int str, int dex, int con, int intel, int wis, int cha){
		
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.intel = intel;
		this.wis = wis;
		this.cha = cha;
		hitPoints = new HitPointCalc();
		
		
		

	}//end Race constructor
	
public CharClass(){
		
		str = 0;
		dex = 0;
		con = 0;
		intel = 0;
		wis = 0;
		cha = 0;
		hitPoints = new HitPointCalc();
		strMod = 0;

	}
	
	public CharClass(CharClass n){
		
	}
	
	public boolean getSkill(int index){
		return skills[index];
	}
	
	public int getStr(){
		return str;
	}
	
	public int getDex(){
		return dex;
	}
	
	public int getCon(){
		return con;
	}
	public int getIntel(){
		return intel;
	}
	
	public int getWis(){
		return wis;
	}
	
	public int getCha(){
		return cha;
	}
	
	public int getStrMod(){
		return str;
	}
	
	public int getDexMod(){
		return dex;
	}
	
	public int getConMod(){
		return con;
	}
	
	public int getIntelMod(){
		return intel;
	}
	
	public int getWisMod(){
		return wis;
	}
	
	public int getChaMod(){
		return cha;
	}
	
	public String getCharName(){
		return charName;
	}
	public int getRaceName(){
		return raceName;
	}
	
	
	public  void setStr(int s){
		this.str = s;
	}
	public void setDex(int d){
		this.dex = d;
	}
	
	public void setCon(int con){
		 this.con = con;
	}
	
	public void setIntel(int intel){
		this.intel = intel;
	}
	
	public void setWis(int wis){
		this.wis = wis;
	}
	
	public void setCha(int cha){
		this.cha = cha;
	}
	
	public void setStrMod(int strmod){
		this.strMod = strmod;
	}
	
	public void setDexMod(int dexmod){
		this.dexMod = dexmod;
	}
	
	public void setConMod(int conmod){
		this.conMod = conmod;
	}
	
	public void setIntelMod(int intelMod){
		this.intMod = intelMod;
	}
	
	public void setWisMod(int wismod){
		this.wisMod = wismod;
	}
	
	public void setChaMod(int chamod){
		this.chaMod = chamod;
	}
	
	public void setCharName(String charName){
		this.charName = charName;
	}
	
	
	public void setRaceName(int raceName){
		this.raceName = raceName;
	}
	
	public void setSkill(boolean b,int index){
		this.skills[index] = b;
 	}

	
	
}
