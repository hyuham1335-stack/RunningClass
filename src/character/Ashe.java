package character;

import rolegroup.Ranged;

public class Ashe extends Champion implements Ranged {
    public Ashe(String name, int level, int hp, int attackDamage, int criticalRate, int defense) {
        super(name, level, hp, attackDamage, criticalRate, defense);
    }

    @Override
    public void doUseQ(Champion enemy) {
        System.out.println("애쉬의 Q스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 50);
    }

    @Override
    public void doUseW(Champion enemy) {
        System.out.println("애쉬의 W스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 20);
    }

    @Override
    public void doUseE(Champion enemy) {
        System.out.println("애쉬의 E스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 30);
    }

    @Override
    public void doUseR(Champion enemy) {
        System.out.println("애쉬의 R스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 150);
    }


    @Override
    public int getDefenseIncreasePerLv() {
        return 3;
    }

    @Override
    public int getAttackDamageIncreasePerLv() {
        return 20;
    }

    @Override
    public int getHealthIncreasePerLv() {
        return 30;
    }

    @Override
    public void levelUpMessage() {
        System.out.println("애쉬 레벨 업!");
    }

    @Override
    public void kite(Champion champ) {
        battleCount++;
        System.out.println("애쉬의 카이팅 스킬 사용");
        champ.takeDamage(this, getAttackDamage() * 2);
    }

}
