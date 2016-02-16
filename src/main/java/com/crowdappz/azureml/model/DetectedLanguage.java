package com.crowdappz.azureml.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class DetectedLanguage {

    // ================ Constants =========================================== //

    // ================ Members ============================================= //
    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("Iso6391Name")
    @Expose
    private String iso6391Name;

    @SerializedName("Score")
    @Expose
    private Double score;

    // ================ Constructors & Main ================================= //
    public DetectedLanguage() {
    }

    public DetectedLanguage(String name, String iso6391Name, Double score) {
        this.name = name;
        this.iso6391Name = iso6391Name;
        this.score = score;
    }

    // ================ Methods for/from SuperClass / Interfaces ============ //

    // ================ Public Methods ====================================== //

    // ================ Private Methods ===================================== //

    // ================ Getter & Setter ===================================== //
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso6391Name() {
        return iso6391Name;
    }

    public void setIso6391Name(String iso6391Name) {
        this.iso6391Name = iso6391Name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    // ================ Builder Pattern ===================================== //
    public DetectedLanguage withName(String name) {
        setName(name);
        return this;
    }

    public DetectedLanguage withScore(Double score) {
        setScore(score);
        return this;
    }

    public DetectedLanguage withIso6391Name(String iso6391Name) {
        setIso6391Name(iso6391Name);
        return this;
    }

    // ================ Inner & Anonymous Classes =========================== //
}
