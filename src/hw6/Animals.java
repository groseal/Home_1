package hw6;

public class Animals {
    private int run;
    private int sail;
    private double jump;
    static int animalsCount = 0;

    public Animals(int run, int sail, double jump) {

        animalsCount++;
        this.run = run;
        this.sail = sail;
        this.jump = jump;
        System.out.println(animalsCount);
    }

    public boolean letRun(int run) {
        if (run > 0) {
            return true;
        }
        return false;
    }

    public boolean letSail(int sail) {
        if (sail > 0) {
            return true;
        }
        return false;
    }

    public boolean letJump(double jump) {
        if (jump > 0) {
            return true;
        }
        return false;
    }


}
