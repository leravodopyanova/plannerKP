package model;

public class TypeFileFactory {
    public SaveSettings getSaveType(String filename, String ext, Object object){
        if(ext.equals(".png")){
            return new SavePng(filename, ext);
        }
        if(ext.equals(".dat")){
            return new SaveDat(filename, ext, object);
        }

        return null;
    }
}
