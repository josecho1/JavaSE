package factory.example1;



class Circulo implements Shape {
	public void deTipo(Tipo tp) {
		System.out.println("Circulo de tipo");
		tp.mostrar();
	}
	public void draw() {
		System.out.println("Circle.draw");
	}
	public void erase() {
		System.out.println("Circle.erase");
	}
}