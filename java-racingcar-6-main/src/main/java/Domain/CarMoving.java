package Domain;
import java.util.*;

public class CarMoving {
    private static int INITIAL_VALUE = 0;
    public static Map<String, Integer> getCarMovingMap(List<String> cars, int count){
        Map<String, Integer> carMovingMap = pushMap(cars);
        System.out.println(carMovingMap.keySet());
        carMovingMap = RacingWinner.getCarsRacingCal(carMovingMap,cars,count);

        return carMovingMap;
    }

    private static Map<String, Integer> pushMap(List<String> cars) {
        Map<String, Integer> initialMap = new LinkedHashMap<>();
        cars.stream().forEach(x->initialMap.put(x,INITIAL_VALUE));
        return initialMap;
    }
}
