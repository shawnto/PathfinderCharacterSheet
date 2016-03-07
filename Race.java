public class Race{
	int str,dex,con,intel,wis,cha;
	String raceName;
	public Race(String raceName,int str, int dex, int con, int intel, int wis, int cha){
		this.raceName = raceName;
		this.str = str;
		this.dex = dex;
		this.con = con;
		this.intel = intel;
		this.wis = wis;
		this.cha = cha;

	}//end Race constructor
	
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
	
	public String getRaceName(){
		return raceName;
	}
}//end Race class