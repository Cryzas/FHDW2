package persistence;


/* Additional import section end */

public interface bookableHierarchyHIERARCHYStrategy<T> {
    
    
    public T Transaction$$finalize(final Transaction4Public ths, final T transfers) 
				throws PersistenceException;
    public T Transaction$$transfers$$$initialize(final Transaction4Public ths) 
				throws PersistenceException;
    public T Transaction$$transfers$$consolidate(final Transaction4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T Transfer$$finalize(final Transfer4Public ths) 
				throws PersistenceException;

    
}

