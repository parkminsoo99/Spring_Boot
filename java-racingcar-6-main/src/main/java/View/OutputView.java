package View;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    public static final String excuteNumbers = "실행 결과";
    public static final String racingWinners = "최종 우승자 : ";

    public static void PrintBeforeExcuteRacingBanner(){
        System.out.println(excuteNumbers);
    }
    public static void PrintExcuteRacing(Map<String,Integer> carRacingMap){
        List<String> CarsString = carRacingMap.keySet().stream().collect(Collectors.toList());
        for(String str:CarsString){
            System.out.print(str);
            System.out.print(" : ");
            OutputView.PrintExcuteProgress(str, carRacingMap);
            System.out.println();
        }
        System.out.println();
    }
    private static void PrintExcuteProgress(String str, Map<String,Integer> carRacingMap){
        int progressLength = carRacingMap.get(str);
        for(int j = 0; j<progressLength; j++){
            System.out.print("-");
        }
    }
    public static void PrintRacingWinners(List<String> maxString){
        System.out.print(racingWinners);
        int lengthStringList = maxString.size();
        for(int i=0;i<lengthStringList;i++){
            System.out.print(maxString.get(i));
            if(i!=lengthStringList-1) System.out.print(", ");
        }
    }
}

