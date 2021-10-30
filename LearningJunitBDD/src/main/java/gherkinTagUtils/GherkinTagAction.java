package gherkinTagUtils;

import io.cucumber.java.Scenario;

public class GherkinTagAction {

	public String gherkinTestTag = null;

	public String getGherkinTagValue(Scenario gherkinScenario) {

		for (String gherkinTag : gherkinScenario.getSourceTagNames()) {
			//System.out.println(":::::gherkinTag::::" + gherkinTag);

			if (gherkinTag.contains("@Test_id")) {
				gherkinTestTag = gherkinTag;
				break;
			}

		}

		//System.out.println("::::::::::::::::::Final Test ID:::::" + gherkinTestTag);

		return gherkinTestTag;

	}

}
