
package model.meta;

import persistence.*;
import model.*;
import model.visitor.*;


/* Additional import section end */

public class CommandExecuter extends PersistentObject implements PersistentCommandExecuter{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static CommandExecuter4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade.getClass(objectId);
        return (CommandExecuter4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static CommandExecuter4Public createCommandExecuter() throws PersistenceException{
        return createCommandExecuter(false);
    }
    
    public static CommandExecuter4Public createCommandExecuter(boolean delayed$Persistence) throws PersistenceException {
        PersistentCommandExecuter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
                .newDelayedCommandExecuter();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
                .newCommandExecuter(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static CommandExecuter4Public createCommandExecuter(boolean delayed$Persistence,CommandExecuter4Public This) throws PersistenceException {
        PersistentCommandExecuter result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
                .newDelayedCommandExecuter();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
                .newCommandExecuter(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    @SuppressWarnings("unchecked")
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
        java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf){
                result = (java.util.HashMap<String,Object>)allResults.get(uniqueKey);
                if (result != null) return result;
            }
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, inDerived);
            if (leaf) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CommandExecuter_CommandsProxi commands;
    
    public CommandExecuter(long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.commands = new CommandExecuter_CommandsProxi(this);        
    }
    
    static public long getTypeId() {
        return -105;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -105) ConnectionHandler.getTheConnectionHandler().theCommandExecuterFacade
            .newCommandExecuter(this.getId());
        super.store();
        this.getCommands().store();
        
    }
    
    public CommandExecuter_CommandsProxi getCommands() throws PersistenceException {
        return this.commands;
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
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        
		if(this.isTheSameAs(This)){
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public synchronized Command commandGet() 
				throws PersistenceException{
        while (!this.getCommands().iterator().hasNext()){
			try {
				this.wait();
			}catch(InterruptedException ie){
				return null;
			}
		}
		java.util.Iterator<Command> commands = this.getCommands().iterator();
		Command command = commands.next();
		return command;
    }
    public synchronized void commandPut(final Command command) 
				throws PersistenceException{
        this.getCommands().add(command);
		this.notify();
    }
    public synchronized void finishCommand(final CommitConnectionHandler handler, final long signal) 
				throws PersistenceException{
        java.util.Iterator<Command> commands = this.getCommands().iterator();
		Command command = commands.next();
		commands.remove();
		if (signal == 0) ((PersistentCommonDate)command).setCommitDate(new java.sql.Date(new java.util.Date().getTime()));
		else ((PersistentCommonDate)command).setCommitDate(new java.sql.Date(signal));
		handler.commit();
    }
    public void handleFatalException(final Throwable t, final Command c) 
				throws PersistenceException{
        //TODO: implement method: handleFatalException
        
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        this.initializeOnInstantiation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        this.start();
    }
    public void interrupt() 
				throws PersistenceException{
        myThread.interrupt();
    }
    public boolean isAlive() 
				throws PersistenceException{
        return myThread.isAlive();
    }
    public void run() {
        try {
			CommitConnectionHandler handler = (CommitConnectionHandler)ConnectionHandler.getTheConnectionHandler(); 
			handler.beginWork();
			while(!Thread.currentThread().isInterrupted()){
				Command command = this.commandGet();
				if (command == null) {
					System.out.println("CommanExecuter terminated due to interrupt!");
					return;
				}
				handler.setCommand(command);
				if (command != null){
					try {
						handler.setInTransaction(true);
						command.execute();
						handler.setInTransaction(false);
						command.checkException();
						this.finishCommand(handler, 0);
						command.sendResult();
					} catch (UserException ue){
						handler.rollback();
						this.finishCommand(handler, 86400000);
						command.sendResult();
					} catch (PersistenceException pee){
						handler.rollback();
						this.finishCommand(handler, 86400000 * 2);
						command.sendException(pee);
					}catch (Throwable t){
						handler.rollback();
						this.handleFatalException(t, command);
						this.finishCommand(handler, 86400000 * 3);
						System.out.println("CommanExecuter terminated due to fatal error!" + t.getMessage());
						t.printStackTrace();
						return;
					}
				}
			}
		}catch(PersistenceException pe){
			return;
		}
    }
    public void start() 
				throws PersistenceException{
        myThread = new Thread(this, "CommandExecuter " + this.getId());
		ConnectionHandler connection = ConnectionHandler.getNewConnection(myThread);
		connection.connect(DBConnectionConstants.DataBaseName,
			DBConnectionConstants.SchemaName,
			DBConnectionConstants.UserName,
			DBConnectionConstants.Password,
			false);
		myThread.start();
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
	private Thread myThread;

    /* End of protected part that is not overridden by persistence generator */
    
}
