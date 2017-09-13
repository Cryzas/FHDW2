
package model;

import persistence.*;
import common.Fraction;
import model.visitor.*;


/* Additional import section end */

public class ProgramStudent extends PersistentObject implements PersistentProgramStudent{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ProgramStudent4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade.getClass(objectId);
        return (ProgramStudent4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ProgramStudent4Public createProgramStudent(ProgramSGroup4Public programCopy) throws PersistenceException{
        return createProgramStudent(programCopy,false);
    }
    
    public static ProgramStudent4Public createProgramStudent(ProgramSGroup4Public programCopy,boolean delayed$Persistence) throws PersistenceException {
        PersistentProgramStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade
                .newDelayedProgramStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade
                .newProgramStudent(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("programCopy", programCopy);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static ProgramStudent4Public createProgramStudent(ProgramSGroup4Public programCopy,boolean delayed$Persistence,ProgramStudent4Public This) throws PersistenceException {
        PersistentProgramStudent result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade
                .newDelayedProgramStudent();
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade
                .newProgramStudent(-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("programCopy", programCopy);
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
            result.put("modules", this.getModules().getVector(allResults, depth, essentialLevel, forGUI, false, true, inDerived, false, false));
            result.put("name", this.getName());
            result.put("creditPoints", this.getCreditPoints().toString());
            AbstractPersistentRoot programCopy = (AbstractPersistentRoot)this.getProgramCopy();
            if (programCopy != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    programCopy, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("programCopy", proxiInformation);
                
            }
            AbstractPersistentRoot grade = (AbstractPersistentRoot)this.getGrade();
            if (grade != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    grade, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, true, false, false);
                result.put("grade", proxiInformation);
                
            }
            AbstractPersistentRoot finished = (AbstractPersistentRoot)this.getFinished();
            if (finished != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    finished, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, true, false, false);
                result.put("finished", proxiInformation);
                
            }
            result.put("passedCP", this.getPassedCP().toString());
        }
        return result;
    }
    
    public ProgramStudent provideCopy() throws PersistenceException{
        ProgramStudent result = this;
        result = new ProgramStudent(this.programCopy, 
                                    this.This, 
                                    this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ProgramStudent_ModulesProxi modules;
    protected PersistentProgramSGroup programCopy;
    protected PersistentProgramStudent This;
    
    public ProgramStudent(PersistentProgramSGroup programCopy,PersistentProgramStudent This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.modules = new ProgramStudent_ModulesProxi(this);
        this.programCopy = programCopy;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 192;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 192) ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade
            .newProgramStudent(this.getId());
        super.store();
        this.getModules().store();
        if(this.getProgramCopy() != null){
            this.getProgramCopy().store();
            ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade.programCopySet(this.getId(), getProgramCopy());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public ProgramStudent_ModulesProxi getModules() throws PersistenceException {
        return this.modules;
    }
    public ProgramSGroup4Public getProgramCopy() throws PersistenceException {
        return this.programCopy;
    }
    public void setProgramCopy(ProgramSGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.programCopy)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.programCopy = (PersistentProgramSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade.programCopySet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentProgramStudent newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentProgramStudent)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theProgramStudentFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentProgramStudent getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProgramStudent result = (PersistentProgramStudent)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentProgramStudent)this.This;
    }
    
    public void accept(ProgramStudentVisitor visitor) throws PersistenceException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(ProgramStudentReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends model.UserException>  void accept(ProgramStudentExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends model.UserException> R accept(ProgramStudentReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramStudent(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramStudent(this);
    }
    public void accept(programHierarchyStudentHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleProgramStudent(this);
    }
    public <R> R accept(programHierarchyStudentHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProgramStudent(this);
    }
    public <E extends model.UserException>  void accept(programHierarchyStudentHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProgramStudent(this);
    }
    public <R, E extends model.UserException> R accept(programHierarchyStudentHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProgramStudent(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getModules().getLength() > 0) return 1;
        return 0;
    }
    
    
    public boolean containsprogramHierarchyStudent(final programHierarchyStudentHIERARCHY part) 
				throws PersistenceException{
        if(getThis().equals(part)) return true;
		java.util.Iterator<ModuleAbstractStudent4Public> iterator0 = getThis().getModules().iterator();
		while(iterator0.hasNext())
			if(((programHierarchyStudentHIERARCHY)iterator0.next()).containsprogramHierarchyStudent(part)) return true; 
		return false;
    }
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentProgramStudent)This);
		if(this.isTheSameAs(This)){
			this.setProgramCopy((PersistentProgramSGroup)final$$Fields.get("programCopy"));
		}
    }
    public <T> T strategyprogramHierarchyStudent(final programHierarchyStudentHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        T result$$modules$$ProgramStudent = strategy.ProgramStudent$$modules$$$initialize(getThis());
		java.util.Iterator<?> iterator$$ = getThis().getModules().iterator();
		while (iterator$$.hasNext()){
			ModuleAbstractStudent4Public current$$Field = (ModuleAbstractStudent4Public)iterator$$.next();
			T current$$ = current$$Field.strategyprogramHierarchyStudent(strategy);
			result$$modules$$ProgramStudent = strategy.ProgramStudent$$modules$$consolidate(getThis(), result$$modules$$ProgramStudent, current$$);
		}
		T result = strategy.ProgramStudent$$finalize(getThis() ,result$$modules$$ProgramStudent);
		return result;
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addModule(final ModuleAbstractStudent4Public module) 
				throws model.CycleException, PersistenceException{
    	getThis().getModules().add(module);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public common.Fraction getCreditPoints() 
				throws PersistenceException{
        return getThis().getModules().aggregate(Fraction.Null, (result, argument) -> result.add(argument.getCreditPoints()));
    }
    public MyBoolean4Public getFinished() 
				throws PersistenceException{
    	return getThis().accept(new ProgramStudentReturnVisitor<MyBoolean4Public>() {

			@Override
			public MyBoolean4Public handleNoProgram(NoProgram4Public noProgram) throws PersistenceException {
				return BFalse.getTheBFalse();
			}

			@Override
			public MyBoolean4Public handleProgramStudent(ProgramStudent4Public programStudent)
					throws PersistenceException {
		        return getThis().getProgramCopy().getFinished();
			}
		});
    }
    public Grade4Public getGrade() 
				throws PersistenceException{

    	Fraction CPWithGrade = getThis().getModules().aggregate(Fraction.Null, (result,argument) -> {
			return result.add(argument.getCPwithGrade());
		} );
		Fraction GradeCumulated = getThis().getModules().aggregate(Fraction.Null, (result,argument) -> {
			return result.add(argument.getCPmulGrade());
		} );
		if(CPWithGrade.equals(Fraction.Null)) {
			return NoGrade.getTheNoGrade();
		}
		return GradeCumulated.div(CPWithGrade).toGradeinTenth();
    }
    public String getName() 
				throws PersistenceException{
        return getThis().accept(new ProgramStudentReturnVisitor<String>() {

			@Override
			public String handleNoProgram(NoProgram4Public noProgram) throws PersistenceException {
				return "";
			}

			@Override
			public String handleProgramStudent(ProgramStudent4Public programStudent) throws PersistenceException {
				return getThis().getProgramCopy().getName();
			}
		});
    }
    public common.Fraction getPassedCP() 
				throws PersistenceException{
    	return getThis().getModules().aggregate(Fraction.Null, (result,argument) -> {
        	return result.add(argument.getPassedCP());
		} );
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
