package homework2;

public abstract class Transportation {
    int maxPassenger;
    int passanger;
    int fee;
    int number;
    int fuel;
    int speed;
    String status;

    public Transportation(int number){
        this.maxPassenger = 0;
        this.passanger = 0;
        this.number = number;
        this.fuel = 100;
        this.speed = 0;
    }

    public abstract void board(int passanger);
}
