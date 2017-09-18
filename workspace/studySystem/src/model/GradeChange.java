
package model;

import persistence.*;

import java.sql.Date;
import java.time.Instant;

import model.visitor.*;


/* Additional import section end */

public class GradeChange extends PersistentObject implements PersistentGradeChange{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static GradeChange4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.getClass(objectId);
        return (GradeChange4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static GradeChange4Public createGradeChange(Grade4Public fromGrade,Grade4Public toGrade,String comment) throws PersistenceException{
        return createGradeChange(fromGrade,toGrade,comment,false);
    }
    
    public static GradeChange4Public createGradeChange(Grade4Public fromGrade,Grade4Public toGrade,String comment,boolean delayed$Persistence) throws PersistenceException {
        if (comment == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentGradeChange result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade
                .newDelayedGradeChange(new java.sql.Date(System.currentTimeMillis()),comment);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade
                .newGradeChange(new java.sql.Date(System.currentTimeMillis()),comment,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("fromGrade", fromGrade);
        final$$Fields.put("toGrade", toGrade);
        final$$Fields.put("comment", comment);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static GradeChange4Public createGradeChange(Grade4Public fromGrade,Grade4Public toGrade,String comment,boolean delayed$Persistence,GradeChange4Public This) throws PersistenceException {
        if (comment == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentGradeChange result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade
                .newDelayedGradeChange(new java.sql.Date(System.currentTimeMillis()),comment);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade
                .newGradeChange(new java.sql.Date(System.currentTimeMillis()),comment,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("fromGrade", fromGrade);
        final$$Fields.put("toGrade", toGrade);
        final$$Fields.put("comment", comment);
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
            AbstractPersistentRoot fromGrade = (AbstractPersistentRoot)this.getFromGrade();
            if (fromGrade != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    fromGrade, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("fromGrade", proxiInformation);
                
            }
            AbstractPersistentRoot toGrade = (AbstractPersistentRoot)this.getToGrade();
            if (toGrade != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    toGrade, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("toGrade", proxiInformation);
                
            }
            result.put("dateOfChange", this.getDateOfChange());
            result.put("comment", this.getComment());
        }
        return result;
    }
    
    public GradeChange provideCopy() throws PersistenceException{
        GradeChange result = this;
        result = new GradeChange(this.fromGrade, 
                                 this.toGrade, 
                                 this.dateOfChange, 
                                 this.comment, 
                                 this.subService, 
                                 this.This, 
                                 this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentGrade fromGrade;
    protected PersistentGrade toGrade;
    protected java.sql.Date dateOfChange;
    protected String comment;
    protected SubjInterface subService;
    protected PersistentGradeChange This;
    
    public GradeChange(PersistentGrade fromGrade,PersistentGrade toGrade,java.sql.Date dateOfChange,String comment,SubjInterface subService,PersistentGradeChange This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.fromGrade = fromGrade;
        this.toGrade = toGrade;
        this.dateOfChange = dateOfChange;
        this.comment = comment;
        this.subService = subService;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 276;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 276) ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade
            .newGradeChange(dateOfChange,comment,this.getId());
        super.store();
        if(this.getFromGrade() != null){
            this.getFromGrade().store();
            ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.fromGradeSet(this.getId(), getFromGrade());
        }
        if(this.getToGrade() != null){
            this.getToGrade().store();
            ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.toGradeSet(this.getId(), getToGrade());
        }
        if(this.getSubService() != null){
            this.getSubService().store();
            ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.subServiceSet(this.getId(), getSubService());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public Grade4Public getFromGrade() throws PersistenceException {
        return this.fromGrade;
    }
    public void setFromGrade(Grade4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.fromGrade)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.fromGrade = (PersistentGrade)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.fromGradeSet(this.getId(), newValue);
        }
    }
    public Grade4Public getToGrade() throws PersistenceException {
        return this.toGrade;
    }
    public void setToGrade(Grade4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.toGrade)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.toGrade = (PersistentGrade)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.toGradeSet(this.getId(), newValue);
        }
    }
    public java.sql.Date getDateOfChange() throws PersistenceException {
        return this.dateOfChange;
    }
    public void setDateOfChange(java.sql.Date newValue) throws PersistenceException {
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.dateOfChangeSet(this.getId(), newValue);
        this.dateOfChange = newValue;
    }
    public String getComment() throws PersistenceException {
        return this.comment;
    }
    public void setComment(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.commentSet(this.getId(), newValue);
        this.comment = newValue;
    }
    public SubjInterface getSubService() throws PersistenceException {
        return this.subService;
    }
    public void setSubService(SubjInterface newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.subService)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.subService = (SubjInterface)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.subServiceSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentGradeChange newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentGradeChange)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theGradeChangeFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentGradeChange getThis() throws PersistenceException {
        if(this.This == null){
            PersistentGradeChange result = (PersistentGradeChange)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentGradeChange)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleGradeChange(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGradeChange(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGradeChange(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGradeChange(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleGradeChange(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleGradeChange(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleGradeChange(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleGradeChange(this);
    }
    public int getLeafInfo() throws PersistenceException{
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
        this.setThis((PersistentGradeChange)This);
		if(this.isTheSameAs(This)){
			this.setFromGrade((PersistentGrade)final$$Fields.get("fromGrade"));
			this.setToGrade((PersistentGrade)final$$Fields.get("toGrade"));
			this.setComment((String)final$$Fields.get("comment"));
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
    
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setDateOfChange(new Date(Date.from(Instant.now()).getTime()));
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
