package com.crowdappz.azureml.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class KeyPhrase {

    // ================ Constants =========================================== //

    // ================ Members ============================================= //
    @SerializedName("KeyPhrases")
    @Expose
    private List<String> keyPhrases;

    @SerializedName("Id")
    @Expose
    private String id;

    // ================ Constructors & Main ================================= //
    public KeyPhrase() {
    }

    public KeyPhrase(List<String> keyPhrases, String id) {
        this.keyPhrases = keyPhrases;
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

    public List<String> getKeyPhrases() {
        return keyPhrases;
    }

    public void setKeyPhrases(List<String> keyPhrases) {
        this.keyPhrases = keyPhrases;
    }

    // ================ Builder Pattern ===================================== //
    public KeyPhrase withId(String id) {
        setId(id);
        return this;
    }

    public KeyPhrase withKeyPhrases(List<String> keyPhrases) {
        setKeyPhrases(keyPhrases);
        return this;
    }

    // ================ Inner & Anonymous Classes =========================== //
}
