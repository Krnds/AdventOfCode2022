package items.day2;

public enum UserShape implements Shape {

    X(1),
    Y(2),
    Z(3);

    public final int score;

    UserShape(int score) {
        this.score = score;
    }

}
