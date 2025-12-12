package character;

import rolegroup.Mage;

public class Lux extends Champion implements Mage {
    public Lux(String name, int level, int hp, int attackDamage, int criticalRate, int defense) {
        super(name, level, hp, attackDamage, criticalRate, defense);
    }

    @Override
    public void doUseQ(Champion enemy) {
        System.out.println("럭스의 Q스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 50);
    }

    @Override
    public void doUseW(Champion enemy) {
        System.out.println("럭스의 W스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 40);
    }

    @Override
    public void doUseE(Champion enemy) {
        System.out.println("럭스의 E스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 60);
    }

    @Override
    public void doUseR(Champion enemy) {
        System.out.println("럭스의 R스킬 사용");
        enemy.takeDamage(this, getAttackDamage() + 200);
    }

    @Override
    public int getDefenseIncreasePerLv() {
        return 3;
    }

    @Override
    public int getAttackDamageIncreasePerLv() {
        return 10;
    }

    @Override
    public int getHealthIncreasePerLv() {
        return 40;
    }

    @Override
    public void levelUpMessage() {
        System.out.println("럭스 레벨 업!");
    }

    // 럭스 부활 가능횟수 = 0 회
    @Override
    public boolean resurrectCheck() {
        if(this.getDeathCount() >= 1){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void magicAttack(Champion champ) {
        battleCount++;
        Logger.log("럭스의 마법스킬 사용");
        champ.takeDamage(this, getAttackDamage() + 50);
    }

}
