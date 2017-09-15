package persistence;


public interface PersistentCommandExecuter extends Anything, Runnable, AbstractPersistentProxi, CommandExecuter4Public {
    
    public CommandExecuter_CommandsProxi getCommands() throws PersistenceException ;
    
    

}

