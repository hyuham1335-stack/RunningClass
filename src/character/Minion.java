package character;
import java.util.EnumMap;
import java.util.Set;

public class Minion {
    //enum 에 최적화된 EnumMap 사용
    // 비어있는 상태라 초기화 필요
    private static final EnumMap<BasicAbility, Integer> abilities =  new EnumMap<>(BasicAbility.class);

    // 미니언 인스턴스 생성 시 능력치 정보를 관리하는 EnumMap 초기화
    // figure 이 이미 존재하여 EnumSet 중에서 고민하였으나 figure 값이 일시적으로 변경되는
    // 가능성도 고려 하여 EnumMap 사용
    public Minion() {
        for (BasicAbility basicAbility : BasicAbility.values()) {
            abilities.put(basicAbility, basicAbility.getFigure());
        }
    }
}
