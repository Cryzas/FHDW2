package model;

import model.visitor.ClipBoardStateReturnVisitor;
import persistence.Anything;
import persistence.ClipBoard4Public;
import persistence.Directory4Public;
import persistence.EmptyCBState4Public;
import persistence.ErrorDisplay4Public;
import persistence.File4Public;
import persistence.FileSystem4Public;
import persistence.FilledCBState4Public;
import persistence.PersistenceException;

public class GetIconInfo$Visitor extends model.visitor.AnythingStandardVisitor {

	int result = 0;
	
	@Override
	protected void standardHandling(Anything anything) throws PersistenceException {
		result = 0;	
	}

	public int getIconInfo(Anything anything) throws PersistenceException {
		anything.accept(this);
		return result;
	}
    public void handleErrorDisplay(ErrorDisplay4Public errorDisplay) throws PersistenceException{
        result = common.Constants.ErrorDisplayIconNumber;
    }
    public void handleFileSystem(FileSystem4Public fileSystem) throws PersistenceException{
        result = common.Constants.FileSystemIconNumber;
    }
    public void handleFile(File4Public file) throws PersistenceException{
        result = common.Constants.FileIconNumber;
           }
    public void handleDirectory(Directory4Public directory) throws PersistenceException{
        result = common.Constants.DirectoryIconNumber;
    }
    public void handleClipBoard(ClipBoard4Public clipBoard) throws PersistenceException{
        result = clipBoard.getState().accept(new ClipBoardStateReturnVisitor<Integer>() {
			@Override
			public Integer handleEmptyCBState(EmptyCBState4Public emptyCBState)
					throws PersistenceException {
				return common.Constants.EmptyClipBoardIconNumber;
			}
			@Override
			public Integer handleFilledCBState(
					FilledCBState4Public filledCBState)
					throws PersistenceException {
				return common.Constants.FilledClipBoardIconNumber;
			}
		});
    }
}
