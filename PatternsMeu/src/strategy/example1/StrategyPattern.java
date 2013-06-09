
/*DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

Copyright 2013 José Luis Villaverde Balsa.

This file is part of PatternsMeu.

    PatternsMeu is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    PatternsMeu is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
*/
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
