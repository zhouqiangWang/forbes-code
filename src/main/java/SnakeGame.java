public class SnakeGame {

    int[][] screen;
    int foodIdx = 0;
    int[] snk;
    int[] snkTail;
    int count = 0;
    int[][] food;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    public SnakeGame(int width, int height, int[][] food) {
        screen = new int[height][width];
        // snake is 1;
        // food is -1;
        screen[0][0] = 1;
        snk = new int[]{0, 0};
        snkTail = new int[]{0, 0};
        if (foodIdx < food.length) {
            int[] pos = food[foodIdx++];
            screen[pos[0]][pos[1]] = -1;
        }
        this.food = food;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int move(String direction) {
        int newR = snk[0];
        int newC = snk[1];
        switch (direction) {
            case "U":
                newR--;
                break;
            case "L":
                newC--;
                break;
            case "R":
                newC++;
                break;
            case "D":
                newR++;
                break;
            default :
                return -1;
        }
        if (newR < 0 || newR >= screen.length || newC < 0 || newC >= screen[0].length || screen[newR][newC] > 0) {
            return -1;
        }
        if (screen[newR][newC] == -1) {
            screen[newR][newC] = 1;
            snk[0] = newR;
            snk[1] = newC;
            if (foodIdx < food.length) {
                int[] pos = food[foodIdx++];
                screen[pos[0]][pos[1]] = -1;
            }
            screen[snkTail[0]][snkTail[1]] = (++count) + 1;
        } else {
            screen[newR][newC] = 1;
            snk[0] = newR;
            snk[1] = newC;
            screen[snkTail[0]][snkTail[1]] = 0;
            for (int[] dir : dirs) {
                int tailR = snkTail[0] + dir[0];
                int tailC = snkTail[1] + dir[1];
                if (tailR >= 0 && tailC >= 0 && tailR < screen.length && tailC < screen[0].length && screen[tailR][tailC] == (count + 1)) {
                    snkTail[0] = tailR;
                    snkTail[1] = tailC;
                    screen[tailR][tailC] = count + 1;
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        SnakeGame instance = new SnakeGame(2, 2, new int[][] {{1,1},{0,0}});
        System.out.println(instance.move("R"));
        System.out.println(instance.move("D"));
        System.out.println(instance.move("L"));
        System.out.println(instance.move("U"));
        System.out.println(instance.move("R"));
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */