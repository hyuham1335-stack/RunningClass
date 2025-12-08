package character;

import rolegroup.Mage;
import rolegroup.Ranged;

public class Teemo extends Champion implements Mage, Ranged {
    public Teemo(String name, int level, int hp, int attackDamage, int criticalRate, int defense) {
        super(name, level, hp, attackDamage, criticalRate, defense);
    }

    @Override
    public void useQ(Champion enemy) {

    }

    @Override
    public void useW(Champion enemy) {

    }

    @Override
    public void useE(Champion enemy) {

    }

    @Override
    public void useR(Champion enemy) {

    }

    @Override
    public void levelUp() {

    }

    @Override
    public void magicAttack(Champion champ, int damage) {

    }

    @Override
    public void kite(Champion champ, int damage) {

    }
}
