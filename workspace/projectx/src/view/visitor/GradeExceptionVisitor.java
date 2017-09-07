
package view.visitor;
public interface GradeExceptionVisitor<E extends view.UserException> extends GradesInSimpleOrThirdExceptionVisitor<E>,GradesInTenthExceptionVisitor<E>{
    
    
}
