package coding.inter;

public class Test {

    public static boolean canPickUp(int[][] scan, int packageId) {
        boolean canPick = false;
        int currentPack = 0;
        for (int row=0; row<scan.length; row++) {
            for (int col=0; col<scan[row].length; col++) {
                if (scan[row][col] == 0) {
                    canPick = true;
                } else if (scan[row][col] == packageId) {
                    canPick = true;
                    currentPack = scan[row][col];
                    break;
                } else if (currentPack < scan[row][col]) {
                    canPick = false;
                }
            }
        }
        return canPick;
//        throw new UnsupportedOperationException("Waiting to be implemented");
    }

    public static void main(String[] args) {
        int[][] scan = new int[][] {
                { 0, 0, 0, 1, 2 },
                { 0, 0, 0, 1, 2 },
                { 0, 3, 3, 5, 2 },
                { 0, 0, 0, 5, 4 }
        };
        System.out.println(canPickUp(scan, 3)); // Should print true
        System.out.println(canPickUp(scan, 5)); // Should print false
    }
}
