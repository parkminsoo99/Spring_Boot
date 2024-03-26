package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(!isSizeNumber(numbers)||isDuplicateNumber(numbers))
            throw new IllegalArgumentException();
    }
    private boolean isSizeNumber(List<Integer> numbers){
        return numbers.size() == 6;
    }
    private boolean isDuplicateNumber(List<Integer> numbers){
        Set<Integer> duplicateChecker = new HashSet<>(numbers);
        return duplicateChecker.size() != 6;
    }
    public List<Integer> getLotto(){
        return this.numbers;
    }
}
