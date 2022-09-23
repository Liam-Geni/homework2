package homework;
public class Exam03 {
    public static void main(String[] args){

        System.out.println("시작!");
        while(true){
            //Math.random() ->0.xxx~0.9xxx
            //6을 곱했을때 가장 작은수는 0, 가장 큰수는 5기때문에 1을 더해주면 1~6사이의정수가 됨
            int num1 = (int)(Math.random()*6) + 1;
            int num2 = (int)(Math.random()*6) + 1;
            System.out.println((num1+ "," + num2));
            if(num1 + num2 == 5){
                break;
            }
        }
        System.out.println("종료!");
    }
}