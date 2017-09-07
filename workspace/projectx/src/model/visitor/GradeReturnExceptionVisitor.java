
package model.visitor;
public interface GradeReturnExceptionVisitor<R, E extends model.UserException> extends GradesInSimpleOrThirdReturnExceptionVisitor<R, E> ,GradesInTenthReturnExceptionVisitor<R, E> {
    
    
}
