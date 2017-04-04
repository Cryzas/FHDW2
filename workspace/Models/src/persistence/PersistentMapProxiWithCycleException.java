package persistence;

import model.CycleException;

public interface PersistentMapProxiWithCycleException<T1, T2 extends AbstractPersistentRoot> {
	
	void put(T1 key, T2 entry) throws PersistenceException, CycleException;
	T2 get(T1 key) throws PersistenceException;
	void remove(T1 key) throws PersistenceException; 
	SearchListRoot<T2> getValues() throws PersistenceException;

}
