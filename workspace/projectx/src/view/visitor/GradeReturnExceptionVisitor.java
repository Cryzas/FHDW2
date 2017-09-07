
package view.visitor;
public interface GradeReturnExceptionVisitor<R, E extends view.UserException> extends GradesInSimpleOrThirdReturnExceptionVisitor<R, E> ,GradesInTenthReturnExceptionVisitor<R, E> {
    
    
}
