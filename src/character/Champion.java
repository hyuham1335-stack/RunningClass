package character;

import constants.GameConstants;
import exception.BattleActionEndException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Champion {

    private String name;
    private int level;
    private int hp;
    private int attackDamage;
    private double criticalRate;
    private int defense;
    public static int battleCount;
    private int deathCount;

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
        battleCount++;

        if (hp <= 0) {
            Logger.log("캐릭터가 사망한 상태입니다.");
            return;
        }

        Logger.log(name + "가 " + enemy.getName() + "에게 기본 공격!");
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        int value = rand.nextInt(100);

        int criticalCheck = (value > criticalRate) ? 1 : 2;
        if(criticalCheck == 2) {
            Logger.log("Critical 발생!");
        }

        int myDamage = attackDamage * criticalCheck;
        enemy.takeDamage(this, myDamage);
    }

    public final void useQ(Champion enemy) {
        doUseQ(enemy);
        battleCount++;
    }
    public final void useW(Champion enemy) {
        doUseW(enemy);
        battleCount++;
    };
    public final void useE(Champion enemy) {
        doUseE(enemy);
        battleCount++;
    }
    public final void useR(Champion enemy){
        doUseR(enemy);
        battleCount++;
    }

    public abstract void doUseQ(Champion enemy);
    public abstract void doUseW(Champion enemy);
    public abstract void doUseE(Champion enemy);
    public abstract void doUseR(Champion enemy);


    //피해처리

    public void takeDamage(Champion damageGiver, int damage)
    {
        String myName = name;
        String enemyName = damageGiver.getName();

        int trueDamage = Math.max(0, damage - defense);
        hp -= trueDamage;

        Logger.log(enemyName + "이(가) " + myName + "에게 " + trueDamage + " 피해를 주었습니다.");


        if (hp <= 0) {
            Logger.log(myName + " 사망!");
            hp = 0;
            resurrect();
        } else {
            Logger.log(myName + "의 체력이 " + hp + " 남았습니다.");
        }
    }


    // 레벨업

    public void levelUp()
    {
        levelUpMessage();
        level += 1;
        hp += getHealthIncreasePerLv();
        attackDamage += getAttackDamageIncreasePerLv();
        defense += getDefenseIncreasePerLv();
    }

    public abstract int getDefenseIncreasePerLv();

    public abstract int getAttackDamageIncreasePerLv();

    public abstract int getHealthIncreasePerLv();

    public abstract void levelUpMessage();


    // 부활 기능

    public final void resurrect() {
        deathCount += 1;
        if(resurrectCheck()) {
            this.hp = (int)(GameConstants.baseHp * 0.2);
            Logger.log(name + " 부활! " + name + " 현재 체력:" + hp);
        } else {
            Logger.log(name + " 이(가) 더 이상 부활할 수 없어 전투를 종료합니다.");
            throw new BattleActionEndException();
        }
    }

    public abstract boolean resurrectCheck();


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

    public int getDeathCount() {
        return deathCount;
    }

    // toString

    @Override
    public String toString() {
        return "Champion{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", hp=" + hp +
                ", attackDamage=" + attackDamage +
                ", criticalRate=" + criticalRate +
                ", defense=" + defense +
                '}';
    }

    // 로그 처리 내부 중첩 클래스
    public static class Logger {
        private static final List<String> logList = new ArrayList<>();

        public static void log(String message) {
            logList.add(message);
            System.out.println(message);
        }

        // 수정 불가능하게 불변 객체로 반환
        public static List<String> getLogList() {
            return Collections.unmodifiableList(logList);
        }
    }

}
