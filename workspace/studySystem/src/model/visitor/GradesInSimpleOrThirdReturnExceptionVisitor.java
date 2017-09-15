
package model.visitor;
public interface GradesInSimpleOrThirdReturnExceptionVisitor<R, E extends model.UserException> extends GradesInSimpleReturnExceptionVisitor<R, E> ,GradesInThirdReturnExceptionVisitor<R, E> {
    
    
}
