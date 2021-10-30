package testRunner;

import java.util.stream.Stream;

public class JarRunner {

	private static String[] defaultOptions = {"classpath:","src/test/resources/features/remFeature/", "--glue", "stepDefs", "--plugin", "pretty"};

	public static void main(String[] args) {
		Stream<String> cucumberOptions = Stream.concat(Stream.of(defaultOptions), Stream.of(args));
		cucumber.api.cli.Main.main(cucumberOptions.toArray(String[]::new));
	}

	

}


