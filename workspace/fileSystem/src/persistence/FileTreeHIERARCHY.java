package persistence;

import model.visitor.*;

/* Additional import section end */

public interface FileTreeHIERARCHY extends AbstractPersistentProxi {
    
    
    public boolean containsFileTree(final FileTreeHIERARCHY part) 
				throws PersistenceException;
    public <T> T strategyFileTree(final FileTreeHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;

    public void accept(FileTreeHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(FileTreeHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(FileTreeHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(FileTreeHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

