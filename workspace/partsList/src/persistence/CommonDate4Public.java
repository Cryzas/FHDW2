package persistence;


import model.visitor.*;

public interface CommonDate4Public extends Anything, AbstractPersistentProxi {
    
    public java.sql.Date getCreateDate() throws PersistenceException ;
    public java.sql.Date getCommitDate() throws PersistenceException ;
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException;
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    

}

