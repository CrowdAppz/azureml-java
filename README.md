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
