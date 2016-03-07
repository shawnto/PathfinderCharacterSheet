

	import java.util.Map;

	public class Profession {
		
		String professionName;
		int hitDie;
		String [] classSkills;
		int skillRanks; // plus int modifier
		int [] bab;
		int [] fortSave;
		int [] refSave;
		int [] willSave;
		Map<Integer, String> special;
		
		//using arrays allows a table like model of data to simulate the class table. because arrays are zero count 
		//we need to  use (character level - 1) to get the right information.
		public Profession(String professionName,int hitDie, String [] classSkills,int skillRanks, int [] bab, int [] fortSave, int [] refSave, int [] willSave, Map special){
			this.professionName = professionName;
			this.hitDie = hitDie;
			this.classSkills = classSkills;
			this.skillRanks = skillRanks;
			this.bab = bab;
			this.fortSave = fortSave;
			this.refSave = refSave;
			this.willSave = willSave;
			this.special = special;

		}// end Profession constructor
		
		public String getProfessionName(){
			return professionName;
		}
		
		public int getHitDie(){
			return hitDie;
		}
		public String[] getClassSkills(){
			return classSkills;
		}
		public int getSkillRanks(){
			return skillRanks;
		}
		public int [] getBab(){
			return bab;
		}
		public int getBab(int lvl){
			return bab[lvl - 1];
		}
		public int [] getFortSave(){
			return fortSave;
		}
		public int getFortSave(int lvl){
			return fortSave[lvl - 1];
		}
		public int [] getRefSave(){
			return refSave;
		}
		public int getRefSave(int lvl){
			return refSave[lvl - 1];
		}
		public int [] getWillSave(){
			return willSave;
		}
		public int getWillSave(int lvl){
			return willSave[lvl - 1];
		}
		public Map getSpecial(){
			return special;
		}
		public String getSpecial(int lvl){
			return special.get(lvl);
		}
	}


