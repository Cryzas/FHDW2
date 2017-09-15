
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class UnitStudent extends PersistentObject implements PersistentUnitStudent{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static UnitStudent4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade.getClass(objectId);
        return (UnitStudent4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static UnitStudent4Public createUnitStudent(UnitSGroup4Public unitCopy) throws PersistenceException{
        return createUnitStudent(unitCopy,false);
    }
    
    public static UnitStudent4Public createUnitStudent(UnitSGroup4Public unitCopy,boolean delayed$Persistence) throws PersistenceException {
        PersistentUnitStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade
                .newDelayedUnitStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade
                .newUnitStudent(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("unitCopy", unitCopy);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static UnitStudent4Public createUnitStudent(UnitSGroup4Public unitCopy,boolean delayed$Persistence,UnitStudent4Public This) throws PersistenceException {
        PersistentUnitStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade
                .newDelayedUnitStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade
                .newUnitStudent(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("unitCopy", unitCopy);
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
            result.put("name", this.getName());
            result.put("creditPoints", this.getCreditPoints().toString());
            AbstractPersistentRoot grade = (AbstractPersistentRoot)this.getGrade();
            if (grade != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    grade, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("grade", proxiInformation);
                
            }
            result.put("CPmulGrade", this.getCPmulGrade().toString());
            result.put("CPwithGrade", this.getCPwithGrade().toString());
            result.put("passedCP", this.getPassedCP().toString());
            result.put("changes", this.getChanges().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
            AbstractPersistentRoot finished = (AbstractPersistentRoot)this.getFinished();
            if (finished != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    finished, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, true, false, false);
                result.put("finished", proxiInformation);
                
            }
        }
        return result;
    }
    
    public UnitStudent provideCopy() throws PersistenceException{
        UnitStudent result = this;
        result = new UnitStudent(this.unitCopy, 
                                 this.grade, 
                                 this.This, 
                                 this.getId());
        result.changes = this.changes.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentUnitSGroup unitCopy;
    protected PersistentGradesInThird grade;
    protected UnitStudent_ChangesProxi changes;
    protected PersistentUnitStudent This;
    
    public UnitStudent(PersistentUnitSGroup unitCopy,PersistentGradesInThird grade,PersistentUnitStudent This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.unitCopy = unitCopy;
        this.grade = grade;
        this.changes = new UnitStudent_ChangesProxi(this);
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 197;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 197) ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade
            .newUnitStudent(this.getId());
        super.store();
        if(this.getUnitCopy() != null){
            this.getUnitCopy().store();
            ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade.unitCopySet(this.getId(), getUnitCopy());
        }
        if(this.getGrade() != null){
            this.getGrade().store();
            ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade.gradeSet(this.getId(), getGrade());
        }
        this.getChanges().store();
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public UnitSGroup4Public getUnitCopy() throws PersistenceException {
        return this.unitCopy;
    }
    public void setUnitCopy(UnitSGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.unitCopy)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.unitCopy = (PersistentUnitSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade.unitCopySet(this.getId(), newValue);
        }
    }
    public GradesInThird4Public getGrade() throws PersistenceException {
        return this.grade;
    }
    public void setGrade(GradesInThird4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.grade)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.grade = (PersistentGradesInThird)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade.gradeSet(this.getId(), newValue);
        }
    }
    public UnitStudent_ChangesProxi getChanges() throws PersistenceException {
        return this.changes;
    }
    protected void setThis(PersistentUnitStudent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentUnitStudent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theUnitStudentFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentUnitStudent getThis() throws PersistenceException {
        if(this.This == null){
            PersistentUnitStudent result = (PersistentUnitStudent)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentUnitStudent)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitStudent(this);
    }
    public void accept(LectureWithGradeVisitor visitor) throws PersistenceException {
        visitor.handleUnitStudent(this);
    }
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitStudent(this);
    }
    public <E extends model.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitStudent(this);
    }
    public <R, E extends model.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitStudent(this);
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
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentUnitStudent)This);
		if(this.isTheSameAs(This)){
			this.setUnitCopy((PersistentUnitSGroup)final$$Fields.get("unitCopy"));
		}
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result = strategy.UnitStudent$$finalize(getThis() );
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void changeGrade(final Grade4Public grade, final String comment) 
				throws model.AlreadyFinishedException, model.InvalidGradeForSystemException, PersistenceException{
    	if(!(grade instanceof GradesInThird4Public)){
    		throw new InvalidGradeForSystemException(String.format(InvalidGradeForSystemMessage,grade.toString()));
    	}
    	getThis().getFinished().accept(new MyBooleanExceptionVisitor<AlreadyFinishedException>() {

			@Override
			public void handleBFalse(BFalse4Public bFalse) throws PersistenceException, AlreadyFinishedException {
							}

			@Override
			public void handleBTrue(BTrue4Public bTrue) throws PersistenceException, AlreadyFinishedException {
				throw new AlreadyFinishedException(FinishedMessage);
			}
		});
    	getThis().getChanges().add(GradeChange.createGradeChange(getThis().getGrade(), grade, comment));
    	getThis().setGrade((GradesInThird4Public)grade);
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
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return getThis().getUnitCopy().getCreditPoints();
    }
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
        return getThis().getUnitCopy().getFinished();
    }
    public String getName() 
				throws PersistenceException{
        return getThis().getUnitCopy().getName();
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
    	if(getThis().getGrade() instanceof NoGrade4Public || getThis().getGrade() instanceof T_5_04Public) {
        	return Fraction.Null;
        } else {
        	return getThis().getCreditPoints();
        }
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    	getThis().setGrade(NoGrade.getTheNoGrade());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    static String InvalidGradeForSystemMessage = "Die Note \"%s\" ist nicht mit dem Drittel-Notensystem des Moduls kompatibel.";
    static String FinishedMessage = "Der Studiengang ist abgeschlossen.";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
