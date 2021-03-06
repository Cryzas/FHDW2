package view;

import view.visitor.*;

public interface GradesInSimpleView extends GradesInSimpleOrThirdView {
    
    
    public void accept(GradesInSimpleVisitor visitor) throws ModelException;
    public <R> R accept(GradesInSimpleReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradesInSimpleExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradesInSimpleReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

