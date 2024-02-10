import java.util.HashSet;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 * // Returns true if the cell in front is open and robot moves into the cell.
 * // Returns false if the cell in front is blocked and robot stays in the current cell.
 * public boolean move();
 * <p>
 * // Robot will stay in the same cell after calling turnLeft/turnRight.
 * // Each turn will be 90 degrees.
 * public void turnLeft();
 * public void turnRight();
 * <p>
 * // Clean the current cell.
 * public void clean();
 * }
 */

interface Robot {
    public boolean move();

    public void turnLeft();

    public void turnRight();

    public void clean();
}

class Solution {

    private Robot robot;

    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private HashSet<String> hs = new HashSet<String>();

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        backTrack(1, 3, 0);
    }

    public void backTrack(int row, int col, int d) {
        String key = row + "-" + col;
        this.robot.clean();
        hs.add(key);
        for (int i = 0; i < 4; i++) {
            int newD = (i + d) % 4;
            int newR = row + directions[newD][0];
            int newC = col + directions[newD][1];

            if (!hs.contains(newR + "-" + newC) && robot.move()) {
                backTrack(newR, newC, newD);
                moveBack();
            }
            this.robot.turnRight();
        }
    }

    private void moveBack() {
        this.robot.turnRight();
        this.robot.turnRight();
        this.robot.move();
        this.robot.turnRight();
        this.robot.turnRight();
    }

}
