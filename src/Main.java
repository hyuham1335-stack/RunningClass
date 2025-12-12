import character.Ashe;
import character.Champion;
import character.Garen;
import character.Teemo;
import constants.GameConstants;
import rolegroup.Mage;
import rolegroup.Melee;
import rolegroup.Ranged;

public class Main {
    public static void main(String[] args) {

        Champion garen = new Garen("김가렌", 1, GameConstants.baseHp, GameConstants.baseAttackDamage, 25, GameConstants.baseDefense);
        Champion teemo = new Teemo("김티모", 1, GameConstants.baseHp, GameConstants.baseAttackDamage, 40, GameConstants.baseDefense);

        garen.levelUp();
        teemo.levelUp();

        garen.useQ(teemo);
        teemo.useQ(garen);


        if(garen instanceof Melee melee)
        {
            melee.dash(teemo);
        }

        if (teemo instanceof Mage mage) {
            mage.magicAttack(garen);
        }


        System.out.println("======= 전투 종료 =======");
        System.out.println(garen);
        System.out.println(teemo);

    }
}
