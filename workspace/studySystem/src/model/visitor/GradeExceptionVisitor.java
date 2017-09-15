
package model.visitor;
public interface GradeExceptionVisitor<E extends model.UserException> extends GradesInSimpleOrThirdExceptionVisitor<E>,GradesInTenthExceptionVisitor<E>{
    
    
}
