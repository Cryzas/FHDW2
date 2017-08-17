package view.objects;

import view.*;
import viewClient.*;

public abstract class GradeSystemProxi extends ViewProxi implements GradeSystemView{
    
    public GradeSystemProxi(long objectId, long classId, ExceptionAndEventHandler connectionKey) {
        super(objectId, classId, connectionKey);
    }
    
    
    
    
    
    public javafx.scene.image.Image getImage(){
        return super.getImage();
    }

	/* Start of protected part that is not overridden by persistence generator */
    
    @SuppressWarnings("unused")
	private final int RemoteDepth = 1;
    
    /* End of protected part that is not overridden by persistence generator */
    
}
