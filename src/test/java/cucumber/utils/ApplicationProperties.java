package cucumber.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum ApplicationProperties {
	 INSTANCE;

    private final Properties properties;

    ApplicationProperties() {
        properties = new Properties();
        try {
        	properties.load(new FileReader("src/test/resources/profile/environment.properties"));
        } catch (IOException e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public String getUrl() {
        return properties.getProperty("rootUrl");
    }
    public String getUrlOfDA() {
        return properties.getProperty("rootUrlDA");
    }
    
    public String getUserName() {
        return properties.getProperty("username");
    }
    
    public String getPassword() {
        return properties.getProperty("password");
    }
    
    public String getAPIToken() {
    	return properties.getProperty("api.token");
    }
    
    public String getEmailProject() {
		return properties.getProperty("email.project");
	}
    
    public String getRootPathProject() {
		return properties.getProperty("root.path.project");
	}
    
    public String getProjectName() {
		return properties.getProperty("project.name");
	}
    
    public String getReporterName() {
		return properties.getProperty("reporter.name");
	}
    
    public String getAssigneeName() {
		return properties.getProperty("assignee.name");
	}
    
    public String getPriorityName() {
		return properties.getProperty("priority.name");
	}
    
    public String getLabelsName() {
		return properties.getProperty("labels.name");
	}
    
    public String getFormatActualMessage() {
		return properties.getProperty("actual.name");
	}
    
    public String getFormatExpectedMessage() {
  		return properties.getProperty("expected.name");
  	}
    
    public String getJiraIssue() {
  		return properties.getProperty("create.jira.name");
  	}
    
    public String getDefaultWWait() {
  		return properties.getProperty("default.wait.value");
  	}
    
    public String getDefaultTaskName() {
  		return properties.getProperty("default.id.task");
  	}
    
    public String getDefaultBlockIssue() {
  		return properties.getProperty("default.block.issue");
  	}
}
