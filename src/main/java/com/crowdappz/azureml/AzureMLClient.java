package com.crowdappz.azureml;

import com.crowdappz.azureml.model.InputText;
import com.crowdappz.azureml.model.KeyPhraseBatchResponse;
import com.crowdappz.azureml.model.LanguageBatchResponse;
import com.crowdappz.azureml.model.LanguageResponse;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AzureMLClient {

    // ================ Constants =========================================== //
    private static final String GET_KEYPHRASES_URL = "https://api.datamarket.azure.com/data.ashx/amla/text-analytics/v1/GetKeyPhrases";
    private static final String GET_KEYPHRASES_BATCH_URL = "https://api.datamarket.azure.com/data.ashx/amla/text-analytics/v1/GetKeyPhrasesBatch";
    private static final String GET_LANGUAGE_URL = "https://api.datamarket.azure.com/data.ashx/amla/text-analytics/v1/GetLanguage";
    private static final String GET_LANGUAGE_BATCH_URL = "https://api.datamarket.azure.com/data.ashx/amla/text-analytics/v1/GetLanguageBatch";

    private static final String APPLICATION_JSON = "application/json";

    private static final Gson gson = new Gson();

    // ================ Members ============================================= //
    private String accountKey;
    private String authValue;

    // ================ Constructors & Main ================================= //
    public AzureMLClient(String accountKey) {
        this.accountKey = accountKey;
        this.authValue = calculateAuthValue();
    }

    // ================ Methods for/from SuperClass / Interfaces ============ //

    // ================ Public Methods ====================================== //

    /**
     * Calls getLanguageBatch and returns the first result.
     * Our implementation chooses to do so because of URL-parameter limitations (size and characters)
     */
    public LanguageResponse getLanugage(String inputText) {
        LanguageBatchResponse response = getLanguageBatch(Collections.singletonList(new InputText().withId("0").withText(inputText)));
        if (response.getLanguageResponses() == null || response.getLanguageResponses().get(0) == null
                || (response.getLanguageResponses().get(0).getUnknownLanguage() != null
                && response.getLanguageResponses().get(0).getUnknownLanguage())) {
            return null;
        }
        return response.getLanguageResponses().get(0);
    }

    public LanguageBatchResponse getLanguageBatch(List<InputText> inputTexts) {
        try {
            HttpResponse<String> response = Unirest.post(GET_LANGUAGE_BATCH_URL)
                                                   .body(gson.toJson(new BatchRequest(inputTexts)))
                                                   .getHttpRequest()
                                                   .header(HttpHeaders.AUTHORIZATION, authValue)
                                                   .header(HttpHeaders.ACCEPT, APPLICATION_JSON)
                                                   .asString();
            if (response.getStatus() == HttpStatus.SC_OK) {
                return gson.fromJson(response.getBody(), LanguageBatchResponse.class);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getKeyPhrases(String inputText) {
        KeyPhraseBatchResponse response = getKeyPhrasesBatch(Collections.singletonList(new InputText().withId("0").withText(inputText)));
        if (response == null || response.getKeyPhrases() == null || response.getKeyPhrases().get(0) == null) {
            return null;
        }
        return response.getKeyPhrases().get(0).getKeyPhrases();
    }

    public KeyPhraseBatchResponse getKeyPhrasesBatch(List<InputText> inputTexts) {
        try {
            HttpResponse<String> response = Unirest.post(GET_KEYPHRASES_BATCH_URL)
                                                   .body(gson.toJson(new BatchRequest(inputTexts)))
                                                   .getHttpRequest()
                                                   .header(HttpHeaders.AUTHORIZATION, authValue)
                                                   .header(HttpHeaders.ACCEPT, APPLICATION_JSON)
                                                   .asString();
            if (response.getStatus() == HttpStatus.SC_OK) {
                return gson.fromJson(response.getBody(), KeyPhraseBatchResponse.class);
            }
        } catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ================ Private Methods ===================================== //
    private String calculateAuthValue() {
        return "Basic " + new String(Base64.encodeBase64(("AccountKey:" + accountKey).getBytes()));
    }

    // ================ Getter & Setter ===================================== //

    // ================ Builder Pattern ===================================== //


    // ================ Inner & Anonymous Classes =========================== //
    private class BatchRequest {

        @SerializedName("Inputs")
        @Expose
        private List<InputText> inputs = new ArrayList<>();

        public BatchRequest() {
        }

        public BatchRequest(List<InputText> inputs) {
            this.inputs = inputs;
        }

        public List<InputText> getInputs() {
            return inputs;
        }

        public void setInputs(List<InputText> inputs) {
            this.inputs = inputs;
        }
    }
}
