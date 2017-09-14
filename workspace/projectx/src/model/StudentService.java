
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class StudentService extends model.Service implements PersistentStudentService{
    
    
    public static StudentService4Public createStudentService() throws PersistenceException{
        return createStudentService(false);
    }
    
    public static StudentService4Public createStudentService(boolean delayed$Persistence) throws PersistenceException {
        PersistentStudentService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentServiceFacade
                .newDelayedStudentService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentServiceFacade
                .newStudentService(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudentService4Public createStudentService(boolean delayed$Persistence,StudentService4Public This) throws PersistenceException {
        PersistentStudentService result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudentServiceFacade
                .newDelayedStudentService();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudentServiceFacade
                .newStudentService(-1);
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
            AbstractPersistentRoot student = (AbstractPersistentRoot)this.getStudent();
            if (student != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    student, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, true, false, false);
                result.put("student", proxiInformation);
                
            }
        }
        return result;
    }
    
    public StudentService provideCopy() throws PersistenceException{
        StudentService result = this;
        result = new StudentService(this.This, 
                                    this.getId());
        result.errors = this.errors.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public StudentService(PersistentService This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentService)This,id);        
    }
    
    static public long getTypeId() {
        return -286;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == -286) ConnectionHandler.getTheConnectionHandler().theStudentServiceFacade
            .newStudentService(this.getId());
        super.store();
        
    }
    
    public PersistentStudentService getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudentService result = (PersistentStudentService)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudentService)this.This;
    }
    
    public void accept(ServiceVisitor visitor) throws PersistenceException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(ServiceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentService(this);
    }
    public <E extends model.UserException>  void accept(ServiceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends model.UserException> R accept(ServiceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentService(this);
    }
    public void accept(InvokerVisitor visitor) throws PersistenceException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(InvokerReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentService(this);
    }
    public <E extends model.UserException>  void accept(InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends model.UserException> R accept(InvokerReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentService(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentService(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentService(this);
    }
    public void accept(RemoteVisitor visitor) throws PersistenceException {
        visitor.handleStudentService(this);
    }
    public <R> R accept(RemoteReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudentService(this);
    }
    public <E extends model.UserException>  void accept(RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudentService(this);
    }
    public <R, E extends model.UserException> R accept(RemoteReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudentService(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getStudent() != null) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudentService)This);
		if(this.isTheSameAs(This)){
		}
    }
    public String studentService_Menu_Filter(final Anything anything) 
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
    public void disconnected() 
				throws PersistenceException{
        
    }
    public Student4Public getStudent() 
				throws PersistenceException{
        return Student.getById(Long.valueOf(getThis().getParentServer().iterator().next().getUser()));
    }
    public String getUsername() 
				throws PersistenceException{
        return getThis().getParentServer().iterator().next().getUser();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    
    public void handleException(final Command command, final PersistenceException exception) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public /*INTERNAL*/ void run() {
				//Handle exception!
			}
		}).start();
    }
    public void handleResult(final Command command) 
				throws PersistenceException{
        new Thread(new Runnable(){
			public void  /*INTERNAL*/  run() {
				try {
					try {
						command.checkException();
						//Handle result!
						signalChanged(true);
					} catch (model.UserException e) {
						model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						getErrors().add(visitor.getResult());
						signalChanged(true);
					}
				} catch (PersistenceException e) {
					//Handle fatal exception!
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
