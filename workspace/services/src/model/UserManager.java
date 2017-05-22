
package model;

import persistence.*;
import model.meta.ServiceSwitchPARAMETER;
import model.meta.StringFACTORY;
import model.visitor.*;


/* Additional import section end */

public class UserManager extends model.Service implements PersistentUserManager{
    
    
    public static UserManager4Public createUserManager() throws PersistenceException{
        return createUserManager(false);
    }
    
    public static UserManager4Public createUserManager(boolean delayed$Persistence) throws PersistenceException {
        PersistentUserManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUserManagerFacade
                .newDelayedUserManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUserManagerFacade
                .newUserManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static UserManager4Public createUserManager(boolean delayed$Persistence,UserManager4Public This) throws PersistenceException {
        PersistentUserManager result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUserManagerFacade
                .newDelayedUserManager();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUserManagerFacade
                .newUserManager(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.HashMap<String,Object> toHashtable(java.util.HashMap<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.HashMap<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("crrntServers", this.getCrrntServers().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, true));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.containsKey(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public UserManager provideCopy() throws PersistenceException{
        UserManager result = this;
        result = new UserManager(this.This, 
                                 this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected UserManager_CrrntServersProxi crrntServers;
    
    public UserManager(PersistentService This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentService)This,id);
        this.crrntServers = new UserManager_CrrntServersProxi(this);        
    }
    
    static public long getTypeId() {
        return -116;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -116) ConnectionHandler.getTheConnectionHandler().theUserManagerFacade
            .newUserManager(this.getId());
        super.store();
        this.getCrrntServers().store();
        
    }
    
    public UserManager_CrrntServersProxi getCrrntServers() throws PersistenceException {
        return this.crrntServers;
    }
    public PersistentUserManager getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUserManager result = (PersistentUserManager)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentUserManager)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManager(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManager(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManager(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManager(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManager(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManager(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleUserManager(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManager(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManager(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManager(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getCrrntServers().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUserManager)This);
		if(this.isTheSameAs(This)){
		}
    }
    public String userManager_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addRight(final Server4Public srvr, final String type) 
				throws model.UserHasRightException, PersistenceException{
    	Service4Public serv = StringFACTORY.createObjectBySubTypeNameForService(type, new ServiceSwitchPARAMETER() {
			
			@Override
			public UserManager4Public handleUserManager() throws PersistenceException {
				return UserManager.createUserManager();
			}
			
			@Override
			public Register4Public handleRegister() throws PersistenceException {
				return Register.createRegister();
			}
			
			@Override
			public Customer4Public handleCustomer() throws PersistenceException {
				return Customer.createCustomer();
			}
			
			@Override
			public Administrator4Public handleAdministrator() throws PersistenceException {
				return Administrator.createAdministrator();
			}
		});
    	if (srvr.getServices().findFirst(argument -> argument.getClassId() == serv.getClassId()) == null) {
    		srvr.getServices().add(serv);
        	getThis().signalChanged(true);
		} else {
			throw new UserHasRightException("Behindert? Der hat das schon!!! Geh dich erhängen!!!");
		}
    	
    }
    public void connected(final String user) 
				throws PersistenceException{
        //TODO: implement method: connected
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void disconnected() 
				throws PersistenceException{
        //TODO: implement method: disconnected
        
    }
    public void findServer(final String name) 
				throws PersistenceException{
    	ServerSearchList foundServers = Server.getServerByUser(name);
    	foundServers.applyToAll(new Procdure<Server4Public>() {
			
			@Override
			public void doItTo(Server4Public foundServer) throws PersistenceException {
				if (getThis().getCrrntServers().findFirst(new Predcate<Server4Public>() {

					@Override
					public boolean test(Server4Public argument) throws PersistenceException {
						return argument.equals(foundServer);
					}
				}) == null) getThis().getCrrntServers().add(foundServer);
			}
		});
    	getThis().signalChanged(true);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
		//TODO: implement method: initializeOnCreation
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
		//TODO: implement method: initializeOnInstantiation
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
