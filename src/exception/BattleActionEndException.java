package exception;

public class BattleActionEndException extends RuntimeException {
    public BattleActionEndException(String message) {
        super(message);
    }
}
