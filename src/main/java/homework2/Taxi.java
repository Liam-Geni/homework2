package homework2;

public class Taxi extends Transportation implements Run, Status, Board, Accumulate, Stop{
    int basicDistance;
    int available;
    int feeDistance;
    int money;
    public Taxi(int number)
    {
        super(number);
        this.maxPassenger = 4;
        this.fee = 3000;
        this.status= "일반";
        this.basicDistance = 1;
        this.feeDistance = 1000;
    }

    @Override
    public void board(int passanger) {

    }

    @Override
    public void run(int fuel) {
        this.fuel += fuel;
        System.out.println("주유량 = " + this.fuel);
        if(this.fuel < 10){
            System.out.println("운행이 불가합니다.");
        }
    }
    @Override
    public void status() {
        if(passanger > 0){
            status = "운행중";
            System.out.println(status);
        }else if (passanger == 0){
            status = "일반";
            System.out.println(status);
        }
    }

    @Override
    public void board(int passanger, String destination, int distance) {

        int pay = (fee * basicDistance) + (distance - basicDistance) * feeDistance;
        available = maxPassenger - passanger;

        if(status.equals("일반")) {
            if (passanger <= maxPassenger) {
                this.passanger = passanger;
                status = "운행중";
                money += pay;
                System.out.println("탑승 승객 수 = " + passanger);
                System.out.println("잔여 승객 수 = " + available);
                System.out.println("기본 요금 확인 =" + fee);
                System.out.println("목적지 = " + destination);
                System.out.println("목적지 까지 거리 : " + distance + "km");
                System.out.println("지불할 요금 = " + pay);
                System.out.println("상태 = " + status);
            } else {
                System.out.println("4인 이상은 탑승할 수 없습니다.");
            }
        }else{
            System.out.println("운행 중임으로 탑승 할 수 없습니다.");
        }

    }

    @Override
    public void accumlate() {
        System.out.println("누적 금액 = " + money);
    }

    @Override
    public void stop() {
        if(status.equals("운행중")){
            System.out.println("승객이 하차 합니다.");
            this.passanger = 0;
        }
    }
}
