package model.meta;

import persistence.*;

public class StudyGroupManagerCreateStudentStudyGroupStringStringDateMssg implements StudyGroupManagerDOWNMssgs,StudyGroupManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentStudyGroupManager rcvr;
    public final persistence.StudyGroup4Public group;
    public final String firstName;
    public final String lastName;
    public final java.sql.Date birthDate;
    
    public StudyGroupManagerCreateStudentStudyGroupStringStringDateMssg(persistence.StudyGroup4Public group,
                                                                        String firstName,
                                                                        String lastName,
                                                                        java.sql.Date birthDate,
                                                                        persistence.PersistentStudyGroupManager rcvr){
        this.group = group;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.rcvr = rcvr;
    }
    public void accept(StudyGroupManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleStudyGroupManagerCreateStudentStudyGroupStringStringDateMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.createStudentImplementation(this.group, this.firstName, this.lastName, this.birthDate);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.AlreadyFinishedException, model.AlreadyExistsInParentException, model.CycleException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.AlreadyFinishedException) throw (model.AlreadyFinishedException) this.excptn;
            if(this.excptn instanceof model.AlreadyExistsInParentException) throw (model.AlreadyExistsInParentException) this.excptn;
            if(this.excptn instanceof model.CycleException) throw (model.CycleException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
