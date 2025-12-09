import character.Ashe;
import character.Champion;
import character.Garen;
import character.Teemo;
import rolegroup.Mage;
import rolegroup.Melee;
import rolegroup.Ranged;

public class Main {
    public static void main(String[] args) {

        Champion garen = new Garen("김가렌", 1, 600, 70, 25, 30);
        Champion teemo = new Teemo("김티모", 1, 500, 80, 40, 20);

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
