package Domain;

import View.OutputView;

import java.util.*;
import java.util.stream.Collectors;

public class RacingWinner {
    public static Map<String, Integer> getCarsRacingCal(Map<String,Integer> carMovingMap, List<String> cars, int count) {
        Map<String, Integer> carRacingMap;
        OutputView.PrintBeforeExcuteRacingBanner();
        for (int i = 0; i < count; i++) {
            carRacingMap = getCarRacingRandomValue(cars);
            List<String> upperFourth = carRacingMap
                    .entrySet()
                    .stream()
                    .filter(x -> x.getValue() >= 4)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            for (String key : upperFourth) {
                carMovingMap.put(key, carMovingMap.get(key) + 1);
            }
            OutputView.PrintExcuteRacing(carMovingMap);
        }
        return carMovingMap;
    }


    private static Map<String,Integer> getCarRacingRandomValue(List<String> cars){
        Random random = new Random();
        Map<String, Integer> carRacingMapRandomValueMap = new HashMap<>();
        cars.stream().forEach(x->carRacingMapRandomValueMap.put(x,random.nextInt(10)+1));
        return carRacingMapRandomValueMap;
    }
}
