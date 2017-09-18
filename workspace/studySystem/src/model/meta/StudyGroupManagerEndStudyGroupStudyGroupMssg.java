package model.meta;

import persistence.*;

public class StudyGroupManagerEndStudyGroupStudyGroupMssg implements StudyGroupManagerDOWNMssgs,StudyGroupManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentStudyGroupManager rcvr;
    public final persistence.StudyGroup4Public studyGroup;
    
    public StudyGroupManagerEndStudyGroupStudyGroupMssg(persistence.StudyGroup4Public studyGroup,
                                                        persistence.PersistentStudyGroupManager rcvr){
        this.studyGroup = studyGroup;
        this.rcvr = rcvr;
    }
    public void accept(StudyGroupManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleStudyGroupManagerEndStudyGroupStudyGroupMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.endStudyGroupImplementation(this.studyGroup);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.AlreadyFinishedException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.AlreadyFinishedException) throw (model.AlreadyFinishedException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
