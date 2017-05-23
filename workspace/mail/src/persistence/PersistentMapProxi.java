package persistence;

public abstract class PersistentMapProxi<T1, T2 extends AbstractPersistentRoot> extends PersistentMapProxiWithCycleException<T1,T2> {
	
	public abstract T2 put(T1 key, T2 entry) throws PersistenceException;

}
