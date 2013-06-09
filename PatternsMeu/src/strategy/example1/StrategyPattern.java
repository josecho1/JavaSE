package strategy.example1;


//The strategy interface:
interface Resolve {
// Line is a sequence of points:
	int algorithm(int number);
}

//The various strategies:
class Suma implements Resolve {
	public int algorithm(int number) {
		int suma = number + number;
		return suma; 
	}	
}

class Mult implements Resolve {
	public int algorithm(int number) {
		int doble = number * number;
		return doble; 
	}	
}

class Divide implements Resolve {
	public int algorithm(int number) {
		int one = number / number;
		return one; 
	}	
}	

//The "Context" controls the strategy:
class ResultResolve {
	
	private Resolve strategy;
	public ResultResolve(Resolve strat) {
			strategy = strat;
	}
	int result(int line) {
		return strategy.algorithm(line);
	}
	void changeAlgorithm(Resolve newAlgorithm) {
		strategy = newAlgorithm;
	}
}

public class StrategyPattern {
	public static void main(String[] args) {
		
		int number=9;
		
		ResultResolve context =new ResultResolve(new Suma());
		System.out.println(context.result(number));
		
		context.changeAlgorithm(new Mult());
		System.out.println(context.result(number));	  
		
		context.changeAlgorithm(new Divide());
		System.out.println(context.result(number));	 
	}
}
