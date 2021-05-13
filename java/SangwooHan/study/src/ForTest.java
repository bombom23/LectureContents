public class ForTest {
    public static void main(String[] args) {
        //for 문의 구성
        // for(초기화 코드; 조건식 코드; 증감식코드)로 구성된다.
        // 초기화 코드는 for문에 최초 진입시 한번만 실행이 된다.
        // 조건식 코드는 for문 내부(중괄호파드 )로 진입하기위한 조건이다.
        // 증감식 코드는 for문 내부 동작이 완료된 이후 동작할 코드이다.
        // 이후 다시 조건식 코드로 가서 조건을 비교하고 충족한다면 위 로직을 반복하며
        // 만약 조건식 코드에서 조건이 위배된다면, for문이 종료된다.

        // for문 작성하는 방법
        // 1.for (){}
        // 2. 초기화가 필요하다면 , 초기화 코드를 작성한다
        // 3. 어떤 조건에서 동작시킬지 동작조선을 작성한다.
        // 4. 증감식 코드위치에 증가시키거나 감소시킬 값에대한 코드를 작성한다.
        // 5. 중괄호 내부에 조건이 만족되었을 경우 동작시킬 코드를 작성한다.
        // 조건식  작거다 같다에서 주의점 (<=) 작아도 참 , 같아도 참 , 크면 거짓 그리고 조건식은 같다라는 개념이 아니라 같나요? 라고 컴퓨터한테 묻는거다
        // i= i+2 와 i+=2   는 동의어다 .
        for(int i = 1; i<=10; i= i+2){
            System.out.println("i="+i);

        }
    }
}