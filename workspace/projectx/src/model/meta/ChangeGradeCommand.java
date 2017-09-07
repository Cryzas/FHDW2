
package model.meta;

import persistence.*;
import model.visitor.*;


/* Additional import section end */

public class ChangeGradeCommand extends PersistentObject implements PersistentChangeGradeCommand{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static ChangeGradeCommand4Public getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.getClass(objectId);
        return (ChangeGradeCommand4Public)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static ChangeGradeCommand4Public createChangeGradeCommand(String grade,java.sql.Date createDate,java.sql.Date commitDate) throws PersistenceException{
        return createChangeGradeCommand(grade,createDate,commitDate,false);
    }
    
    public static ChangeGradeCommand4Public createChangeGradeCommand(String grade,java.sql.Date createDate,java.sql.Date commitDate,boolean delayed$Persistence) throws PersistenceException {
        if (grade == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentChangeGradeCommand result = null;
        if(delayed$Persistence){
            result = ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade
                .newDelayedChangeGradeCommand(grade);
            result.setDelayed$Persistence(true);
        }else{
            result = ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade
                .newChangeGradeCommand(grade,-1);
        }
        ((PersistentChangeGradeCommand)result).setMyCommonDate((PersistentCommonDate)CommonDate.createCommonDate(createDate, createDate));
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return true;
    }
    protected LectureWithGrade lecture;
    protected String grade;
    protected Invoker invoker;
    protected PersistentStudentManager commandReceiver;
    protected PersistentCommonDate myCommonDate;
    
    private model.UserException commandException = null;
    
    public ChangeGradeCommand(LectureWithGrade lecture,String grade,Invoker invoker,PersistentStudentManager commandReceiver,PersistentCommonDate myCommonDate,long id) throws PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.lecture = lecture;
        this.grade = grade;
        this.invoker = invoker;
        this.commandReceiver = commandReceiver;
        this.myCommonDate = myCommonDate;        
    }
    
    static public long getTypeId() {
        return 275;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public void store() throws PersistenceException {
        if(!this.isDelayed$Persistence()) return;
        if (this.getClassId() == 275) ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade
            .newChangeGradeCommand(grade,this.getId());
        super.store();
        if(this.getLecture() != null){
            this.getLecture().store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.lectureSet(this.getId(), getLecture());
        }
        if(this.getInvoker() != null){
            this.getInvoker().store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.invokerSet(this.getId(), getInvoker());
        }
        if(this.getCommandReceiver() != null){
            this.getCommandReceiver().store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.commandReceiverSet(this.getId(), getCommandReceiver());
        }
        if(this.getMyCommonDate() != null){
            this.getMyCommonDate().store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.myCommonDateSet(this.getId(), getMyCommonDate());
        }
        
    }
    
    public LectureWithGrade getLecture() throws PersistenceException {
        return this.lecture;
    }
    public void setLecture(LectureWithGrade newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.lecture)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.lecture = (LectureWithGrade)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.lectureSet(this.getId(), newValue);
        }
    }
    public String getGrade() throws PersistenceException {
        return this.grade;
    }
    public void setGrade(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        if(!this.isDelayed$Persistence()) ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.gradeSet(this.getId(), newValue);
        this.grade = newValue;
    }
    public Invoker getInvoker() throws PersistenceException {
        return this.invoker;
    }
    public void setInvoker(Invoker newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.invoker)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.invoker = (Invoker)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.invokerSet(this.getId(), newValue);
        }
    }
    public StudentManager4Public getCommandReceiver() throws PersistenceException {
        return this.commandReceiver;
    }
    public void setCommandReceiver(StudentManager4Public newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.commandReceiver)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.commandReceiver = (PersistentStudentManager)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.commandReceiverSet(this.getId(), newValue);
        }
    }
    public PersistentCommonDate getMyCommonDate() throws PersistenceException {
        return this.myCommonDate;
    }
    public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.isTheSameAs(this.myCommonDate)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.myCommonDate = (PersistentCommonDate)PersistentProxi.createProxi(objectId, classId);
        if(!this.isDelayed$Persistence()){
            newValue.store();
            ConnectionHandler.getTheConnectionHandler().theChangeGradeCommandFacade.myCommonDateSet(this.getId(), newValue);
        }
    }
    public java.sql.Date getCreateDate() throws PersistenceException {
        return ((PersistentCommonDate)this.getMyCommonDate()).getCreateDate();
    }
    public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCommonDate)this.getMyCommonDate()).setCreateDate(newValue);
    }
    public java.sql.Date getCommitDate() throws PersistenceException {
        return ((PersistentCommonDate)this.getMyCommonDate()).getCommitDate();
    }
    public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
        ((PersistentCommonDate)this.getMyCommonDate()).setCommitDate(newValue);
    }
    public void delete$Me() throws PersistenceException{
        super.delete$Me();
        this.getMyCommonDate().delete$Me();
    }
    
    public void accept(CommonDateVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeCommand(this);
    }
    public <R> R accept(CommonDateReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeCommand(this);
    }
    public <E extends model.UserException>  void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommonDateReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeCommand(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeCommand(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeCommand(this);
    }
    public <E extends model.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeCommand(this);
    }
    public <R, E extends model.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeCommand(this);
    }
    public void accept(CommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeCommand(this);
    }
    public <R> R accept(CommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeCommand(this);
    }
    public <E extends model.UserException>  void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeCommand(this);
    }
    public <R, E extends model.UserException> R accept(CommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeCommand(this);
    }
    public void accept(StudentManagerCommandVisitor visitor) throws PersistenceException {
        visitor.handleChangeGradeCommand(this);
    }
    public <R> R accept(StudentManagerCommandReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleChangeGradeCommand(this);
    }
    public <E extends model.UserException>  void accept(StudentManagerCommandExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleChangeGradeCommand(this);
    }
    public <R, E extends model.UserException> R accept(StudentManagerCommandReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleChangeGradeCommand(this);
    }
    public int getLeafInfo() throws PersistenceException{
        if (this.getLecture() != null) return 1;
        if (this.getCommandReceiver() != null) return 1;
        return 0;
    }
    
    
    
    
    // Start of section that contains operations that must be implemented.
    
    public void checkException() 
				throws model.UserException, PersistenceException{
        if (this.commandException != null) throw this.commandException;
    }
    public void execute() 
				throws PersistenceException{
        try{
			this.commandReceiver.changeGrade(this.getLecture(), this.getGrade());
		}
		catch(model.InvalidGradeForSystemException e){
			this.commandException = e;
		}
    }
    public Invoker fetchInvoker() 
				throws PersistenceException{
        return this.getInvoker();
    }
    public void sendException(final PersistenceException exception) 
				throws PersistenceException{
        this.invoker.handleException(this, exception);
    }
    public void sendResult() 
				throws PersistenceException{
        this.invoker.handleResult(this);
    }
    
    
    // Start of section that contains overridden operations only.
    

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}