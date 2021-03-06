package view;

import view.visitor.*;

public interface ModuleAtomarStudentView extends LectureWithGrade, ModuleAbstractStudentView {
    
    public GradesInSimpleOrThirdView getOwnGrade()throws ModelException;
    public void setOwnGrade(GradesInSimpleOrThirdView newValue) throws ModelException ;
    public java.util.Vector<GradeChangeView> getChanges()throws ModelException;
    public void setChanges(java.util.Vector<GradeChangeView> newValue) throws ModelException ;
    
    public void accept(ModuleAbstractStudentVisitor visitor) throws ModelException;
    public <R> R accept(ModuleAbstractStudentReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(ModuleAbstractStudentExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(ModuleAbstractStudentReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(LectureWithGradeVisitor visitor) throws ModelException;
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

