
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ModuleAtomarStudent extends model.ModuleAbstractStudent implements PersistentModuleAtomarStudent{
    
    
    public static ModuleAtomarStudent4Public createModuleAtomarStudent(ModuleAbstractSGroup4Public moduleCopy) throws PersistenceException{
        return createModuleAtomarStudent(moduleCopy,false);
    }
    
    public static ModuleAtomarStudent4Public createModuleAtomarStudent(ModuleAbstractSGroup4Public moduleCopy,boolean delayed$Persistence) throws PersistenceException {
        PersistentModuleAtomarStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade
                .newDelayedModuleAtomarStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade
                .newModuleAtomarStudent(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("moduleCopy", moduleCopy);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ModuleAtomarStudent4Public createModuleAtomarStudent(ModuleAbstractSGroup4Public moduleCopy,boolean delayed$Persistence,ModuleAtomarStudent4Public This) throws PersistenceException {
        PersistentModuleAtomarStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade
                .newDelayedModuleAtomarStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade
                .newModuleAtomarStudent(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("moduleCopy", moduleCopy);
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
            AbstractPersistentRoot ownGrade = (AbstractPersistentRoot)this.getOwnGrade();
            if (ownGrade != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    ownGrade, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("ownGrade", proxiInformation);
                
            }
            result.put("changes", this.getChanges().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
        }
        return result;
    }
    
    public ModuleAtomarStudent provideCopy() throws PersistenceException{
        ModuleAtomarStudent result = this;
        result = new ModuleAtomarStudent(this.moduleCopy, 
                                         this.subService, 
                                         this.This, 
                                         this.ownGrade, 
                                         this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentGradesInSimpleOrThird ownGrade;
    protected ModuleAtomarStudent_ChangesProxi changes;
    
    public ModuleAtomarStudent(PersistentModuleAbstractSGroup moduleCopy,SubjInterface subService,PersistentModuleAbstractStudent This,PersistentGradesInSimpleOrThird ownGrade,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentModuleAbstractSGroup)moduleCopy,(SubjInterface)subService,(PersistentModuleAbstractStudent)This,id);
        this.ownGrade = ownGrade;
        this.changes = new ModuleAtomarStudent_ChangesProxi(this);        
    }
    
    static public long getTypeId() {
        return 191;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 191) ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade
            .newModuleAtomarStudent(this.getId());
        super.store();
        if(this.getOwnGrade() != null){
            this.getOwnGrade().store();
            ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade.ownGradeSet(this.getId(), getOwnGrade());
        }
        this.getChanges().store();
        
    }
    
    public GradesInSimpleOrThird4Public getOwnGrade() throws PersistenceException {
        return this.ownGrade;
    }
    public void setOwnGrade(GradesInSimpleOrThird4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.ownGrade)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.ownGrade = (PersistentGradesInSimpleOrThird)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theModuleAtomarStudentFacade.ownGradeSet(this.getId(), newValue);
        }
    }
    public ModuleAtomarStudent_ChangesProxi getChanges() throws PersistenceException {
        return this.changes;
    }
    public PersistentModuleAtomarStudent getThis() throws PersistenceException {
        if(this.This == null){
            PersistentModuleAtomarStudent result = (PersistentModuleAtomarStudent)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentModuleAtomarStudent)this.This;
    }
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends model.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends model.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(SubjInterfaceVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(SubjInterfaceReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends model.UserException>  void accept(SubjInterfaceExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends model.UserException> R accept(SubjInterfaceReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public void accept(LectureWithGradeVisitor visitor) throws PersistenceException {
        visitor.handleModuleAtomarStudent(this);
    }
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleModuleAtomarStudent(this);
    }
    public <E extends model.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleModuleAtomarStudent(this);
    }
    public <R, E extends model.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleModuleAtomarStudent(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getChanges().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		return false;
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
        this.setThis((PersistentModuleAtomarStudent)This);
		if(this.isTheSameAs(This)){
			this.setModuleCopy((PersistentModuleAbstractSGroup)final$$Fields.get("moduleCopy"));
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
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.ModuleAtomarStudent$$finalize(getThis() );
		return result;
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
    
    public void changeGrade(final Grade4Public grade, final String comment) 
				throws model.AlreadyFinishedException, model.InvalidGradeForSystemException, PersistenceException{
    	((ModuleAtomarSGroupProxi)getThis().getModuleCopy()).getGradeSystem().accept(new GradeSystemExceptionVisitor<InvalidGradeForSystemException>() {

			@Override
			public void handleSimpleGradeSystem(SimpleGradeSystem4Public simpleGradeSystem)
					throws PersistenceException, InvalidGradeForSystemException {
				if(grade instanceof GradesInThird4Public && !(grade instanceof NoGrade4Public)){
					throw new InvalidGradeForSystemException(String.format(InvalidGradeForSystemMessage2, grade.toString()));
				}
			}

			@Override
			public void handleThirdGradeSystem(ThirdGradeSystem4Public thirdGradeSystem)
					throws PersistenceException, InvalidGradeForSystemException {
				if(grade instanceof GradesInSimple4Public){
					throw new InvalidGradeForSystemException(String.format(InvalidGradeForSystemMessage3, grade.toString()));
				}
			}
		});
    	if(getThis().getFinished().toBoolean()) {
    		throw new AlreadyFinishedException(FinishedMessage);
		}
    	getThis().getChanges().add(GradeChange.createGradeChange(getThis().getGrade(), grade, comment));
    	getThis().setOwnGrade((GradesInSimpleOrThird4Public)grade);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
    }
    public common.Fraction getCPmulGrade() 
				throws PersistenceException{
    	try {
			return getThis().getCreditPoints().mul(getThis().getGrade().toFraction());
		} catch (NoFractionValueException e) {
			return Fraction.Null;
		}
    }
    public common.Fraction getCPwithGrade() 
				throws PersistenceException{
    	try {
			getThis().getGrade().toFraction();
			return getThis().getCreditPoints();
		} catch (NoFractionValueException e) {
			return Fraction.Null;
		}
    }
    public Grade4Public getGrade() 
				throws PersistenceException{
        return getThis().getOwnGrade();
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
        if(getThis().getGrade() instanceof NoGrade4Public || getThis().getGrade() instanceof T_5_04Public || getThis().getGrade() instanceof NotPassed4Public) {
        	return Fraction.Null;
        } else {
        	return getThis().getCreditPoints();
        }
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        super.initializeOnCreation();
        getThis().setOwnGrade(NoGrade.getTheNoGrade());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        super.initializeOnInstantiation();
    }
    
    
    // Start of section that contains overridden operations only.
    
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
        return getThis().getModuleCopy().getFinished();
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    
    static String InvalidGradeForSystemMessage2 = "Die Note \"%s\" ist nicht mit dem zweiwertigen Notensystem des Moduls kompatibel.";    
    static String InvalidGradeForSystemMessage3 = "Die Note \"%s\" ist nicht mit dem Drittel-Notensystem des Moduls kompatibel.";
    static String FinishedMessage = "Der Studiengang ist abgeschlossen.";
    
    
    /* End of protected part that is not overridden by persistence generator */
    
}
