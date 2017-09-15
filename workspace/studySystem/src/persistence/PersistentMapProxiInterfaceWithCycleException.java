package persistence;

import java.util.Iterator;

import model.UserException;
import model.CycleException;

public interface PersistentMapProxiInterfaceWithCycleException<K, T extends AbstractPersistentRoot> {

	T put(K key, T entry) throws PersistenceException, CycleException;
	T get(K key) throws PersistenceException;
	T remove(K key) throws PersistenceException; 
	SearchListRoot<T> getValues() throws PersistenceException;
	
	Iterator<T> iterator() throws PersistenceException;
	
	T findFirst (Predcate<T> predicate) throws PersistenceException;
	SearchListRoot<T> findAll (Predcate<T> predicate) throws PersistenceException;
	void filter (Predcate<T> predicate) throws PersistenceException;
	void removeFirstFailure (Predcate<T> predicate) throws PersistenceException;
	void removeFirstSuccess (Predcate<T> predicate) throws PersistenceException;
	void applyToAll (Procdure<T> procedure) throws PersistenceException;
	<R> R aggregate (Aggregtion<T,R> aggregation) throws PersistenceException;
	<E extends UserException> T findFirstException (PredcateException<T, E> predicate) throws PersistenceException, E;
	<E extends UserException> SearchListRoot<T> findAllException (PredcateException<T, E> predicate) throws PersistenceException, E;
	<E extends UserException> void filterException (PredcateException<T, E> predicate) throws PersistenceException, E;
	<E extends UserException> void removeFirstFailureException (PredcateException<T, E> predicate) throws PersistenceException, E;
	<E extends UserException> void removeFirstSuccessException (PredcateException<T, E> predicate) throws PersistenceException, E;
	<E extends UserException> void applyToAllException (ProcdureException<T, E> procedure) throws PersistenceException, E;
	<E extends UserException,R> R aggregateException (AggregtionException<T,R, E> aggregation) throws PersistenceException, E;

}
