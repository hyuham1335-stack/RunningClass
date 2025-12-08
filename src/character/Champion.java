package character;

import java.util.Random;

public abstract class Champion {

    private String name;
    private int level;
    private int hp;
    private int attackDamage;
    private double criticalRate;
    private int defense;

    // 생성자
    public Champion(String name, int level, int hp, int attackDamage, int criticalRate, int defense )
    {
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.attackDamage = attackDamage;

        if(criticalRate > 100) criticalRate = 100;
        this.criticalRate = criticalRate;

        this.defense = defense;
    }


    //공격

    public void basicAttack(Champion enemy)
    {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int value = rand.nextInt(100);

        int criticalCheck = (value > criticalRate) ? 1 : 2;
        if(criticalCheck == 2) System.out.println("Critical 발생!");

        int myDamage = attackDamage * criticalCheck;
        enemy.takeDamage(this, myDamage);
    }

    public abstract void useQ(Champion enemy);
    public abstract void useW(Champion enemy);
    public abstract void useE(Champion enemy);
    public abstract void useR(Champion enemy);


    //피해처리

    public void takeDamage(Champion damageGiver, int damage)
    {
        String myName = name;
        String enemyName = damageGiver.getName();

        int trueDamage = Math.max(0, damage - defense);
        hp -= trueDamage;

        System.out.println(enemyName + "가 " + myName + "에게 " + trueDamage + " 피해를 주었습니다.");

        if (hp <= 0) {
            System.out.println(myName + " 사망!");
        } else {
            System.out.println(myName + "의 체력이 " + hp + " 남았습니다.");
        }
    }


    // 레벨업

    public abstract void levelUp();


    // getter

    public String getName() {
        return name;
    }


    public int getHp() {
        return hp;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public double getCriticalRate() {
        return criticalRate;
    }

    public int getDefense() {
        return defense;
    }


}
