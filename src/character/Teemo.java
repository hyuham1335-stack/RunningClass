package character;

import rolegroup.Mage;
import rolegroup.Ranged;

public class Teemo extends Champion implements Mage, Ranged {
    public Teemo(String name, int level, int hp, int attackDamage, int criticalRate, int defense) {
        super(name, level, hp, attackDamage, criticalRate, defense);
    }

    @Override
    public void useQ(Champion enemy) {
        System.out.println("티모의 Q스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 50);
    }

    @Override
    public void useW(Champion enemy) {
        System.out.println("티모의 W스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 60);
    }

    @Override
    public void useE(Champion enemy) {
        System.out.println("티모의 E스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 70);
    }

    @Override
    public void useR(Champion enemy) {
        System.out.println("티모의 R스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 80);
    }

    @Override
    public int getDefenseIncreasePerLv() {
        return 4;
    }

    @Override
    public int getAttackDamageIncreasePerLv() {
        return 15;
    }

    @Override
    public int getHealthIncreasePerLv() {
        return 50;
    }

    @Override
    public void levelUpMessage() {
        System.out.println("티모 레벨 업!");
    }

    @Override
    public void magicAttack(Champion champ) {
        System.out.println("티모의 마법스킬 사용");
        champ.takeDamage(this, getAttackDamage() + 50);
    }

    @Override
    public void kite(Champion champ) {
        System.out.println("티모의 카이팅 스킬 사용");
        champ.takeDamage(this, getAttackDamage() * 2);
    }

}
