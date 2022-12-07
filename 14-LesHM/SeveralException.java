package krg.petr.otus.javabasic;

public class SeveralException {

    public static void rethrowException(String exstr) throws Exception01, Exception02, Exception03 {
        try {
            if (exstr.equalsIgnoreCase("ex01")) {
                throw new Exception01("ex01");
            } else if (exstr.equals("ex2")) {
                throw new Exception02("ex02");
            } else {
                throw new Exception03("ex03");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static class Exception01 extends Exception {
        public Exception01(String msg) {
            super(msg);
        }
    }

    static class Exception02 extends Exception {
        public Exception02(String msg) {
            super(msg);
        }
    }

    static class Exception03 extends Exception {
        public Exception03(String msg) {
            super(msg);
        }
    }


}
