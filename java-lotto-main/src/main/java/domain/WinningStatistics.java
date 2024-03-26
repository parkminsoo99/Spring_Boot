package domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    public static Map<WinningRank, Integer> getWinningRank(Lottos lottos, WinningLotto winningLotto){
        Map<WinningRank, Integer> winningRanksMap = PushMap();
        for(Lotto lotto: lottos.getLottos()){
            int matchCount = FindingMatchCount(lotto, winningLotto);
            boolean containBounsNumber = FindingMatchBonus(lotto,winningLotto,matchCount);
            WinningRank winningRank = WinningRank.findingRank(matchCount,containBounsNumber);
            winningRanksMap.replace(winningRank,winningRanksMap.get(winningRank)+1);
            System.out.println(winningRanksMap.keySet());
            System.out.println(winningRanksMap.values());
        }
        return winningRanksMap;
    }
    private static int FindingMatchCount(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> numbers = lotto.getLotto(); //lottos
        List<Integer> winningLottoNumbers= winningLotto.getWinningLottos(); //getWinningLottos
        return (int) numbers.stream().filter(winningLottoNumbers::contains).count();
    }
    private static boolean FindingMatchBonus(Lotto lotto, WinningLotto winningLotto, int matchCount) {
        if(matchCount != 5){
            return false;
        }
        int winningBounsNumber = winningLotto.getBounsNumber();
        List<Integer> numbers = lotto.getLotto();
        return numbers.contains(winningBounsNumber);

    }
    private static Map<WinningRank, Integer> PushMap(){
        Map<WinningRank, Integer> initialWinningRank = new EnumMap<>(WinningRank.class);
        Arrays.stream(WinningRank.values()).forEach(winningrank -> initialWinningRank.put(winningrank,0));
        return initialWinningRank;
    }
    public static long getWinningAmount(Map<WinningRank, Integer> winningRanksMap){
        return winningRanksMap
                .entrySet()
                .stream()
                .mapToLong(entry -> (long) entry.getKey().getWinningPrice() * entry.getValue())// entry.getKey().getWinningPrice()가 정확히 뭘 리턴하는지 모르겠음
                .sum();
    }
    public static double IncomeCalculate(Map<WinningRank, Integer> winningRanksMap,int purchasedTickets){
//        System.out.println(getWinningAmount(winningRanksMap));
//        System.out.println((purchasedTickets));
//        System.out.println((getWinningAmount(winningRanksMap) / purchasedTickets) * 100);
        return (getWinningAmount(winningRanksMap) / purchasedTickets) * 100;
    }

}
