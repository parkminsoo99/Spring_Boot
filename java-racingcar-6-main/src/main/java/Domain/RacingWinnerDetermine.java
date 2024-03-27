package Domain;

import View.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingWinnerDetermine {
    public static void getRacingWinner(Map<String,Integer> winner){
        final int maxValue = winner.values().stream().max(Integer::compare).orElseThrow(() -> new IllegalArgumentException("Map is empty"));
        List<String> maxString = winner.entrySet().stream().filter(x->x.getValue() == maxValue).map(Map.Entry::getKey).collect(Collectors.toList());
        OutputView.PrintRacingWinners(maxString);
    }

}
