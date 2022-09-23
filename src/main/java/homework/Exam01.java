package homework;

public class Exam01 {
    public static void main(String[] args) {

        int var1 = 5;
        int var2 = 2;
//자바 연산 에서 일반적인 계산과 달리 분수/소수 계산을 하지 않고 몫에 해당하는 값만 반환함
        double var3 = var1/var2;	// 값은 2.0
// var3 = 2.0, var2 = 2 -> 2.0 * 2 = 4.0 -> 형변환(casting) -> (int)(4.0) = 4
        int var4 = (int)(var3*var2);  //값은 4
        System.out.println(var4); // 4가 출력
    }
}
