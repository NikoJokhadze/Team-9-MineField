package mvc;

public class Model extends Bean {
    private Boolean unsavedChanges;
    private String fileName;

    public void Model()
    {
        unsavedChanges = false;
        fileName = null;
    }

    public void changed() {
        unsavedChanges = true;
        firePropertyChange(fileName, false, true);
    }

    public Boolean getUnsavedChanges() {
        return unsavedChanges;
    }

    public String getFileName() {
        return fileName;
    }

    public void setUnsavedChanges(Boolean change) {
        unsavedChanges = change;
    }

    public void setFileName(String newName) {
        fileName = newName;
    }
}


