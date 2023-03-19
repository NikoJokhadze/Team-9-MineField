package mvc;

/* Class "Model" Datalog

3/10/2023 - Niko Jokhadze: Created file

3/11/2023 - Owen Semersky: Added instance variables, getters, setters, and "changed" method.

 */

public class Model extends Bean {
    private Boolean unsavedChanges;
    private String fileName;

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