
package view;


import view.visitor.*;


/* Additional import section end */

@SuppressWarnings("serial")
public abstract class UserException extends Exception{
    
    
    public UserException(String message) {
        /* Shall not be used. Objects are created on the server only */
        super(message);        
    }
    
    
    abstract public void accept(UserExceptionVisitor visitor) throws ModelException;
    abstract public <R> R accept(UserExceptionReturnVisitor<R>  visitor) throws ModelException;
    abstract public <E extends view.UserException>  void accept(UserExceptionExceptionVisitor<E> visitor) throws ModelException, E;
    abstract public <R, E extends view.UserException> R accept(UserExceptionReturnExceptionVisitor<R, E>  visitor) throws ModelException, E;
    
    
}
