public class Single {

    private static Single s;

    private Single(){

    };

    public static Single getSingle() {
        if (s == null) {
            return new Single();
        } else {
            return s;
        }
    }
}
