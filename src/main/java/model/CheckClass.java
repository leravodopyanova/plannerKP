package model;

public class CheckClass {
    public String checkStatus(Boolean check){
        if(check.equals(false)){
            return "Х";
        }
        else{
            return "V";
        }
    }
}
