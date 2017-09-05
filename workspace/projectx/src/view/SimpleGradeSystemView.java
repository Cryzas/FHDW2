package view;

import view.visitor.*;

public interface SimpleGradeSystemView extends GradeSystemView {
    
    
    public void accept(GradeSystemVisitor visitor) throws ModelException;
    public <R> R accept(GradeSystemReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradeSystemExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradeSystemReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    public void accept(AnythingVisitor visitor) throws ModelException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

