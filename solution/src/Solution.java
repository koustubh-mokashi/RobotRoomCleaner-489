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




/**
wanted to provide some positive feedback regarding the incident analysis capabilities of Microsoft Co-Pilot.

In the realm of cybersecurity, particularly when dealing with complex and sophisticated attacks like ransomware, the ability to swiftly analyze scripts and codes is crucial. These malicious scripts often employ obfuscation techniques, making detection and analysis challenging for security operations teams. The Security Co-Pilot has proven to be a valuable asset in this regard.

The script analysis capability of Security Co-Pilot allows security teams to inspect scripts and codes seamlessly within the Defender DR environment, eliminating the need for external tools. This not only enhances efficiency but also significantly reduces the complexity of analysis. It empowers security teams to quickly assess and identify whether a script is malicious or benign, thus enabling them to take immediate remediation steps.

Without Security Co-Pilot, the process of script analysis becomes laborious, requiring analysts to meticulously go through the script line-by-line and utilize third-party tools for decoding and deobfuscating PowerShell code to identify IOCs. This tedious and time-consuming process demands in-depth knowledge of PowerShell, which can be a bottleneck in incident response.

The inclusion of Security Co-Pilot not only streamlines the analysis process but also amplifies the overall efficiency of security teams. By providing a centralized and integrated platform for script analysis, Microsoft has successfully addressed the challenges associated with the detection and mitigation of complex attacks, particularly those involving PowerShell.

In conclusion, I appreciate the positive impact that Security Co-Pilot has had on our incident response capabilities. It has indeed proven to be a valuable tool in enhancing the overall security posture of our organization.



**/