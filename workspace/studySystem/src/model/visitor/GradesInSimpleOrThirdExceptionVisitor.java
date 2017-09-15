
package model.visitor;
public interface GradesInSimpleOrThirdExceptionVisitor<E extends model.UserException> extends GradesInSimpleExceptionVisitor<E>,GradesInThirdExceptionVisitor<E>{
    
    
}
