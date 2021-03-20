import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class A_OA0314 {
    public static List<List<Integer>> routePairs(int maxTravelDis, List<List<Integer>> forwardRouteList,
                                                 List<List<Integer>> returnRouteList){
//        Collections.sort(forwardRouteList,(a, b)->(a.get(1) - b.get(1)));
//        Collections.sort(returnRouteList, (a, b)->(a.get(1) - b.get(1)));
        forwardRouteList.sort(Comparator.comparingInt(a -> a.get(1)));
        returnRouteList.sort(Comparator.comparingInt(a -> a.get(1)));
        List<List<Integer>> result = new ArrayList<>();
        int mostCloseDis = 0;
        int forIdx = 0;
        int returnIdx = returnRouteList.size() - 1;
        while(forIdx < forwardRouteList.size() && returnIdx >= 0){
            Integer forDis = forwardRouteList.get(forIdx).get(1);
            Integer returnDis = returnRouteList.get(returnIdx).get(1);
            Integer fullDis = forDis + returnDis;
            if(fullDis > maxTravelDis){
                returnIdx--;
            }else if(fullDis <= maxTravelDis){
                if(fullDis > mostCloseDis){
                    result.clear();
                    mostCloseDis = fullDis;
                }
                ArrayList<Integer> forCode = new ArrayList<>();
                forCode.add(forwardRouteList.get(forIdx).get(0));
                ArrayList<Integer> returnCode = new ArrayList<>();
                returnCode.add(returnRouteList.get(returnIdx).get(0));
                while(forIdx + 1 < forwardRouteList.size() &&
                        forwardRouteList.get(forIdx).get(1) == forwardRouteList.get(forIdx + 1).get(1)){
                    forIdx++;
                    forCode.add(forwardRouteList.get(forIdx).get(0));
                }
                while(returnIdx - 1 >= 0 &&
                        returnRouteList.get(returnIdx).get(1) == returnRouteList.get(returnIdx - 1).get(1)){
                    returnIdx--;
                    returnCode.add(returnRouteList.get(returnIdx).get(0));
                }
                for(int i = 0; i < forCode.size(); i++){
                    for(int j = 0; j < returnCode.size(); j++){
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(forCode.get(i));
                        tmp.add(returnCode.get(j));
                        result.add(tmp);
                    }
                }
                forIdx++;
            }

        }
        return result;
    }
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(System.out);

        A_OA0314 test = new A_OA0314();
//        test.routePairs();

        pw.println();
        pw.flush();
        pw.close();
    }
}
