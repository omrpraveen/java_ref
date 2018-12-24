package interfaces.functional.predicateex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

	public static Predicate<TestDto> isSeniorCitizen() {
		return test -> test.getAge() > 59;
	}

	public static List<TestDto> ageFilter(List<TestDto> dtoList, Predicate<TestDto> predicate) {
		return dtoList.stream().filter(predicate).collect(Collectors.toList());
	}

	public static void main(String args[]) {
		List<TestDto> list = Arrays.asList(new TestDto("Praveen",10),new TestDto("Kannan",100));
		System.out.println(ageFilter(list, isSeniorCitizen()));
	}

}
