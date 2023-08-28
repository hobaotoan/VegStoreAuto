package cucumber.utils;

import com.github.javafaker.Faker;

public class GenerateFakerName {

	private Faker faker = new Faker();

	public String getGenerateName() {
		return faker.name().firstName();
	}

}
