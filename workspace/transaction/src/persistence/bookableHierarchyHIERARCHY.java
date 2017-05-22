package persistence;

import model.visitor.*;

/* Additional import section end */

public interface bookableHierarchyHIERARCHY extends AbstractPersistentProxi {
    
    
    public boolean containsbookableHierarchy(final bookableHierarchyHIERARCHY part) 
				throws PersistenceException;
    public <T> T strategybookableHierarchy(final bookableHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;

    public void accept(bookableHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(bookableHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(bookableHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(bookableHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
}

