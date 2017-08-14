package persistence;

public interface PersistentMapProxiInterface<K, T extends AbstractPersistentRoot> extends PersistentMapProxiInterfaceWithCycleException<K,T> {
	
	T put(K key, T entry) throws PersistenceException;

}
