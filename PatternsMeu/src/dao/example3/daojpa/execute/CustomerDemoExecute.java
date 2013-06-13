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
package dao.example3.daojpa.execute;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import dao.example3.daojpa.dao.CarDAO;
import dao.example3.daojpa.dao.CustomerDAO;
import dao.example3.daojpa.ejb3.CarDAOBean;
import dao.example3.daojpa.ejb3.CustomerDAOBean;
import dao.example3.daojpa.ejb3.GenericEJB3DAO;
import dao.example3.daojpa.model.Car;
import dao.example3.daojpa.model.Customer;


public class CustomerDemoExecute {
	
	private static final String PERSISTENCE_UNIT_NAME = "daojpa";
	private static EntityManagerFactory factory;
	
	public static void main(String[] args) throws NotSupportedException, SystemException, SecurityException, IllegalStateException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
		
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		CustomerDAO customerDAO = new CustomerDAOBean();
		((GenericEJB3DAO) customerDAO).setEntityManager(em);
		Customer customer1 = new Customer();
		customer1.setName("Ana");
		customer1 = customerDAO.makePersistent(customer1);
		Customer customer2 = new Customer();
		customer2.setName("Pedro");
		customerDAO.makePersistent(customer2);
		System.out.println(customerDAO.findAll());
		
		CarDAO carDAO = new CarDAOBean();
		((GenericEJB3DAO) carDAO).setEntityManager(em);
		Car car1 = new Car("Seat","Ibiza");
		car1 = carDAO.makePersistent(car1);
		Car car2 = new Car("Seat","Toledo");
		car2 = carDAO.makePersistent(car2);
		System.out.println(carDAO.findAll());
		
		em.getTransaction().commit();
		em.close();
	}
}
