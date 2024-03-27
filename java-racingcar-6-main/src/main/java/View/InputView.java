package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String inputCarNames = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String inputTryNumbers = "시도할 회수는 몇회인가요?";
    private static final Scanner scanner = new Scanner(System.in);
    public static List<String> getCars(){
        try{
            System.out.println(inputCarNames);
            String [] userInput = scanner.next().split(",");
            List<String> userInputList = new ArrayList<>();
            for(String str:userInput) userInputList.add(str);
            return userInputList;
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
    public static int getCount(){
        try{
            System.out.println(inputTryNumbers);
            return scanner.nextInt();
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }

}
