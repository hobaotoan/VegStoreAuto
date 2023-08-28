package cucumber.utils;

public class IssueType{
	public enum Type {
		 Bug,
		 Task,
		 Subtask,
		 Story
	}

	public enum JIRA {
		CREATE,
		NON_CREATE
	}
	
	public enum LabelJira {
		Automation,
		Manual,
		Integration,
		Regression
	}
}
