package persistence;


public interface PersistentMail extends Anything, AbstractPersistentProxi, Mail4Public {
    
    public void setSubject(String newValue) throws PersistenceException ;
    public void setText(String newValue) throws PersistenceException ;
    public abstract PersistentMail getThis() throws PersistenceException ;
    
    

}

