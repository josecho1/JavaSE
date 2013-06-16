package singleton.example3.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class TestBreakSingleton3 {

	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BreakSingleton3 bs = new BreakSingleton3();

		OutputStream out = new FileOutputStream("/home/tx/git/JavaSE/PatternsMeu/a.ser");
		ObjectOutputStream oout = new ObjectOutputStream(out);
		oout.writeObject(bs);
		oout.flush();
		oout.close();
		//out.flush();
		//out.close();

		InputStream in = new FileInputStream("/home/tx/git/JavaSE/PatternsMeu/a.ser");
		ObjectInputStream oin = new ObjectInputStream(in);
		BreakSingleton3 bs1 = (BreakSingleton3)oin.readObject();
		oin.close();
		in.close();

		System.out.println("Instance from Serialization :::"+bs1.getInstance2());
		System.out.println("Normal Instance :::"+Singleton3.getInstance());

		InputStream in1 = new FileInputStream("/home/tx/git/JavaSE/PatternsMeu/a.ser");
		ObjectInputStream oin1 = new ObjectInputStream(in1);
		BreakSingleton3 bs2 = (BreakSingleton3)oin1.readObject();
		oin1.close();
		in1.close();
		System.out.println("Another Instance from Serialization :::"+bs2.getInstance2());
	}
		

}


