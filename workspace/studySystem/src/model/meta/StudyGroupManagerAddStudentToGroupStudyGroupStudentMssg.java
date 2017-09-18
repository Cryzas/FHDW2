package model.meta;

import persistence.*;

public class StudyGroupManagerAddStudentToGroupStudyGroupStudentMssg implements StudyGroupManagerDOWNMssgs,StudyGroupManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentStudyGroupManager rcvr;
    public final persistence.StudyGroup4Public group;
    public final persistence.Student4Public student;
    
    public StudyGroupManagerAddStudentToGroupStudyGroupStudentMssg(persistence.StudyGroup4Public group,
                                                                   persistence.Student4Public student,
                                                                   persistence.PersistentStudyGroupManager rcvr){
        this.group = group;
        this.student = student;
        this.rcvr = rcvr;
    }
    public void accept(StudyGroupManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleStudyGroupManagerAddStudentToGroupStudyGroupStudentMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.addStudentToGroupImplementation(this.group, this.student);
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
