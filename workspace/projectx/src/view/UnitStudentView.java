package view;

import view.objects.*;

import view.visitor.*;

public interface UnitStudentView extends Anything, LectureWithGrade, AbstractViewRoot {
    
    public String getName()throws ModelException;
    public common.Fraction getCreditPoints()throws ModelException;
    public GradesInThirdView getGrade()throws ModelException;
    public void setGrade(GradesInThirdView newValue) throws ModelException ;
    public common.Fraction getCPmulGrade()throws ModelException;
    public common.Fraction getCPwithGrade()throws ModelException;
    
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(LectureWithGradeVisitor visitor) throws ModelException;
    public <R> R accept(LectureWithGradeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(LectureWithGradeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(LectureWithGradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

