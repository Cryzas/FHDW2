
package model.meta;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class CommandCoordinator extends PersistentObject implements PersistentCommandCoordinator{
    
    private static CommandCoordinator4Public theCommandCoordinator = null;
    private static boolean reset$For$Test = false;
    private static final Object $$lock = new Object();
    public static CommandCoordinator4Public getTheCommandCoordinator() throws PersistenceException{
        if (theCommandCoordinator == null || reset$For$Test){
            if (reset$For$Test) theCommandCoordinator = null;
            class Initializer implements Runnable {
                PersistenceException exception = null;
                public void /* internal */ run(){
                    this.produceSingleton();
                }
                void produceSingleton() {
                    synchronized ($$lock){
                        try {
                            CommandCoordinator4Public proxi = null;
                            proxi = ConnectionHandler.getTheConnectionHandler().theCommandCoordinatorFacade.getTheCommandCoordinator();
                            theCommandCoordinator = proxi;
                            if(proxi.getId() < 0) {
                                ((AbstractPersistentRoot)proxi).setId(proxi.getId() * -1);
                                proxi.initialize(proxi, new java.util.HashMap<String,Object>());
                                proxi.initializeOnCreation();
                            }
                        } catch (PersistenceException e){
                            exception = e;
                        } finally {
                            $$lock.notify();
                        }
                        
                    }
                }
                CommandCoordinator4Public getResult() throws PersistenceException{
                    synchronized ($$lock) {
                        if (exception == null && theCommandCoordinator== null) try {$$lock.wait();} catch (InterruptedException e) {}
                        if(exception != null) throw exception;
                        return theCommandCoordinator;
                    }
                }
                
            }
            reset$For$Test = false;
            Initializer initializer = new Initializer();
            new Thread(initializer).start();
            return initializer.getResult();
        }
        return theCommandCoordinator;
    }
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected CommandCoordinator_ExecuterProxi executer;
    
    public CommandCoordinator(long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.executer = new CommandCoordinator_ExecuterProxi(this);        
    }
    
    static public long getTypeId() {
        return -101;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        // Singletons cannot be delayed!
    }
    
    public CommandCoordinator_ExecuterProxi getExecuter() throws PersistenceException {
        return this.executer;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCommandCoordinator(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCommandCoordinator(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCommandCoordinator(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCommandCoordinator(this);
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
    
    public void coordinate(final Command command) 
				throws PersistenceException{
        CommandExecuter4Public executer;
		if (!this.getExecuter().iterator().hasNext()){
			executer = CommandExecuter.createCommandExecuter();
			this.getExecuter().add(executer);
			
		}
		executer = this.getExecuter().iterator().next();
		if (!executer.isAlive()) throw new PersistenceException("Fatal error: Transaction executer has terminated!", 0);
		executer.commandPut(command);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        this.initializeOnInstantiation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    public void interrupt() 
				throws PersistenceException{
        java.util.Iterator<CommandExecuter4Public> currentExecuters = this.getExecuter().iterator();
		while (currentExecuters.hasNext()){
			CommandExecuter4Public executer = currentExecuters.next();
			executer.interrupt();
		}
    }
    public void restart() 
				throws PersistenceException{
        java.util.Iterator<CommandExecuter4Public> currentExecuters = this.getExecuter().iterator();
		while (currentExecuters.hasNext()){
			CommandExecuter4Public executer = currentExecuters.next();
			if (!executer.isAlive()) executer.start();
		}
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
