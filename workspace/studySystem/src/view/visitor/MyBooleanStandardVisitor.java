
package view.visitor;

import view.*;

public abstract class MyBooleanStandardVisitor implements MyBooleanVisitor {
    
    public void handleBFalse(BFalseView bFalse) throws ModelException{
        this.standardHandling(bFalse);
    }
    public void handleBTrue(BTrueView bTrue) throws ModelException{
        this.standardHandling(bTrue);
    }
    protected abstract void standardHandling(MyBooleanView myBoolean) throws ModelException;
}
