package practice_serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable {
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name, int level, long score, int life) {
		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
	
}

public class Run1_ser {

	public static void main(String[] args) throws Throwable {
		NFSGame user1obj=new NFSGame("siri", 5, 20000, 5);
		FileOutputStream fileout=new FileOutputStream("./f.txt");
		ObjectOutputStream objout=new ObjectOutputStream(fileout);
		objout.writeObject(user1obj);
		System.out.println("=====end======");

	}
}
