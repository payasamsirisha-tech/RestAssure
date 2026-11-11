package practice_serialization;

import java.io.File;

import tools.jackson.databind.ObjectMapper;

class Project{    //POJO--->Plain old java object
	
private String projectName;
private String createdBy;
private int teamSize;	
private String status;

//emppty constructor is for deserialization
private Project(){}

public Project(String projectName, String createdBy, int teamSize, String status) {
	super();
	this.projectName = projectName;
	this.createdBy = createdBy;
	this.teamSize = teamSize;
	this.status = status;
}

public String getProjectName() {
	return projectName;
}

public void setProjectName(String projectName) {
	this.projectName = projectName;
}

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public int getTeamSize() {
	return teamSize;
}

public void setTeamSize(int teamSize) {
	this.teamSize = teamSize;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

	
}
public class Run1_JacksonSerTest {
	public static void main(String[] args) {
		Project pobj=new Project("orange", "siri", 5, "Created");
		
		ObjectMapper objMap=new ObjectMapper();
		objMap.writeValue(new File("./project.json"), pobj);
		System.out.println("====end====");
	}

}
