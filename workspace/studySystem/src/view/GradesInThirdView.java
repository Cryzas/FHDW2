package view;

import view.visitor.*;

public interface GradesInThirdView extends GradesInSimpleOrThirdView {
    
    
    public void accept(GradesInThirdVisitor visitor) throws ModelException;
    public <R> R accept(GradesInThirdReturnVisitor<R>  visitor) throws ModelException;
    public <E extends view.UserException>  void accept(GradesInThirdExceptionVisitor<E> visitor) throws ModelException, E;
    public <R, E extends view.UserException> R accept(GradesInThirdReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
}

