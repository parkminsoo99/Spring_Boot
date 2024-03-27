package Domain;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private static final String PRINT_UNDER_FIVE_LENGTH_ERROR = "차 이름은 5글자 이하로 입력해주세요";
    private static final String PRINT_DUPLICATE_NAME_ERROR = "동일한 여러 이름으로 사용할 수 없습니다.";
    private List<String> cars;
    public Cars(List<String> Cars){
        validate(Cars);
    }
    private void validate(List<String> Cars){
        if(isUnderFiveLength(Cars)){
            throw new IllegalArgumentException(PRINT_UNDER_FIVE_LENGTH_ERROR);
        }
        if (isDuplicateName(Cars)){
            throw new IllegalArgumentException(PRINT_DUPLICATE_NAME_ERROR);
        }
        this.cars = Cars;
    }

    private boolean isDuplicateName(List<String> cars) {
        int orignalLength = cars.size();
        Set<String> carMap = new HashSet<>(cars);
        return orignalLength != carMap.size();
    }

    private boolean isUnderFiveLength(List<String> cars) {
        return cars.stream().anyMatch(x-> x.length()>5);
    }
    public List<String> getCars(){
        return this.cars;
    }
}
