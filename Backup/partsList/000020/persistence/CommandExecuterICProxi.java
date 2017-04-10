package persistence;



import model.visitor.*;

public class CommandExecuterICProxi extends PersistentInCacheProxi implements PersistentCommandExecuter{
    
    public CommandExecuterICProxi(long objectId) {
        super(objectId);
    }
    public CommandExecuterICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
            .getCommandExecuter(this.getId());
    }
    
    public long getClassId() {
        return -105;
    }
    
    public CommandExecuter_CommandsProxi getCommands() throws PersistenceException {
        return ((PersistentCommandExecuter)this.getTheObject()).getCommands();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCommandExecuter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommandExecuter(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommandExecuter(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommandExecuter(this);
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).initialize(This, final$$Fields);
    }
    public Command commandGet() 
				throws PersistenceException{
        return ((PersistentCommandExecuter)this.getTheObject()).commandGet();
    }
    public void commandPut(final Command command) 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).commandPut(command);
    }
    public void finishCommand(final CommitConnectionHandler handler, final long signal) 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).finishCommand(handler, signal);
    }
    public void handleFatalException(final Throwable t, final Command c) 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).handleFatalException(t, c);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).initializeOnInstantiation();
    }
    public void interrupt() 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).interrupt();
    }
    public boolean isAlive() 
				throws PersistenceException{
        return ((PersistentCommandExecuter)this.getTheObject()).isAlive();
    }
    public void run() {
        try{
            ((PersistentCommandExecuter)this.getTheObject()).run();
        }catch(PersistenceException pe){
            throw new PersistenceError(pe);
        }
    }
    public void start() 
				throws PersistenceException{
        ((PersistentCommandExecuter)this.getTheObject()).start();
    }

    
}
