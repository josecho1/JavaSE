package factory.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;



//Concrete factories:
class TrianguloAndGroso implements FactoriaPrincipal {

	public Shape makeShape() {
		return new Triangulo();
	}
	public Tipo makeTipo() {
		return new Grosa();
	}
}

class TrianguloAndFina implements FactoriaPrincipal {

	public Shape makeShape() {
		return new Triangulo();
	}
	public Tipo makeTipo() {
		return new Fina();
	}
}

class CirculoAndGroso implements FactoriaPrincipal {

	public Shape makeShape() {
		return new Circulo();
	}
	public Tipo makeTipo() {
		return new Grosa();
	}
}

class CirculoAndFina implements FactoriaPrincipal {

	public Shape makeShape() {
		return new Circulo();
	}
	public Tipo makeTipo() {
		return new Fina();
	}
}
class DesenhoEnvironment {
	private FactoriaPrincipal fprincipal;
	private Shape s;
	private Tipo tipo;
	public DesenhoEnvironment(FactoriaPrincipal factory) {
		fprincipal = factory;
		s = factory.makeShape();
		tipo = factory.makeTipo();
	}
	public void play() {
		s.deTipo(tipo);
		s.draw();
		s.erase();
	}
	public Shape getShape(){
		return s;
	}
}




public class AbstractShapeFactory {

	
	public static void main(String[] args) {

		String shlist[] = { "Circulo Groso", "Circulo Fino","Triangulo Groso", "Triangulo Fino" };
		List grosas = new ArrayList();
		List finas = new ArrayList();
		
		Iterator it = Arrays.asList(shlist).iterator();
		//while (it.hasNext())
			//shapes.add(ShapeFactory.createShape((String) it.next()));
		while (it.hasNext()) {
			String s = (String) it.next();
			if (s=="Circulo Groso"){
				FactoriaPrincipal cg= new CirculoAndGroso();
				DesenhoEnvironment d1 = new DesenhoEnvironment(cg);
				grosas.add(d1);
			}
			if (s=="Circulo Fino"){
				FactoriaPrincipal cf= new CirculoAndFina();
				DesenhoEnvironment d2 = new DesenhoEnvironment(cf);
				finas.add(d2);
			}
			if (s=="Triangulo Groso"){
				FactoriaPrincipal tg= new TrianguloAndGroso();
				DesenhoEnvironment d3 = new DesenhoEnvironment(tg);
				grosas.add(d3);
			}
			if (s=="Triangulo Fino"){
				FactoriaPrincipal tf= new TrianguloAndFina();
				DesenhoEnvironment d4 = new DesenhoEnvironment(tf);
				finas.add(d4);
			}
		}
		it=grosas.iterator();
		while (it.hasNext()) {
			DesenhoEnvironment dg = (DesenhoEnvironment) it.next();
			dg.play();
		}
		it=finas.iterator();
		while (it.hasNext()) {
			DesenhoEnvironment df = (DesenhoEnvironment) it.next();
			df.play();
		}

	}

}
