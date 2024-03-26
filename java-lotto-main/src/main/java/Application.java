import controller.LottoController;

import java.util.*;
//중복제거
public class Application {
    public static void main(String [] args) {
        LottoController lottoController = new LottoController();
        lottoController.lottostart();
    }
}
//    public static void main(String[] args) {
//        ArrayList<Integer> C;
//        int Match3;
//        int Match4;
//        int Match5;
//        int Match5_notbouns;
//        int Match6;
//        int Sum;
//        int [][] A;
//        try {
//            System.out.println("구입금액을 입력해 주세요.");
//            Scanner scanner = new Scanner(System.in);
//            int temp = scanner.nextInt();
//            if (temp % 1000 != 0) {
//                scanner.nextLine();
//                throw new IllegalArgumentException();
//            }
//            int tickets = temp / 1000;
//            System.out.println(tickets +"개를 구매했습니다.");
//            LottoNumber random_lotto = new LottoNumber(tickets);
//            random_lotto.printlottonumber();
//
//
//            System.out.println("당첨 번호를 입력해 주세요.");
//            String Input1 = scanner.next();
//            InputCorrectNumber inputCorrectNumber = new InputCorrectNumber(Input1);
//
//
//
//            System.out.println("보너스 번호를 입력해 주세요.");
//            int bonus = scanner.nextInt();
//
//            //ArrayList return
//            C = inputCorrectNumber.getArrayList();
//            A = random_lotto.getLottoNumber();
//
//            Match M = new Match(C,A,tickets,bonus);
//            M.IterationMatch();
//            Match3 = M.getMatct3();
//            Match4 = M.getMatct4();
//            Match5 = M.getMatct5();
//            Match5_notbouns = M.getMatch5_notbouns();
//            Match6 = M.getMatct6();
//            Sum = M.getSum();
//
//            Print P = new Print(Match3, Match4, Match5, Match5_notbouns, Match6,Sum,temp);
//            P.PrintCorrect();
//
//
//        } catch (IllegalArgumentException e){
//            System.out.println("[ERROR]");
//        }
//    }
//}
//class Match{
//    ArrayList<Integer> arrayList;
//    int [][] array;
//    int tickects;
//    int Matct3= 0;
//    int Matct4= 0;
//    int Matct5= 0;
//    int Match5_notbouns = 0;
//    int Matct6= 0;
//    int bouns;
//    int Sum=0;
//    Match(ArrayList<Integer> arrayList, int [][] array, int tickects, int bouns){
//        this.arrayList = arrayList;
//        this.array = array;
//        this.tickects = tickects;
//        this.bouns = bouns;
//    }
//    public void IterationMatch(){
//        for(int i = 0; i<tickects; i++){
//            int count = 0;
//            for(int j=0;j<arrayList.size(); j++){
//                if(array[i][j] == arrayList.get(j)) count+=1;
//            }
//            if (count == 3) {
//                this.Matct3 +=1;
//                this.Sum+=5000;
//            }
//            else if (count == 4){
//                this.Sum +=50000;
//                this.Matct4 +=1;
//            }
//            else if (count == 5){
//                this.Match5_notbouns+=1;
//                this.Sum+=1500000;
//                for(int j=0;j<arrayList.size(); j++) {
//                    if (array[i][j] == bouns){
//                        this.Match5_notbouns -=1;
//                        this.Sum-=1500000;
//                        this.Matct5+=1;
//                        this.Sum+=30000000;
//                    }
//                }
//            }
//            else if (count == 6) {
//                this.Sum+=2000000000;
//                this.Matct6 +=1;
//            }
//        }
//    }
//    public int getMatct3(){
//        return this.Matct3;
//    }
//    public int getMatct4(){
//        return this.Matct4;
//    }
//    public int getMatct5(){
//        return this.Matct5;
//    }
//    public int getMatch5_notbouns(){ // 수정된 메서드 이름
//        return this.Match5_notbouns; // 필드 값을 반환하도록 수정
//    }
//    public int getMatct6(){
//        return this.Matct6;
//    }
//    public int getSum(){
//        return this.Sum;
//    }
//}
//class Print{
//    int Match3;
//    int Match4;
//    int Match5;
//    int Match5_notbouns;
//    int Match6;
//    int Sum=0;
//    int Payment = 0;
//    Print(int Match3,int Match4,int Match5, int Match5_notbouns, int Match6, int Sum, int Payment){
//        this.Match3 = Match3;
//        this.Match4 = Match4;
//        this.Match5 = Match5;
//        this.Match5_notbouns = Match5_notbouns;
//        this.Match6 = Match6;
//        this.Sum = Sum;
//        this.Payment = Payment;
//    }
//    public void PrintCorrect(){
//        double number = 0;
//        number = ((double) this.Sum / this.Payment) * 100;
//        String roundedNumber = String.format("%.1f",number);
//        System.out.println("3개 일치 (5,000원) - "+this.Match3+"개");
//        System.out.println("4개 일치 (50,000원) - "+this.Match4+"개");
//        System.out.println("5개 일치 (1,500,000원) - "+this.Match5_notbouns+"개");
//        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+this.Match5+"개");
//        System.out.println("6개 일치 (2,000,000,000원) - "+this.Match6+"개");
//        System.out.println("총 수익률은"+roundedNumber+"%입니다.");
//    }
//}
////class
//class InputCorrectNumber{
//    ArrayList<Integer> correct = new ArrayList<>();
//    String Input1;
//    InputCorrectNumber(String Input1){
//        this.Input1 = Input1;
//        String [] Input2 = this.Input1.split(",");
//        for(String translate:Input2) correct.add(Integer.parseInt(translate.trim()));
//    }
//    public ArrayList<Integer> getArrayList(){
//        return correct;
//    }
//
//}
//class LottoNumber {
//    public int tickects;
//    int [][] array;
//    LottoNumber(int tickects) {
//        this.tickects = tickects;
//        this.array = new int[this.tickects][6];
//    }
//    public void printlottonumber(){
//        Random rand = new Random();
//        for (int i = 0; i< this.tickects; i++){
//            int j=0;
//            while(j<6){
//                int temp = rand.nextInt(45)+1;
//                CheckOverlap Check = new CheckOverlap(array, temp,i);
//                if(Check.Check()){
//                    array[i][j] = temp;
//                    j+=1;
//                }
//            }
//        }
//        PrintLottoNumber printLottoNumber = new PrintLottoNumber(array, this.tickects);
//    }
//    public int [][] getLottoNumber(){
//        return array;
//    }
//}
//
//class CheckOverlap{
//    int [][] array;
//    int CheckValue;
//    int Start;
//    CheckOverlap(int [][] array, int CheckValue, int Start){
//        this.array = array;
//        this.CheckValue = CheckValue;
//        this.Start = Start;
//    }
//    public boolean Check(){
//        for(int i=0;i<array[Start].length;i++){
//            if(array[Start][i] == CheckValue) return false;
//        }
//        return true;
//    }
//
//}
//class PrintLottoNumber{
//    PrintLottoNumber(int[][] array, int tickects){
//        for (int i = 0; i< tickects; i++) System.out.println("["+array[i][0]+", "+array[i][1]+", "+array[i][2]+", "+array[i][3]+", "+array[i][4]+", "+array[i][5]+"]");
//    }
//}
