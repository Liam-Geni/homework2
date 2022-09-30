package homework2;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus(1);
        Bus bus2 = new Bus(2);
        Taxi taxi1 = new Taxi(1);
        Taxi taxi2 = new Taxi(2);

        if(taxi1.number == taxi2.number){
            System.out.println("번호가 같습니다.");
        }else{
            System.out.println("번호가 다릅니다.");
        }

    }
}
