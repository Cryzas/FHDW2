
package model;

import persistence.*;
import model.visitor.*;

/* Additional import section end */

public class UserManagerService extends model.subAdminService implements PersistentUserManagerService{
    
    
    public static UserManagerService4Public createUserManagerService(AdminService4Public parentService) throws PersistenceException{
        return createUserManagerService(parentService,false);
    }
    
    public static UserManagerService4Public createUserManagerService(AdminService4Public parentService,boolean delayed$Persistence) throws PersistenceException {
        PersistentUserManagerService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUserManagerServiceFacade
                .newDelayedUserManagerService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUserManagerServiceFacade
                .newUserManagerService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("parentService", parentService);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static UserManagerService4Public createUserManagerService(AdminService4Public parentService,boolean delayed$Persistence,UserManagerService4Public This) throws PersistenceException {
        PersistentUserManagerService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUserManagerServiceFacade
                .newDelayedUserManagerService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUserManagerServiceFacade
                .newUserManagerService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("parentService", parentService);
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
            result.put("users", this.getUsers().getVector(allResults, depth, essentialLevel, forGUI, true, true, inDerived, false, false));
        }
        return result;
    }
    
    public UserManagerService provideCopy() throws PersistenceException{
        UserManagerService result = this;
        result = new UserManagerService(this.parentService, 
                                        this.subService, 
                                        this.This, 
                                        this.getId());
        result.errors = this.errors.copy(result);
        result.errors = this.errors.copy(result);
        result.users = this.users.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected UserManagerService_UsersProxi users;
    
    public UserManagerService(PersistentAdminService parentService,SubjInterface subService,PersistentsubAdminService This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAdminService)parentService,(SubjInterface)subService,(PersistentsubAdminService)This,id);
        this.users = new UserManagerService_UsersProxi(this);        
    }
    
    static public long getTypeId() {
        return -290;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -290) ConnectionHandler.getTheConnectionHandler().theUserManagerServiceFacade
            .newUserManagerService(this.getId());
        super.store();
        this.getUsers().store();
        
    }
    
    public UserManagerService_UsersProxi getUsers() throws PersistenceException {
        return this.users;
    }
    public PersistentUserManagerService getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUserManagerService result = (PersistentUserManagerService)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentUserManagerService)this.This;
    }
    
    public void accept(subAdminServiceVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(subAdminServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(subAdminServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(subAdminServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleUserManagerService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUserManagerService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUserManagerService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUserManagerService(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getUsers().getLength() > 0) return 1;
        return 0;
    }
    
    
    public synchronized void deregister(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.deregister(observee);
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUserManagerService)This);
		if(this.isTheSameAs(This)){
			this.setParentService((PersistentAdminService)final$$Fields.get("parentService"));
		}
    }
    public synchronized void register(final ObsInterface observee) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.register(observee);
    }
    public synchronized void updateObservers(final model.meta.Mssgs event) 
				throws PersistenceException{
        SubjInterface subService = getThis().getSubService();
		if (subService == null) {
			subService = model.Subj.createSubj(this.isDelayed$Persistence());
			getThis().setSubService(subService);
		}
		subService.updateObservers(event);
    }
    public String userManagerService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void connected(final String user) 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void createAdminUser(final String name, final String pw) 
				throws PersistenceException{
        Server4Public server = Server.createServer(pw, name, 0, new java.sql.Timestamp(0));
        server.setService(AdminService.createAdminService());
        getThis().getUsers().add(server);
        getThis().signalChanged(true);
    }
    public void disconnected() 
				throws PersistenceException{
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		super.initializeOnCreation();
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		super.initializeOnInstantiation();
		ServerSearchList servers = Server.getServerByUser("%").copy();
		servers.filter(server -> {
			try {
				return Student.getById(Long.valueOf(server.getUser())) == null;
			} catch (NumberFormatException e) {
				return true;
			}
		});
		servers.applyToAll(server -> {
			if(getThis().getUsers().findFirst(argument -> argument.equals(server)) == null) {
				getThis().getUsers().add(server);
			}
		});
	}
    public void removeError(final ErrorDisplay4Public error) 
				throws PersistenceException{
		getThis().getErrors().filter(arg -> !arg.equals(error));
		getThis().signalChanged(true);
    }
    public void updateMe() 
				throws PersistenceException{
    	getThis().initializeOnInstantiation();
    	getThis().signalChanged(true);
    }
    public void updatePLZImplementation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
		new Thread(new Runnable() {
			public /* INTERNAL */ void run() {
				// Handle exception!
			}
		}).start();
	}
    public void handleResult(final Command command) 
				throws PersistenceException{
		new Thread(new Runnable() {
			public void /* INTERNAL */ run() {
				try {
					try {
						command.checkException();
						// Handle result!
						signalChanged(true);
					} catch (model.UserException e) {
						model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						getErrors().add(visitor.getResult());
						signalChanged(true);
					}
				} catch (PersistenceException e) {
					// Handle fatal exception!
				}
			}
		}).start();
	}
    public boolean hasChanged() 
				throws PersistenceException{
		boolean result = this.changed;
		this.changed = false;
		return result;
	}

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}
