package com.company;

public class ManipulationDetails {

    private String inputTextFile;
    private String outputTextFile;
    private String action;

    public ManipulationDetails(String inputTextFile, String outputTextFile, String action) {
        this.inputTextFile = inputTextFile;
        this.outputTextFile = outputTextFile;
        this.action = action;
    }

    public String getInputTextFile() {
        return inputTextFile;
    }

    public void setInputTextFile(String inputTextFile) {
        this.inputTextFile = inputTextFile;
    }

    public String getOutputTextFile() {
        return outputTextFile;
    }

    public void setOutputTextFile(String outputTextFile) {
        this.outputTextFile = outputTextFile;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
