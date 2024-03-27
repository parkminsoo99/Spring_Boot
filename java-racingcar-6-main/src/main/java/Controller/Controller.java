package Controller;

import Domain.CarMoving;
import Domain.Cars;
import Domain.RacingWinner;
import Domain.RacingWinnerDetermine;
import View.InputView;
import View.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    public void Gamestart() {
        try{
            Map<String,Integer> winner = (CarMoving.getCarMovingMap(InputView.getCars(),InputView.getCount()));
            RacingWinnerDetermine.getRacingWinner(winner);
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println(e);
        }
    }
}
