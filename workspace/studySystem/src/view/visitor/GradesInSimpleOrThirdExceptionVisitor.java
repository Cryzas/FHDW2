
package view.visitor;
public interface GradesInSimpleOrThirdExceptionVisitor<E extends view.UserException> extends GradesInSimpleExceptionVisitor<E>,GradesInThirdExceptionVisitor<E>{
    
    
}
