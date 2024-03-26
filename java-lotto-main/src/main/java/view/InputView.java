package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String NOT_NUMBER = "[ERROR] 숫자가 아닌 값이 입력됐습니다.";

    public static int PurchaseTickect(){
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        try{
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
    public static List<Integer> getInputLottoNumbers(){
        System.out.println(LOTTO_NUMBER_MESSAGE);
        try{
            Scanner scanner = new Scanner(System.in);
            List<Integer> userInputLottoNumber = new ArrayList<Integer>();
            String [] userInput = scanner.next().split(",");
            for(String str:userInput) userInputLottoNumber.add(Integer.parseInt(str.trim()));
            return userInputLottoNumber;
        }catch (NumberFormatException numberFormatException){
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }
    public static int getInputBounsNumber(){
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
        try{
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        } catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}
