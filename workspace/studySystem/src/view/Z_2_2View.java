package view;

import view.visitor.*;

public interface Z_2_2View extends GradesInTenthView {
    
    
    public void accept(GradesInTenthVisitor visitor) throws ModelException;
    public <R> R accept(GradesInTenthReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradesInTenthExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradesInTenthReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(GradeVisitor visitor) throws ModelException;
    public <R> R accept(GradeReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradeExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradeReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

