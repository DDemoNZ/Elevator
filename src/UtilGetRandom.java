public class UtilGetRandom {
    public static int random(int max, int min) {
        return (int) (Math.random() * ((max + 1) - min) + min);
    }
}
