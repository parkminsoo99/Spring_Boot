package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoGenerator {
    private final List<Lotto> lottos = new ArrayList<>();
    private int INITIAL_MONEY = 1_000;
    private int LottoTickets = 0;
    private String MONEY_ERROR = "[ERROR]1,000원 단위로 입력해주세요.";
    public LottoGenerator(int money){
        ValidateMoney(money);
        this.LottoTickets = money / INITIAL_MONEY;
    }

    private void ValidateMoney(int money){
        if(isZeroNumber(money)||!isCanDivide(money))
            throw new IllegalArgumentException(MONEY_ERROR);
    }

    private boolean isZeroNumber(int money){
        return money <= 0;
    }
    private boolean isCanDivide(int money){
        return money % INITIAL_MONEY == 0;
    }
    public List<Lotto> generateLottos(){
        int count = 0;
        while(count < LottoTickets){
            try{
                Lotto lotto = generateLotto();
                lottos.add(lotto);
                count++;
            }catch (IllegalArgumentException e){}
        }
        return lottos;
    }
    private Lotto generateLotto(){
        Random random = new Random();
        List<Integer> randomNumbers = new ArrayList<>();
        for(int i =0; i<6;i++){
            randomNumbers.add(random.nextInt(45)+1);
        }
        Collections.sort(randomNumbers);
        return new Lotto(randomNumbers);
    }
    public int getLottoTickets(){
        return this.LottoTickets;
    }
    public int getInitialMoney(){
        return this.LottoTickets * INITIAL_MONEY;
    }
}
