/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author Charindu Kavishan
 */
public class Module {
    
    private int id;
    private String name;
    private String description;
    private String semestor;
    private int fee;
    private boolean isEnroll;

    public Module(int id, String name, String description, String semestor, int fee) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.semestor = semestor;
        this.fee = fee;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSemestor() {
        return semestor;
    }

    public int getFee() {
        return fee;
    }

    public void setIsEnroll(boolean isEnroll) {
        this.isEnroll = isEnroll;
    }

    public boolean isIsEnroll() {
        return isEnroll;
    }    
}
