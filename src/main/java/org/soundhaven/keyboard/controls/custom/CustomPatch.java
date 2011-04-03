package org.soundhaven.keyboard.controls.custom;
import java.util.HashSet;
public class CustomPatch{
    private HashSet<CustomPatchElement> patch;
    private String name;
    
    public CustomPatch(){}
    
    public CustomPatch(String name){
        this.name=name;
    }
    
    public CustomPatch(HashSet<CustomPatchElement> patch){
        this.patch=patch;
    }
    
    public CustomPatch(String name, HashSet<CustomPatchElement> patch){
        this.name=name;
        this.patch=patch;
    }
    
    public String getName(){
        return name;
    }
    
    public HashSet<CustomPatchElement> getPatch(){
        return patch;
    }
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setPatch(HashSet<CustomPatchElement> patch){
        this.patch=patch;
    }
    
}
