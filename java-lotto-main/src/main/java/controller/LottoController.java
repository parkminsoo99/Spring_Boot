package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static view.InputView.PurchaseTickect;

public class LottoController {
    public void lottostart(){
        try{
            int PurchaseTicket = PurchaseTickect();
            //lottoGenerator객체를 만들고 돈을 보내서 검증
            LottoGenerator lottoGenerator = new LottoGenerator(PurchaseTicket);
            //생성한 로또 번호를 Lottos클래스에 저장
            Lottos lottos = new Lottos(lottoGenerator.generateLottos());
            printLottosInformation(lottoGenerator,lottos);
            WinningLotto winningLotto = new WinningLotto(InputView.getInputLottoNumbers(), InputView.getInputBounsNumber());
            Map<WinningRank,Integer> winningDetails = WinningStatistics.getWinningRank(lottos,winningLotto);
            printWinningInformation(winningDetails,PurchaseTicket);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
    private void printLottosInformation(LottoGenerator lottoGenerator,Lottos lottos){
        OutputView.HowManyLottosPurchase(lottoGenerator.getLottoTickets());
        OutputView.printLottos(lottos);
    }
    private void printWinningInformation(Map<WinningRank, Integer> winningLotto, int PurchaseTicket){
        OutputView.printCalculate();
        OutputView.printCalculateDetails(winningLotto);
        double yield = WinningStatistics.IncomeCalculate(winningLotto, PurchaseTicket);
        OutputView.printLottoYield(yield);
    }
}
