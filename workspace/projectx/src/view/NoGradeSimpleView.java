package view;

import view.visitor.*;

public interface NoGradeSimpleView extends GradesInSimpleView {
    
    
    public void accept(GradesInSimpleVisitor visitor) throws ModelException;
    public <R> R accept(GradesInSimpleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradesInSimpleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradesInSimpleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(GradesInSimpleOrThirdVisitor visitor) throws ModelException;
    public <R> R accept(GradesInSimpleOrThirdReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradesInSimpleOrThirdExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradesInSimpleOrThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

