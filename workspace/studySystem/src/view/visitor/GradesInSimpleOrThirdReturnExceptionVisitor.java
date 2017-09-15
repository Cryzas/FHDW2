
package view.visitor;
public interface GradesInSimpleOrThirdReturnExceptionVisitor<R, E extends view.UserException> extends GradesInSimpleReturnExceptionVisitor<R, E> ,GradesInThirdReturnExceptionVisitor<R, E> {
    
    
}
