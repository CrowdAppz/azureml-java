package com.crowdappz.azureml.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class KeyPhraseBatchResponse {

    // ================ Constants =========================================== //

    // ================ Members ============================================= //
    @SerializedName("KeyPhrasesBatch")
    @Expose
    private List<KeyPhrase> keyPhrases;

    @SerializedName("Errors")
    @Expose
    private List<Object> errors;

    // ================ Constructors & Main ================================= //
    public KeyPhraseBatchResponse() {
    }

    public KeyPhraseBatchResponse(List<KeyPhrase> keyPhrases, List<Object> errors) {
        this.keyPhrases = keyPhrases;
        this.errors = errors;
    }

    // ================ Methods for/from SuperClass / Interfaces ============ //

    // ================ Public Methods ====================================== //

    // ================ Private Methods ===================================== //

    // ================ Getter & Setter ===================================== //
    public List<KeyPhrase> getKeyPhrases() {
        return keyPhrases;
    }

    public void setKeyPhrases(List<KeyPhrase> keyPhrases) {
        this.keyPhrases = keyPhrases;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }

    // ================ Builder Pattern ===================================== //
    public KeyPhraseBatchResponse withKeyPhrases(List<KeyPhrase> keyPhrases) {
        setKeyPhrases(keyPhrases);
        return this;
    }

    public KeyPhraseBatchResponse withErrors(List<Object> errors) {
        setErrors(errors);
        return this;
    }

    // ================ Inner & Anonymous Classes =========================== //
}
