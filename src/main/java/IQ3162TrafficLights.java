public class IQ3162TrafficLights {
    int drive(int[][] map) {
        return map[0][0];
    }
    public static void main(String[] args) {
        IQ3162TrafficLights test = new IQ3162TrafficLights();
        int[][] map = new int[][] {{1,2,0,3},{4,6,5,1},{9,2,5,7},{5,4,2,2}};

        System.out.println("answer = " + test.drive(map));
    }
}
