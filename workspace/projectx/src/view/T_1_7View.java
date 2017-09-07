package view;

import view.visitor.*;

public interface T_1_7View extends GradesInThirdView {
    
    
    public void accept(GradesInThirdVisitor visitor) throws ModelException;
    public <R> R accept(GradesInThirdReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradesInThirdExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradesInThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws ModelException;
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(GradeVisitor visitor) throws ModelException;
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

