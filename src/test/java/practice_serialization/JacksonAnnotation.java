package practice_serialization;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import tools.jackson.databind.ObjectMapper;



//it will change the order of the creation like first come createBy npt projectname
@JsonPropertyOrder(

		value= { "createdBy",
				"projectName",
				"teamSize",
				"status"
		}
		)
//it will hide team size
@JsonIgnoreProperties(
		value= {
				"teamSize"
		},allowSetters =true
		)



class Annotation{    //POJO--->Plain old java object
	private String projectName;

	//it will give the space for variables..
	//generally in java we are not givon any sace so by using this we ca give
	
	@JsonProperty(value ="create By")
	private String createdBy;
	private int teamSize;	
	private String status;

	//emppty constructor is for deserialization
	private Annotation(){}

	public Annotation(String projectName, String createdBy, int teamSize, String status) {
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
public class JacksonAnnotation {
	public static void main(String[] args) {
		Annotation pobj=new Annotation("orange", "siri", 5, "Created");

		ObjectMapper objMap=new ObjectMapper();
		objMap.writeValue(new File("./project.json"), pobj);
		System.out.println("====end====");
	}

}
