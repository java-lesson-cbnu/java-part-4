package kr.easw.lesson4;

public class ImplementationExample {

    public static void main(String[] args) {
        if (onTest(1000).equals("TestValue - 700")) {
            System.out.println("정답입니다.");
            return;
        }
        System.out.println("오답입니다.");
    }

    private static String onTest(int value) {
        TestClass testClass = new TestClass();
        return testClass.eval(testClass.getString(), value);
    }


    private static class TestClass {
        /**
         * 해당 메서드는 다음과 같은 역할을 가져야 합니다 :
         * 다음 문자열을 반환해야 합니다.
         *
         * "TestValue"
         */
        public String getString() {
            // 문제의 조건에 따라 TestValue를 반환합니다.
            return "TestValue";
        }

        /**
         * 해당 메서드는 다음과 같은 역할을 가져야 합니다 :
         *
         * 두번째 값에 다음 연산을 거친 후, 첫번째 값에 " - "를 붙여야 합니다.
         *
         * 두번째 값을 2로 나눈 다음, 7을 곱하고, 5로 나눠야 합니다.
         *
         * 그 후, 이 값을 반환해야 합니다.
         *
         * 예를 들어, first가 "TestValue"이고, data가 1000이였다면, 다음 값이 반환되어야 합니다 :
         *
         * "TestValue - 34300"
         *
         * @param first 맨 앞에 위치할 문자열
         * @param data 계산이 진행되어야 할 값
         */
        public String eval(String first, int data) {
            // 첫번째 문자열에 " - "을 붙이고, data 파라미터에 연산을 수행하여 문자열에 덧붙입니다.
            // 괄호를 사용하면 괄호 안은 concat이 이루어지기 전, 결과값 도출을 위해 먼저 수행됩니다.
            // 그러므로, 이와 같은 한 줄로 코드를 요약할 수 있습니다.
            return first + " - " + (data / 2 * 7 / 5);
        }
    }
}
