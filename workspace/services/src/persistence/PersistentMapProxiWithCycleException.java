package persistence;

import model.CycleException;

public abstract class PersistentMapProxiWithCycleException<T1, T2 extends AbstractPersistentRoot> extends SearchListRoot<T2> {
	
	public abstract T2 put(T1 key, T2 entry) throws PersistenceException, CycleException;
	public abstract T2 get(T1 key) throws PersistenceException;
	public abstract T2 remove(T1 key) throws PersistenceException; 
	protected abstract void removeEntry(T2 entry) throws PersistenceException;
	public abstract SearchListRoot<T2> getValues() throws PersistenceException;
	public abstract java.util.Iterator<T2> iterator();
	@Override
	protected java.util.Vector<T2> getData() {
		try {
			return this.getValues().getData();
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}

}
