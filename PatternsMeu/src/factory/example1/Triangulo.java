package factory.example1;



class Triangulo implements Shape {
	public void deTipo(Tipo tp) {
		System.out.println("Triangulo de tipo");
		tp.mostrar();
	}
	public void draw() {
		System.out.println("Triangulo.draw");
	}
	public void erase() {
		System.out.println("Triangulo.erase");
	}
}