# azureml-java
A Java Client Library for Azure Machine Learning APIs

## Usage

Create an instance of the AzureMLClient

```
AzureMLClient client = new AzureMLClient("YourAccountKey");
```

Execute arbitrary API requests using the client:
```
client.getKeyphrases("Hello World");
```

## Authors
This client library for AzureML is developed by

Henning Muszynski (https://github.com/henningmu)

Benjamin Räthlein (https://github.com/raethlein)
