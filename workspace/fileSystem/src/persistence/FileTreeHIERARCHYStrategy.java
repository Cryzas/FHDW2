package persistence;


/* Additional import section end */

public interface FileTreeHIERARCHYStrategy<T> {
    
    
    public T Directory$$contents$$$initialize(final Directory4Public ths) 
				throws PersistenceException;
    public T Directory$$contents$$consolidate(final Directory4Public ths, final T result, final T current) 
				throws PersistenceException;
    public T Directory$$finalize(final Directory4Public ths, final T contents) 
				throws PersistenceException;
    public T File$$finalize(final File4Public ths) 
				throws PersistenceException;

    
}

