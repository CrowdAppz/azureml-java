package com.crowdappz.azureml.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class LanguageResponse {

    // ================ Constants =========================================== //

    // ================ Members ============================================= //
    @SerializedName("Id")
    @Expose
    private String id;

    @SerializedName("DetectedLanguages")
    @Expose
    private List<DetectedLanguage> detectedLanguages = new ArrayList<>();

    @SerializedName("UnknownLanguage")
    @Expose
    private Boolean unknownLanguage;

    // ================ Constructors & Main ================================= //
    public LanguageResponse() {
    }

    public LanguageResponse(List<DetectedLanguage> detectedLanguages, Boolean unknownLanguage) {
        this.detectedLanguages = detectedLanguages;
        this.unknownLanguage = unknownLanguage;
    }

    // ================ Methods for/from SuperClass / Interfaces ============ //

    // ================ Public Methods ====================================== //

    // ================ Private Methods ===================================== //

    // ================ Getter & Setter ===================================== //
    public String getId() {
        if (id == null || id.isEmpty()) {
            return "";
        }

        return id;
    }

    public void setId(String Dd) {
        this.id = id;
    }

    public List<DetectedLanguage> getDetectedLanguages() {
        return detectedLanguages;
    }

    public void setDetectedLanguages(List<DetectedLanguage> detectedLanguages) {
        this.detectedLanguages = detectedLanguages;
    }

    public Boolean getUnknownLanguage() {
        return unknownLanguage;
    }

    public void setUnknownLanguage(Boolean unknownLanguage) {
        this.unknownLanguage = unknownLanguage;
    }

    // ================ Builder Pattern ===================================== //
    public LanguageResponse withId(String Id) {
        setId(Id);
        return this;
    }

    public LanguageResponse withDetectedLanguages(List<DetectedLanguage> detectedLanguages) {
        setDetectedLanguages(detectedLanguages);
        return this;
    }

    public LanguageResponse withUnknownLanguage(Boolean unknownLanguage) {
        setUnknownLanguage(unknownLanguage);
        return this;
    }

    // ================ Inner & Anonymous Classes =========================== //
}
