package persistence;


public interface PersistentCommandCoordinator extends Anything, AbstractPersistentProxi, CommandCoordinator4Public {
    
    public CommandCoordinator_ExecuterProxi getExecuter() throws PersistenceException ;
    
    

}

