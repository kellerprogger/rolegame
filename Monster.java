
public class Monster {
	public int hp;
	public int atk;
	public double hitChance;
	
	public Monster(int hp, int atk, double hitChance) {
		this.hp = hp;
		this.atk = atk;
		this.hitChance = hitChance;	
	}
	
	public boolean isAlive(){
		if (hp == 0) {
			return false;
		} else {
			return true;
		}	
	}
	
	public void takeDamage(int damage) {
		hp -= damage; 
		if (hp < 0){
			hp = 0;
		}	
	}
	
	public int attack(Player Player) {
		double random = Math.random();
		if (random <= hitChance) {
			double crit = (Math.random() + 1);
			int damage = (int) (atk*crit);
			return damage;
		} else {
			return -1;
		}	
	}
	
	public String toString() {
		return String.format("Monster-HP: " + hp + " - Attacke: " + atk);
	}
}
