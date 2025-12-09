package character;

import rolegroup.Melee;

public class Garen extends Champion implements Melee {

    public Garen(String name, int level, int hp, int attackDamage, int criticalRate, int defense) {
        super(name, level, hp, attackDamage, criticalRate, defense);
    }

    @Override
    public void useQ(Champion enemy) {
        System.out.println("가렌의 Q스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 50);
    }

    @Override
    public void useW(Champion enemy) {
        System.out.println("가렌의 W스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 30);
    }

    @Override
    public void useE(Champion enemy) {
        System.out.println("가렌의 E스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 40);
    }

    @Override
    public void useR(Champion enemy) {
        System.out.println("가렌의 R스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 100);
    }


    @Override
    public int getDefenseIncreasePerLv() {
        return 5;
    }

    @Override
    public int getAttackDamageIncreasePerLv() {
        return 10;
    }

    @Override
    public int getHealthIncreasePerLv() {
        return 60;
    }

    @Override
    public void levelUpMessage() {
        System.out.println("가렌 레벨 업!");
    }

    @Override
    public void dash(Champion champ) {
        System.out.println("가렌의 돌진 사용");
        champ.takeDamage(this, getAttackDamage() + 50);
    }

}
