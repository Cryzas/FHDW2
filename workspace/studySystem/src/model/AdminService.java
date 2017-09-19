
package model;

import persistence.*;
import model.visitor.*;

/* Additional import section end */

public class AdminService extends model.Service implements PersistentAdminService{
    
    
    public static AdminService4Public createAdminService() throws PersistenceException{
        return createAdminService(false);
    }
    
    public static AdminService4Public createAdminService(boolean delayed$Persistence) throws PersistenceException {
        PersistentAdminService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdminServiceFacade
                .newDelayedAdminService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdminServiceFacade
                .newAdminService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static AdminService4Public createAdminService(boolean delayed$Persistence,AdminService4Public This) throws PersistenceException {
        PersistentAdminService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theAdminServiceFacade
                .newDelayedAdminService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theAdminServiceFacade
                .newAdminService(-1);
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
            result.put("services", this.getServices().getObservee().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public AdminService provideCopy() throws PersistenceException{
        AdminService result = this;
        result = new AdminService(this.subService, 
                                  this.This, 
                                  this.services, 
                                  this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentAdminServiceServices services;
    
    public AdminService(SubjInterface subService,PersistentService This,PersistentAdminServiceServices services,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((SubjInterface)subService,(PersistentService)This,id);
        this.services = services;        
    }
    
    static public long getTypeId() {
        return -289;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -289) ConnectionHandler.getTheConnectionHandler().theAdminServiceFacade
            .newAdminService(this.getId());
        super.store();
        if(this.services != null){
            this.services.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServiceFacade.servicesSet(this.getId(), services);
        }
        
    }
    
    public void setServices(AdminServiceServices4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.services)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.services = (PersistentAdminServiceServices)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theAdminServiceFacade.servicesSet(this.getId(), newValue);
        }
    }
    public PersistentAdminService getThis() throws PersistenceException {
        if(this.This == null){
            PersistentAdminService result = (PersistentAdminService)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentAdminService)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleAdminService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminService(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminService(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleAdminService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAdminService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminService(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleAdminService(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminService(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminService(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleAdminService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAdminService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAdminService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAdminService(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getServices().getObservee().getLength() > 0) return 1;
        return 0;
    }
    
    
    public String adminService_Menu_Filter(final Anything anything) 
				throws PersistenceException{
        String result = "+++";
		return result;
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
    public AdminServiceServices4Public getServices() 
				throws PersistenceException{
        if (this.services == null) {
			this.setServices(model.AdminServiceServices.createAdminServiceServices(this.isDelayed$Persistence()));
			this.services.setObserver(this);
		}
		return this.services;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentAdminService)This);
		if(this.isTheSameAs(This)){
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
    
    
    // Start of section that contains operations that must be implemented.
    
    public void connected(final String user) 
				throws PersistenceException{
	}
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
	}
    public void disconnected() 
				throws PersistenceException{
	}
    public String getUsername() 
				throws PersistenceException{
		return getThis().getParentServer().iterator().next().getUser();
	}
    public void initializeOnCreation() 
				throws PersistenceException{
		super.initializeOnCreation();
		getThis().getServices().add(ProgramModuleService.createProgramModuleService(getThis()));
		getThis().getServices().add(StudyGroupService.createStudyGroupService(getThis()));
		getThis().getServices().add(StudentManageService.createStudentManageService(getThis()));
		getThis().getServices().add(UserManagerService.createUserManagerService(getThis()));
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
		super.initializeOnInstantiation();
	}
    public void services_update(final model.meta.subAdminServiceMssgs event) 
				throws PersistenceException{
		getThis().getServices().applyToAll(service -> service.updateMe());
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
