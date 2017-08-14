package persistence;

import java.util.Iterator;
import java.util.Vector;
import java.util.HashMap;

import model.UserException;

public abstract class SearchListRoot<T extends AbstractPersistentRoot> {

	static public class DecoratorIterator<U> implements java.util.Iterator<U> {
		private Iterator<? extends Decoratees> internalIterator;
		public DecoratorIterator(java.util.Iterator<? extends Decoratees> internalIterator){
			this.internalIterator = internalIterator;
		}
		public boolean hasNext() {
			return this.internalIterator.hasNext();
		}
		@SuppressWarnings("unchecked")
		public U next() {
			return (U) this.internalIterator.next().createDecorator();
		}
		public void remove() {
			this.internalIterator.remove();
		}
	}


	abstract protected Vector<T> getData();

	protected SearchListRoot(){
	}
	public void add (T entry) throws PersistenceException, UserException {
		this.getData().add(entry);
	}
	public void add(SearchListRoot<? extends T> list) throws PersistenceException, UserException{
		java.util.Iterator<? extends T> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public void addUnique (T entry) throws PersistenceException, UserException {
		if (!this.getData().contains(entry)) this.getData().add(entry);
	}
	public void addUnique(SearchListRoot<? extends T> list) throws PersistenceException, UserException {
		java.util.Iterator<? extends T> entries = list.iterator();
		while (entries.hasNext()){
			this.addUnique(entries.next());
		}
	}
	public void removeFirst(final T toBeDeleted) throws PersistenceException {
		this.removeFirstSuccess(new Predcate<T>() {
			public boolean test(T argument) throws PersistenceException {
				return argument.isTheSameAs(toBeDeleted);
			}
		});
	}
	public void removeAll(final T toBeDeleted) throws PersistenceException {
		this.filter(new Predcate<T>() {
			public boolean test(T argument) throws PersistenceException {
				return !argument.isTheSameAs(toBeDeleted);
			}
		});
	}
	public long getLength() throws PersistenceException{
		return this.getData().size();
	}
	public Iterator<T> iterator() throws PersistenceException {
		return getData().iterator();
	}
	public T findFirst (Predcate<T> predicate) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) return current;
		}
		return null;
	}
	public SearchListRoot<T> findAll (Predcate<T> predicate) throws PersistenceException{
		SearchListRoot<T> result = new DefaultSearchListRoot<T>(){};
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) result.getData().add(current);
		}
		return result;
	}
	public void filter (Predcate<T> predicate) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (!predicate.test(current)) i.remove();
		}
	}
	public void removeFirstFailure (Predcate<T> predicate) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (!predicate.test(current)) {
				i.remove();
				return;
			}
		}
	}
	public void removeFirstSuccess (Predcate<T> predicate) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) {
				i.remove();
				return;
			}
		}
	}
	
	public void applyToAll (Procdure<T> procedure) throws PersistenceException{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			procedure.doItTo(current);
		}
	}
	public <R> R aggregate (R neutral, Aggregtor<T,R> aggregator) throws PersistenceException{
		R result = neutral;
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			result = aggregator.compose(result,current);
		}
		return result;
	}
	public <R> R aggregate (Aggregtion<T,R> aggregation) throws PersistenceException{
		R result = aggregation.neutral();
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			result = aggregation.compose(result,current);
		}
		return result;
	}
	public <E extends UserException> T findFirstException (PredcateException<T, E> predicate) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) return current;
		}
		return null;
	}
	public <E extends UserException> SearchListRoot<T> findAllException (PredcateException<T, E> predicate) throws PersistenceException, E{
		SearchListRoot<T> result = new DefaultSearchListRoot<T>(){};
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)) result.getData().add(current);
		}
		return result;
	}
	public <E extends UserException> void filterException (PredcateException<T, E> predicate) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (!predicate.test(current)) i.remove();
		}
	}
	public <E extends UserException> void removeFirstFailureException (PredcateException<T, E> predicate) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (!predicate.test(current)){
				i.remove();
				return;
			}
		}
	}
	public <E extends UserException> void removeFirstSuccessException (PredcateException<T, E> predicate) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			if (predicate.test(current)){
				i.remove();
				return;
			}
		}
	}
	public <E extends UserException> void applyToAllException (ProcdureException<T, E> procedure) throws PersistenceException, E{
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			procedure.doItTo(current);
		}
	}
	public <R,E extends UserException> R aggregateException (AggregtionException<T,R, E> aggregation) throws PersistenceException, E{
		R result = aggregation.neutral();
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			result = aggregation.compose(result,current);
		}
		return result;
	}
	public <R,E extends UserException> R aggregateException (R neutral, AggregtorException<T,R,E> aggregator) throws PersistenceException, E{
		R result = neutral;
		Iterator<T> i = this.iterator();
		while (i.hasNext()){
			T current = i.next();
			result = aggregator.compose(result,current);
		}
		return result;
	}
	
	public <R extends AbstractPersistentRoot> SearchListRoot<R> productFunction (Fnction<T,R> function, boolean unique) throws PersistenceException, UserException{
		SearchListRoot<R> result = new DefaultSearchListRoot<R>(){};
		Iterator<T> entries = this.iterator();
		while (entries.hasNext()){
			T current = entries.next();
			R value = function.apply(current);
			if (value != null){
				if (unique) result.addUnique(value);
				else result.add(value);				
			}
		}
		return result;
	}
	public <R extends AbstractPersistentRoot> SearchListRoot<R> productMultiValuedFunction (Fnction<T, SearchListRoot<R>> function, boolean unique) throws PersistenceException, UserException{
		SearchListRoot<R> result = new DefaultSearchListRoot<R>(){};
		Iterator<T> entries = this.iterator();
		while (entries.hasNext()){
			T current = entries.next();
			SearchListRoot<R> value = function.apply(current);
			if (unique) result.addUnique(value); 
			else result.add(value);
		}
		return result;
	}
	public Vector<String> getVector(int depth, int essentialLevel, boolean forGUI, boolean asLeaf, boolean withLeafInfo) throws PersistenceException{
		return this.getVector(new HashMap<String, Object>(), depth, essentialLevel, forGUI, asLeaf, withLeafInfo, false, false, false);
	}
	public Vector<String> getVector(java.util.HashMap<String, Object> allResults, int depth, 
																				  int essentialLevel, 
																				  boolean forGUI, 
																				  boolean asLeaf, 
																				  boolean withLeafInfo,
																				  boolean forDerived,
																				  boolean forTransient,
																				  boolean forEssential) throws PersistenceException {
		Vector<String> result = new Vector<String>();
		Iterator<T> entries = this.iterator();
		while (entries.hasNext()){
			T current = entries.next();
			String proxiInformation = calculateProxiInfoAndRecursiveGet(
					current, allResults, depth, essentialLevel, forGUI, asLeaf, withLeafInfo, 
					forDerived, forTransient, forEssential);
			result.add(proxiInformation);
		}
		return result;
	}

	static public <T extends AbstractPersistentRoot> String calculateProxiInfoAndRecursiveGet(T objct, java.util.HashMap<String, Object> allResults, 
													 int depth, int essentialLevel, boolean forGUI, boolean asLeaf, boolean withLeafInfo, 
													 boolean forDerived, boolean forTransient, boolean forEssential) throws PersistenceException {
		int nextDepth = depth;
		int nextEssentialLevel = essentialLevel;
		boolean nextInDerived = false;
		if (forDerived && (forTransient || objct.isDelayed$Persistence())){
			nextInDerived = true;
		} else {
			if (forEssential || (forGUI && objct.hasEssentialFields())){
				nextEssentialLevel = nextEssentialLevel + 1;
			} else {
				nextDepth = nextDepth - 1;
			}
		}
		objct.toHashtable(allResults, nextDepth, nextEssentialLevel, forGUI, true, nextInDerived);
		String proxiInformation = objct.createProxiInformation(asLeaf, withLeafInfo);
		return proxiInformation;
	}


	/*@SuppressWarnings("unchecked")
	public Vector<HashMap> getVector(int depth) throws PersistenceException {
		Vector<HashMap> result = new Vector<HashMap>();
		Iterator<T> entries = this.iterator();
		while (entries.hasNext()){
			AbstractPersistentRoot current = entries.next();
			long currentId = current.getId();
			long currentClassId = current.getClassId();
			HashMap<String,Object> hashtableEntry = new HashMap<String,Object>();
			if (depth == 0) {
				hashtableEntry.put("id", new Long(currentId).toString());
				hashtableEntry.put("classId", new Long(currentClassId).toString());
			}else{
				hashtableEntry = PersistentProxi.createProxi(currentId, currentClassId).toHashtable(depth - 1);
			}
			result.add(hashtableEntry);
		}
		return result;
	}*/
}
