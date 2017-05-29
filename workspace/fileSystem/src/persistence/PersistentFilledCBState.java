package persistence;


public interface PersistentFilledCBState extends PersistentClipBoardState, FilledCBState4Public {
    
    public void setContents(Containee4Public newValue) throws PersistenceException ;
    public PersistentFilledCBState getThis() throws PersistenceException ;
    
    

}

