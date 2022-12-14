package homework;
public class Exam02 {

    public static void main(String[] args){

        int x = 10;
        int y = 20;
//증감연산자가 앞에있으면 증감연산을 먼저 수행하고 그 값으로 다시 연산(전위 연산)
//증감연산자가 뒤에있으면 변수에 기존값으로 연산후 마지막에 증감연산 수행(후위 연산)
        int z = (++x) + (y--); //z = x(11) + y(20)
        System.out.println(z); // z = 31
        System.out.println(y); // y = 19
    }
}

/*  기존에 증감연산자의 개념을 알고있어서
	()로 묶여 있으니까 y--가 = 연산자보다 먼저 될 것 같았다.
    하지만 이 줄의 연산에서 y-1를 모든 연산이 끝나고 난 뒤에 가장 꼴찌로 한다.
    기존에 수학적으로 생각하기 보단 언어의 일관성을 유지하기 위해서
    그냥 java를 만든사람이 그렇게 하기로 약속한것이라고 생각하면 될것 같다고 정리했다.

    *후위연산자는 괄호 연산자마저 가장 나중으로 미루어버린다 *
 */