package practice_serialization;

import java.io.File;

import tools.jackson.databind.ObjectMapper;

public class Run2_JacksonDeSerTest {
	
	public static void main(String[] args) {
		ObjectMapper objMap=new ObjectMapper();
		Project pobj=objMap.readValue(new File("./project.json"), Project.class); // Project is a name of the pojo class
	
	System.out.println(pobj.getProjectName());
	System.out.println(pobj.getCreatedBy());
	System.out.println(pobj.getTeamSize());
	System.out.println(pobj.getStatus());
	}

}
