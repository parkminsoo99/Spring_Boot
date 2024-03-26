package domain;

import java.util.Arrays;

public enum WinningRank {
    LAST_PLACE(0,false,0),
    FIFTH_PLACE(3,false,5_000),
    FOURTH_PLACE(4,false,50_000),
    THIRD_PLACE(5,false,1_500_000),
    SECOND_PLACE(5,true,30_000_000),
    FIRST_PLACE(6,false,2_000_000_000);
    private final int matcingCount;
    private final boolean isBonus;
    private final int money;
    WinningRank(int matcingCount, boolean isBonus, int money){
        this.matcingCount = matcingCount;
        this.isBonus = isBonus;
        this.money = money;
    }
    public static WinningRank findingRank(int matcingCount, boolean isBonus){
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matcingCount == matcingCount)
                .filter(winningRank -> winningRank.isBonus == isBonus)
                .findFirst()
                .orElse(WinningRank.LAST_PLACE);
    }
    public int getWinningPrice(){
        return this.money;
    }
    public int getMatcingCount(){
        return this.matcingCount;
    }

}
