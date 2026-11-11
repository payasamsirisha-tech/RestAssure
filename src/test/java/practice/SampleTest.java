package practice;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import tools.jackson.databind.ObjectMapper;

//public class SampleTest {
	
//	@Test
//	public void sampleGetReqTest() {
//		Response resp=RestAssured.get("https://reqres.in/api/users?page=2");
//		System.out.println(resp.prettyPrint());
//	}
public class SampleTest{
	String projectName;
	String projectStatus;
	int teamSize;
	List<String> teamMember;
	List<ProjectManager> projectManager;
	
	public SampleTest(String projectName, String projectStatus, int teamSize, List<String> teamMember,
			List<ProjectManager> projectManager) {
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

	public List<ProjectManager> getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(List<ProjectManager> projectManager) {
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

 class Run3_POJO {

	public static void main(String[] args) throws Exception {
		List<String>lst=new ArrayList<String>();
		lst.add("Jhon");
		lst.add("devid");
		lst.add("Stev");
		ProjectManager pm=new ProjectManager("surya", "tp_02");
		ProjectManager pm1=new ProjectManager("s", "tap_06");
		List<ProjectManager> pro= Arrays.asList(pm,pm1);
		
		
//		List<ProjectManager> pro=new ArrayList<ProjectManager>();
//		pro.add(new ProjectManager("surya", "tp_02"));
//		pro.add(new ProjectManager("s", "tap_06"));
		
		
//		List<ProjectManager> pro=new ArrayList<ProjectManager>();
//		ProjectManager pm=new ProjectManager("surya", "tp_02");
//		ProjectManager pm1=new ProjectManager("s", "tap_06");
//		pro.add(pm);
//		pro.add(pm1);
		
		
		SampleTest pobj=new SampleTest("orange", "created", 5, lst, pro);
		
		//System.out.println(pobj.projectName);
		ObjectMapper objmap=new ObjectMapper();
		objmap.writeValue(new File("./Projectser.json"), pobj);
		System.out.println("============");
		
		

	}

}




