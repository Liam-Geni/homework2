package homework2;

public class Bus extends Transportation implements Run, Status, Board{

    public Bus(int number) {
        super(number);
        this.maxPassenger = 30;
        this.status ="운행중";
        this.fee = 1000;
    }

    @Override
    public void run(int fuel) {
        this.fuel += fuel;
        System.out.println("주유량 = " + this.fuel);

    }
    @Override
    public void status() {
        if(this.fuel > 50){
            status = "운행중";
            System.out.println(status);
        }else if(fuel <= 50 && fuel > 10){
            this.status="차고지행";
            System.out.println(status);
        }else{
            System.out.println("주유가 필요합니다.");
        }
    }

    @Override
    public void board(int passanger) {
        if( passanger > 30){
            System.out.println("최대 승객 수 초과");
        }else{
            this.passanger = passanger;
        }
        this.maxPassenger -= this.passanger;
        this.fee += this.passanger * fee;

        System.out.println("탑승 승객수 = " + this.passanger);
        System.out.println("잔여 승객수 = " + maxPassenger);
        System.out.println("요금 확인 = " + fee);
    }

    @Override
    public void board(int passanger, String destination, int distance) {

    }
}
