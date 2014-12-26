
public class Player {
	private int maxHP;
	private int hp;
	private int atk;
	private int healingPower;
	private int remainingItemUses;
	private double hitChance;
	public int remainingAP;
	public int maxAP;
	public int apRegen;

	public Player() {
		maxHP = 100;
		hp = 100;
		atk = 10;
		healingPower = 33;
		remainingItemUses = 3;
		hitChance = 0.8;
		remainingAP = 50;
		maxAP = 50;
		apRegen = 10;
	}
	
	public int getHp() {
		return hp;
	}
	
	public double getAtk(){
		return atk;
	}
	
	public double getHit(){
		return hitChance;
	}
	
	public int getHealingPower() {
		return healingPower;
	}
	
	public int getRemainingItemUses() {
		return remainingItemUses;
	}
	
	public int getRemainingAP() {
		return remainingAP;
	}
	
	public boolean isAlive() {
		if (hp == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void takeDamage(int damage){
		hp -= damage; 
		if (hp < 0){
			hp = 0;
		}
	}
	
	public int attack(Monster Monster) {
		double random = Math.random();
		if (random <= hitChance) {
			double crit = (Math.random() + 1);
			int damage = (int) (atk*crit);
			return damage;
		} else {
			return -1;
		}
	}
	
	public int fury(Monster Monster) {
		int r = 1;
		int attacks = 0;
		while (r < 6) {
			if (Math.random() <= 0.5) {
				attacks++;
			}
			r++;
		}
		return attacks;			
	}
	
	public int sacrific() {
		int damage;
		hp -= (hp*0.50);
		damage = (int) (hp*0.50);
		return damage;
	}
	
	public int sword() {
		int damage = atk*2;
		remainingAP -= 30;
		return damage;
	}
	
	public void regenerateAp() {
		remainingAP += apRegen;
		if (remainingAP > maxAP) {
			remainingAP = maxAP;
		}
	}
	
	public boolean heal() {
		if (remainingItemUses > 0) {
			hp += healingPower;
			if (hp > maxHP) {
				hp = maxHP;
			}
			remainingItemUses--;
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return String.format("Spieler-HP: " + hp + " - Attacke: " + atk + " - Traenke: " + remainingItemUses);
	}
	
}
