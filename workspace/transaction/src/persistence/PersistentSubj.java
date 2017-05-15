package persistence;


public interface PersistentSubj extends Anything, SubjInterface, AbstractPersistentProxi, Subj4Public {
    
    public Subj_ObserveeProxi getObservee() throws PersistenceException ;
    public PersistentSubj getThis() throws PersistenceException ;
    
    

}

