public class OverloadMethodeOfJavaExample {
    // Basic Germany method
    public void Germany() {
        System.out.println("Das carrier of Axis team.");
    }

    // Overloaded method with one parameter
    public void Germany(String almostVictory) {
        System.out.println("Und das heißt Erika! " + almostVictory + "!");
    }

    // Overloaded method with two parameters
    public void Germany(String gotCooked, int dateComeback) {
        System.out.println("Ach scheiße, wir " + gotCooked + " at " + dateComeback);
    }

    public static void main(String[] args) {
       OverloadMethodeOfJavaExample war = new OverloadMethodeOfJavaExample();
        war.Germany();  // Calls the first method
        war.Germany("Battle of Moscow"); // Calls the second method
        war.Germany("got cooked", 1945); // Calls the third method
    }
}
