package model.meta;

import persistence.*;

public class StudentManagerChangeGradeLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssg implements StudentManagerDOWNMssgs,StudentManagerUPMssgs{
    
    private java.util.Date exctDte = null;
    private Exception excptn;
    public final persistence.PersistentStudentManager rcvr;
    public final persistence.LectureWithGrade lecture;
    public final String grade;
    public final String comment;
    
    public StudentManagerChangeGradeLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssg(persistence.LectureWithGrade lecture,
                                                                                               String grade,
                                                                                               String comment,
                                                                                               persistence.PersistentStudentManager rcvr){
        this.lecture = lecture;
        this.grade = grade;
        this.comment = comment;
        this.rcvr = rcvr;
    }
    public void accept(StudentManagerMssgsVisitor visitor) throws PersistenceException{
        visitor.handleStudentManagerChangeGradeLectureWithGradeGradesInSimpleOrThirdSUBTYPENameStringMssg(this);
    }
    public synchronized void execute() {
        if (this.exctDte == null){
            this.exctDte = new java.util.Date();
            try{
                this.rcvr.changeGradeImplementation(this.lecture, this.grade, this.comment);
            }catch(Exception exception){
                this.excptn = exception;
            }
        }
    }
    public synchronized void getResult() throws model.AlreadyFinishedException, model.InvalidGradeForSystemException, PersistenceException {
        if(this.excptn != null) {
            if(this.excptn instanceof model.AlreadyFinishedException) throw (model.AlreadyFinishedException) this.excptn;
            if(this.excptn instanceof model.InvalidGradeForSystemException) throw (model.InvalidGradeForSystemException) this.excptn;
            if(this.excptn instanceof PersistenceException) throw (PersistenceException) this.excptn;
            if(this.excptn instanceof RuntimeException) throw (RuntimeException) this.excptn;
            throw new Error(this.excptn);
            
        }
    }
    
}
