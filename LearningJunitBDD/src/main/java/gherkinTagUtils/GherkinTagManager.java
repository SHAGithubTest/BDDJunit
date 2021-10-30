package gherkinTagUtils;

import io.cucumber.java.Scenario;

public class GherkinTagManager {
	
	public static ThreadLocal<GherkinTagAction> tlGherkinTag = new ThreadLocal<>();
	
	public static void setGherkinTag(Scenario gherkinScenario)
	{
		tlGherkinTag.set(new GherkinTagAction());
		getGherkinTag().getGherkinTagValue(gherkinScenario);
	}
	
	public static GherkinTagAction getGherkinTag()
	{
		return tlGherkinTag.get();
		
	}
	
	
	

}
