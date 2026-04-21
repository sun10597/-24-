package day10;

public class GenericBoxExam <T>{
    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }

    private T t;
    public static void main(String[] args) {
        GenericBoxExam<String> st = new GenericBoxExam<>();
        st.set("123");
        GenericBoxExam<Integer> in = new GenericBoxExam<>();
        in.set(123);

        System.out.println(st.get().getClass().getSimpleName());
        System.out.println(in.get().getClass().getSimpleName());
    }
}
