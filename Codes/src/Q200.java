import java.util.Stack;

public class Q200 {

    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1'){
                    count ++;
                    grid[i][j] = '0';
                    Stack<XandY> paths = getConnections(grid, i, j);
                    while (paths.size() > 0){
                        XandY current = paths.pop();
                        if (grid[current.x][current.y] == '1'){
                            grid[current.x][current.y] = '0';
                            paths.addAll(getConnections(grid, current.x, current.y));
                        }
                    }
                }
            }
        }

        return count;
    }

    public Stack<XandY> getConnections(char[][] grid, int x, int y){
        Stack<XandY> targets = new Stack<>();
        
        if (x-1 >= 0 && grid[x-1][y] != '0') targets.add(new XandY(x-1, y));
        if (y-1 >= 0 && grid[x][y-1] != '0') targets.add(new XandY(x, y-1));
        if (x+1 < grid.length && grid[x+1][y] != '0') targets.add(new XandY(x+1, y));
        if (y+1 < grid[0].length && grid[x][y+1] != '0') targets.add(new XandY(x, y+1));
        return targets;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
        Q200 question = new Q200();
        System.out.println(question.numIslands(grid));
    }

}

class XandY {
    int x;
    int y;

    public XandY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}