
package model;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class StudyGroup extends PersistentObject implements PersistentStudyGroup{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static StudyGroup4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.getClass(objectId);
        return (StudyGroup4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static StudyGroup4Public createStudyGroup(String name) throws PersistenceException{
        return createStudyGroup(name,false);
    }
    
    public static StudyGroup4Public createStudyGroup(String name,boolean delayed$Persistence) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentStudyGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
                .newDelayedStudyGroup(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
                .newStudyGroup(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static StudyGroup4Public createStudyGroup(String name,boolean delayed$Persistence,StudyGroup4Public This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentStudyGroup result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
                .newDelayedStudyGroup(name);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
                .newStudyGroup(name,-1);
        }
        java.util.HashMap<String,Object> final$$Fields = new java.util.HashMap<String,Object>();
        final$$Fields.put("name", name);
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
            AbstractPersistentRoot program = (AbstractPersistentRoot)this.getProgram();
            if (program != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    program, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("program", proxiInformation);
                
            }
            result.put("students", this.getStudents().getVector(allResults, depth, essentialLevel, forGUI, true, true, inDerived, false, false));
            AbstractPersistentRoot finished = (AbstractPersistentRoot)this.getFinished();
            if (finished != null) {
                String proxiInformation = SearchListRoot.calculateProxiInfoAndRecursiveGet(
                    finished, allResults, depth, essentialLevel, forGUI, false, essentialLevel <= 1, inDerived, false, false);
                result.put("finished", proxiInformation);
                
            }
        }
        return result;
    }
    
    public static StudyGroupSearchList getStudyGroupByName(String name) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
            .getStudyGroupByName(name);
    }
    
    public StudyGroup provideCopy() throws PersistenceException{
        StudyGroup result = this;
        result = new StudyGroup(this.name, 
                                this.program, 
                                this.finished, 
                                this.This, 
                                this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentProgramSGroup program;
    protected StudyGroup_StudentsProxi students;
    protected PersistentMyBoolean finished;
    protected PersistentStudyGroup This;
    
    public StudyGroup(String name,PersistentProgramSGroup program,PersistentMyBoolean finished,PersistentStudyGroup This,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        this.program = program;
        this.students = new StudyGroup_StudentsProxi(this);
        this.finished = finished;
        if (This != null && !(this.isTheSameAs(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 180;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 180) ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade
            .newStudyGroup(name,this.getId());
        super.store();
        if(this.getProgram() != null){
            this.getProgram().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.programSet(this.getId(), getProgram());
        }
        this.getStudents().store();
        if(this.getFinished() != null){
            this.getFinished().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.finishedSet(this.getId(), getFinished());
        }
        if(!this.isTheSameAs(this.getThis())){
            this.getThis().store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.ThisSet(this.getId(), getThis());
        }
        
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    public ProgramSGroup4Public getProgram() throws PersistenceException {
        return this.program;
    }
    public void setProgram(ProgramSGroup4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.program)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.program = (PersistentProgramSGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.programSet(this.getId(), newValue);
        }
    }
    public StudyGroup_StudentsProxi getStudents() throws PersistenceException {
        return this.students;
    }
    public MyBoolean4Public getFinished() throws PersistenceException {
        return this.finished;
    }
    public void setFinished(MyBoolean4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.finished)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.finished = (PersistentMyBoolean)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.finishedSet(this.getId(), newValue);
        }
    }
    protected void setThis(PersistentStudyGroup newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.isTheSameAs(this)){
            this.This = null;
            return;
        }
        if(newValue.isTheSameAs(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentStudyGroup)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theStudyGroupFacade.ThisSet(this.getId(), newValue);
        }
    }
    public PersistentStudyGroup getThis() throws PersistenceException {
        if(this.This == null){
            PersistentStudyGroup result = (PersistentStudyGroup)PersistentProxi.createProxi(this.getId(),this.getClassId());
            result.getTheObject();
            return result;
        }return (PersistentStudyGroup)this.This;
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleStudyGroup(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleStudyGroup(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleStudyGroup(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleStudyGroup(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getProgram() != null) return 1;
        if (this.getStudents().getLength() > 0) return 1;
        return 0;
    }
    
    
    public void initialize(final Anything This, final java.util.HashMap<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentStudyGroup)This);
		if(this.isTheSameAs(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    
    
    // Start of section that contains operations that must be implemented.
    
    public void addStudent(final Student4Public student) 
				throws model.AlreadyExistsInParentException, PersistenceException{
    	if(getThis().getStudents().findFirst(argument -> student.equals(argument)) != null) {
    		throw new AlreadyExistsInParentException(String.format(StudentAlreadyInGroupMessage,student.getFirstName(), student.getLastName(), getThis().getName()));
    	}
        getThis().getStudents().add(student);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        
    }
    public void endStudyGroup() 
				throws model.AlreadyFinishedException, PersistenceException{
        getThis().getFinished().accept(new MyBooleanExceptionVisitor<AlreadyFinishedException>() {

			@Override
			public void handleBFalse(BFalse4Public bFalse) throws PersistenceException, AlreadyFinishedException {
				getThis().getProgram().endProgram();
				getThis().getStudents().applyToAll(student -> {
					student.getOldPrograms().add(student.getProgram());
					student.setProgram(NoProgram.getTheNoProgram());
				});
				getThis().setFinished(BTrue.getTheBTrue());
			}

			@Override
			public void handleBTrue(BTrue4Public bTrue) throws PersistenceException, AlreadyFinishedException {
				throw new AlreadyFinishedException(String.format(GroupAlreadyFinishedMessage, getThis().getName()));
			}
		});
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        getThis().setFinished(BFalse.getTheBFalse());
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    static String StudentAlreadyInGroupMessage = "Der Student %s %s ist bereits in der Studiengruppe %s.";
    static String GroupAlreadyFinishedMessage = "Die Studiengruppe %s ist bereits abgeschlossen.";
    
    /* End of protected part that is not overridden by persistence generator */
    
}
