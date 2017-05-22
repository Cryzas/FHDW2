package persistence;

import java.util.Iterator;

public class PersistentMapIterator<K, T extends AbstractPersistentRoot> implements Iterator<T> {

	Iterator<T> baseIterator;
	T current;
	PersistentMapProxiWithCycleException<K,T> mapProxi;

	public PersistentMapIterator(PersistentMapProxiWithCycleException<K,T> mapProxi, java.util.Hashtable<K,T> table) throws PersistenceException {
		this.mapProxi = mapProxi;
		this.baseIterator = table.values().iterator();
	}
	public boolean hasNext(){
		return this.baseIterator.hasNext();
	}
	public T next() {
		this.current = this.baseIterator.next();
		return current;
	}
	public void remove() {
		try {
			this.mapProxi.removeEntry(current);
		}catch (PersistenceException e) {
		  throw new PersistenceError(e);
		}
		this.baseIterator.remove();
	}
}