package practice_serialization;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import tools.jackson.databind.ObjectMapper;

class Project1{
	String projectName;
	String projectStatus;
	int teamSize;
	List<String> teamMember;
	ProjectManager projectManager;
	
	public Project1(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	
}

class ProjectManager{
	String name;
	String empId;
	public ProjectManager(String name, String empId) {
		super();
		this.name = name;
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
}

public class Run3_POJO {

	public static void main(String[] args) throws Exception {
		List<String>lst=new ArrayList<String>();
		lst.add("Jhon");
		lst.add("devid");
		lst.add("Stev");
		ProjectManager pm=new ProjectManager("sagar", "tp_02");
		
		Project1 pobj=new Project1("orange", "created", 5, lst, pm);
		
		//System.out.println(pobj.projectName);
		ObjectMapper objmap=new ObjectMapper();
		objmap.writeValue(new File("./Project1.json"), pobj);
		
		

	}

}
