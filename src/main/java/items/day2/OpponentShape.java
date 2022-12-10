package items.day2;

public enum OpponentShape implements Shape {
    
    A(1),
    B(2),
    C(3);

    public final int score;

    OpponentShape(int score) {
        this.score = score;
    }
}
