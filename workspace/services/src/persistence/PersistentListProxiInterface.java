package persistence;

import java.util.Iterator;

import model.UserException;

public interface PersistentListProxiInterface<T extends AbstractPersistentRoot> {

	void store() throws PersistenceException;
	
	void add (T entry) throws PersistenceException, UserException;
	
	long getLength() throws PersistenceException;
	
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
