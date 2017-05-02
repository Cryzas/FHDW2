package persistence;

public interface PersistentMapProxi<T1, T2 extends AbstractPersistentRoot> extends PersistentMapProxiWithCycleException<T1,T2> {
	
	T2 put(T1 key, T2 entry) throws PersistenceException;

}
