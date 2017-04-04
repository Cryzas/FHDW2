package persistence;

public interface PersistentMapProxi<T1, T2 extends AbstractPersistentRoot> extends PersistentMapProxiWithCycleException<T1,T2> {
	
	void put(T1 key, T2 entry) throws PersistenceException;

}
