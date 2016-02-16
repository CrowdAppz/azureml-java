package com.crowdappz.azureml.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class InputText {

    // ================ Constants =========================================== //

    // ================ Members ============================================= //
    @SerializedName("Id")
    @Expose
    private String id;

    @SerializedName("Text")
    @Expose
    private String text;

    // ================ Constructors & Main ================================= //
    public InputText() {
    }

    public InputText(String text, String id) {
        this.text = text;
        this.id = id;
    }

    // ================ Methods for/from SuperClass / Interfaces ============ //

    // ================ Public Methods ====================================== //

    // ================ Private Methods ===================================== //

    // ================ Getter & Setter ===================================== //
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // ================ Builder Pattern ===================================== //
    public InputText withId(String id) {
        setId(id);
        return this;
    }

    public InputText withText(String text) {
        setText(text);
        return this;
    }

    // ================ Inner & Anonymous Classes =========================== //
}
