package org.openmainframeproject.cobolcheck.services;

import java.util.HashMap;
import java.util.Map;

public class RunInfo {
    private static String currentProgramName;
    private static String currentProgramPath;
    private static Map<String, String> testSuiteNameToPathMap = new HashMap<>();
    private static String configFilePath;
    private static String generatedCobolSourcePath;
    private static String compiledProgramPath;

    public static void setCurrentProgramName(String programName){currentProgramName = programName;}
    public static String getCurrentProgramName(){return currentProgramName;}

    public static String getCurrentProgramPath() {
        return currentProgramPath;
    }

    public static void setCurrentProgramPath(String currentProgramPath) {
        RunInfo.currentProgramPath = currentProgramPath;
    }

    public static String getTestSuitePath(String testSuiteName) {
        testSuiteName = "\"" + testSuiteName + "\"";
        if (testSuiteNameToPathMap.containsKey(testSuiteName))
            return testSuiteNameToPathMap.get(testSuiteName);
        else
            return "";
    }

    public static void addTestSuiteNameToPathMapKeyValuePair(String testSuiteName, String path) {
        testSuiteNameToPathMap.put(testSuiteName, path);
    }

    public static String getConfigFilePath() {
        return configFilePath;
    }

    public static void setConfigFilePath(String configFilePath) {
        RunInfo.configFilePath = configFilePath;
    }

    public static String getGeneratedCobolSourcePath() {
        return generatedCobolSourcePath;
    }

    public static void setGeneratedCobolSourcePath(String generatedCobolSourcePath) {
        RunInfo.generatedCobolSourcePath = generatedCobolSourcePath;
        if (generatedCobolSourcePath.contains(".")){
            RunInfo.compiledProgramPath =  generatedCobolSourcePath.substring(0, generatedCobolSourcePath.indexOf("."));
        }

    }

    public static String getCompiledProgramPath() {
        return compiledProgramPath;
    }
}
