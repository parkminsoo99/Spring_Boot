package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {
    private final List<Integer> winningLottos;
    private final int bounsNumber;

    public WinningLotto(List<Integer> winningLottos, int bounsNumber){
        WinningLottoValidate(winningLottos);
        WinningBounsNumberValidate(bounsNumber, winningLottos);
        this.winningLottos = winningLottos;
        this.bounsNumber = bounsNumber;
    }

    private void WinningBounsNumberValidate(int bounsNumber, List<Integer> winningLottos) {
        if(isBetweenBounsNumber(bounsNumber)) throw new IllegalArgumentException("1~45숫자 중 입력하세요.");
        else if (isDuplicateBounsNumber(bounsNumber,winningLottos)) throw new IllegalArgumentException("당첨 숫자랑 중복된 숫자 입력하지 마세요.");
    }

    private boolean isDuplicateBounsNumber(int bounsNumber, List<Integer> winningLottos) {
        return winningLottos.contains(bounsNumber);
    }

    private boolean isBetweenBounsNumber(int bounsNumber) {
        return bounsNumber <= 0 || bounsNumber > 45;
    }

    private void WinningLottoValidate(List<Integer> winningLottos) {
        if(isBetween(winningLottos)) throw new IllegalArgumentException("1~45숫자 중 입력하세요.");
        else if (isDuplicate(winningLottos)) throw new IllegalArgumentException("당첨 숫자는 6개며, 중복된 숫자 입력하지 마세요.");
    }

    private boolean isDuplicate(List<Integer> winningLottos) {
        Set<Integer> duplicateChecker = new HashSet<>(winningLottos);
        return winningLottos.size() != 6;
    }

    private boolean isBetween(List<Integer> winningLottos) {
        return winningLottos.stream().anyMatch(integer -> integer <= 0 || integer > 45);

    }
    public List<Integer> getWinningLottos(){
        return this.winningLottos;
    }
    public int getBounsNumber(){
        return this.bounsNumber;
    }

}
