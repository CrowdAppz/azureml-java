package com.crowdappz.azureml.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class LanguageBatchResponse {

    // ================ Constants =========================================== //

    // ================ Members ============================================= //
    @SerializedName("LanguageBatch")
    @Expose
    private List<LanguageResponse> languageResponses = new ArrayList<>();

    @SerializedName("Errors")
    @Expose
    private List<Object> errors = new ArrayList<>();

    // ================ Constructors & Main ================================= //
    public LanguageBatchResponse() {
    }

    public LanguageBatchResponse(List<LanguageResponse> languageResponses, List<Object> errors) {
        this.languageResponses = languageResponses;
        this.errors = errors;
    }

    // ================ Methods for/from SuperClass / Interfaces ============ //

    // ================ Public Methods ====================================== //

    // ================ Private Methods ===================================== //

    // ================ Getter & Setter ===================================== //
    public List<LanguageResponse> getLanguageResponses() {
        return languageResponses;
    }

    public void setLanguageResponses(List<LanguageResponse> languageResponses) {
        this.languageResponses = languageResponses;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    // ================ Builder Pattern ===================================== //
    public LanguageBatchResponse withLanguageResponses(List<LanguageResponse> languageResponses) {
        setLanguageResponses(languageResponses);
        return this;
    }

    public LanguageBatchResponse withErrors(List<Object> errors) {
        setErrors(errors);
        return this;
    }

    // ================ Inner & Anonymous Classes =========================== //
}
