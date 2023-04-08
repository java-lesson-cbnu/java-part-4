package kr.easw.lesson4;

/**
 * 해당 클래스는 {@link TestInterface}를 상속받아 새 버전을 구현하는 코드를 가지고 있습니다.
 * <p>
 * 해당 문제에서는 {@link TestV1}, {@link TestV2}, {@link TestV3} 3개의 클래스를 수정해 정상적인 값을 도출하도록 해야 합니다.
 * <p>
 * 이는 다음의 조건을 따라야 합니다 :
 * - TestV1 클래스는 입력된 문자열을 그대로 반환해야 합니다.
 * - TestV2 클래스는 입력된 문자열에서 느낌표(!)를 물음표(?)로 바꿔야 합니다.
 * - TestV3 클래스는 입력된 문자열에서 느낌표(!)를 물음표(?)로 바꾸고, 공백( )을 제거해야 합니다.
 */
public class VersioningEncapsulationExample {
    public static String VALUE = "Hello, World!";

    public static String RESULT_SECOND = "Hello, World?";

    public static String RESULT_THIRD = "Hello,World?";

    public static void main(String[] args) {
        TestInterface test = new TestV1();
        if (!test.doAction(VALUE).equals(VALUE)) {
            System.out.println("오답입니다.");
            return;
        }
        test = new TestV2();
        if (!test.doAction(VALUE).equals(RESULT_SECOND)) {
            System.out.println("오답입니다.");
            return;
        }
        test = new TestV3();
        if (!test.doAction(VALUE).equals(RESULT_THIRD)) {
            System.out.println("오답입니다.");
            return;
        }
        System.out.println("정답입니다.");
    }

    interface TestInterface {
        String doAction(String type);
    }


    static class TestV1 implements TestInterface {
        @Override
        public String doAction(String type) {
            // V1은 기존 문자열만을 반환합니다.
            return type;
        }
    }


    static class TestV2 implements TestInterface {
        @Override
        public String doAction(String type) {
            // V2는 !을 ?로 치환합니다.
            return type.replace("!", "?");
        }
    }


    // Split by space, and concat
    static class TestV3 implements TestInterface {
        @Override
        public String doAction(String type) {
            // V3은 공백을 지우고, V2에서 했던 작업을 수행합니다.
            // 메서드 체이닝을 통해 코드를 한 줄로 줄일 수 있습니다.
            return type.replace("!", "?").replace(" ", "");
        }
    }
}
