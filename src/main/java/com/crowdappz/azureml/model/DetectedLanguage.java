package com.crowdappz.azureml.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DetectedLanguage {
    // ================ Constants =========================================== //

    // ================ Members ============================================= //
    @SerializedName("Name")
    @Expose
    private String Name;
    @SerializedName("Iso6391Name")
    @Expose
    private String Iso6391Name;
    @SerializedName("Score")
    @Expose
    private Double Score;

    // ================ Constructors & Main ================================= //
    public DetectedLanguage() {
    }

    public DetectedLanguage(String Name, String Iso6391Name, Double Score) {
        this.Name = Name;
        this.Iso6391Name = Iso6391Name;
        this.Score = Score;
    }

    // ================ Methods for/from SuperClass / Interfaces ============ //

    // ================ Public Methods ====================================== //

    // ================ Private Methods ===================================== //

    // ================ Getter & Setter ===================================== //
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getIso6391Name() {
        return Iso6391Name;
    }

    public void setIso6391Name(String Iso6391Name) {
        this.Iso6391Name = Iso6391Name;
    }

    public Double getScore() {
        return Score;
    }

    public void setScore(Double Score) {
        this.Score = Score;
    }

    // ================ Builder Pattern ===================================== //
    public DetectedLanguage withName(String Name) {
        this.Name = Name;
        return this;
    }

    public DetectedLanguage withScore(Double Score) {
        this.Score = Score;
        return this;
    }

    public DetectedLanguage withIso6391Name(String Iso6391Name) {
        this.Iso6391Name = Iso6391Name;
        return this;
    }

    // ================ Inner & Anonymous Classes =========================== //
}
