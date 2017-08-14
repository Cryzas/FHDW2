package persistence;


/* Additional import section end */

public interface ObsInterface extends AbstractPersistentProxi {
    
    
    public void update(final model.meta.Mssgs event) 
				throws PersistenceException;

    
}

