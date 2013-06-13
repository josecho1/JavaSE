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
package dao.example3.daojpa.ejb3;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import dao.example3.daojpa.dao.CarDAO;
import dao.example3.daojpa.model.Car;

/**
 * EJB3-specific implementation of the <tt>UserDataAccess</tt> non-CRUD data access object.
 *
 * @author José Luis Villaverde
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CarDAOBean extends GenericEJB3DAO<Car, Long> implements CarDAO{
	
	public List<Car> getAllCars() {
		return findAll();
	}
	
	public Car getCar(long id) {
		return findById(id);
	}
	
	public void updateCar(Car car) {
		makePersistent(car);
	}
	
	public void deleteCar(Car car) {
		makeTransient(car);
	}

}
