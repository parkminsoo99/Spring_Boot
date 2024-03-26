package view;
import domain.Lottos;
import domain.WinningRank;

import java.util.Map;
import java.util.Scanner;

public class OutputView {
    private static final String HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";
    private static final String WINNING_DETAILS_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String WINNING_DETAILS_WITH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String LOTTO_YIELD_MESSAGE = "총 수익률은 %.1f%%입니다.\n";


    public static void HowManyLottosPurchase(int lottoTickets){
        System.out.printf(HOW_MANY_LOTTO_USER_PURCHASED_MESSAGE, lottoTickets);
    }
    public static void printLottos(Lottos lottos) {
        lottos.getLottos().stream().forEach(lotto -> System.out.println(lotto.getLotto().toString()));
    }
    public static void printCalculate(){
        System.out.println(WINNING_STATISTICS_MESSAGE);
    }
    public static void printCalculateDetails( Map<WinningRank, Integer> winningRanksMap){
        winningRanksMap.entrySet().stream()
                .filter(entry -> entry.getKey() !=  WinningRank.LAST_PLACE)
                .forEach(entry -> {
                    if(entry.getKey() == WinningRank.SECOND_PLACE){
                        printCalculateDetailsWithBouns(entry);
                        return;
                    }
                    printCalculateDetailsWithOutBouns(entry);

                });
    }
    public static void printCalculateDetailsWithBouns( Map.Entry<WinningRank, Integer> entry){
        System.out.printf(WINNING_DETAILS_WITH_BONUS_MESSAGE,
                entry.getKey().getMatcingCount(),
                entry.getKey().getWinningPrice(),
                entry.getValue());
    }
    public static void printCalculateDetailsWithOutBouns( Map.Entry<WinningRank, Integer> entry){
        System.out.printf(WINNING_DETAILS_MESSAGE,
                entry.getKey().getMatcingCount(),
                entry.getKey().getWinningPrice(),
                entry.getValue()
                );

    }
    public static void printLottoYield(double yield){
        System.out.printf(LOTTO_YIELD_MESSAGE,yield);

    }

}
