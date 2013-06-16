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

import javax.persistence.*;

import dao.example3.daojpa.dao.GenericDAO;

import java.util.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Implements the generic CRUD data access operations using Java Persistence APIs.
 * <p>
 * To write a DAO, subclass and parameterize this class with your entity.
 * Of course, assuming that you have a traditional 1:1 appraoch for
 * Entity:DAO design. This is actually an implementation that uses some
 * extensions for Java Persistence from Hibernate - you can see how the
 * packages for the extensions are not imported, but named inline.
 *
 * @author José Luis Villaverde
 */
public abstract class GenericEJB3DAO<T,ID extends Serializable>
        implements GenericDAO<T, ID> {

    private Class<T> entityBeanType;

    private EntityManager em;

    
    public GenericEJB3DAO() {
        this.entityBeanType = (Class<T>) ((ParameterizedType) getClass()
                                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    // If this DAO is wired in as a Seam component, Seam injects the right persistence context
    // if a method on this DAO is called. If the caller is a conversational stateful component,
    // the persistence context will be scoped to the conversation, not to the method call.
    // You can call this method and set the EntityManager manually, in an integration test.
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    //The entityManager and entityBeanType fields are protected so that subclasses, i.e. specific GenericDAO implementations,
    // can access them.
    protected EntityManager getEntityManager() {
        if (em == null)
            throw new IllegalStateException("EntityManager has not been set on DAO before usage");
        return em;
    }

    protected Class<T> getEntityBeanType() {
        return entityBeanType;
    }
    
    /*public Class<T> getEntityBeanType() {
        return entityBeanType;
    }*/

        
    public T findById(ID id) {
        T entity;
        entity = getEntityManager().find(getEntityBeanType(), id);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return getEntityManager().createQuery("from " + getEntityBeanType().getName() ).getResultList();
    }

    public T makePersistent(T entity) {
        return getEntityManager().merge(entity);
    }

    public void makeTransient(T entity) {
        getEntityManager().remove(entity);
    }

    public void flush() {
        getEntityManager().flush();
    }

    public void clear() {
        getEntityManager().clear();
    }

}

