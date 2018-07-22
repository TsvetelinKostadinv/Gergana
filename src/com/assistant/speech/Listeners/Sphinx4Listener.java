package com.assistant.speech.Listeners;

import java.io.IOException;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

public class Sphinx4Listener implements Listener {
	
	Configuration configuration;
	
	private String acousticModelPath = "resource:/edu/cmu/sphinx/models/en-us/en-us";
	private String dictionaryPath;
	private String languageModel;
	
	public Sphinx4Listener(String dictionaryPath, String languageModel)
	{
		this.configuration = new Configuration();
		this.dictionaryPath = dictionaryPath;
		this.languageModel = languageModel;
		
		
        // Set path to the acoustic model.
        configuration.setAcousticModelPath(this.acousticModelPath);
        // Set path to the dictionary.
        configuration.setDictionaryPath(this.dictionaryPath);
        // Set path to the language model.
        configuration.setLanguageModelPath(this.languageModel);
	}
	
	@Override
	public String listenForASinglePhrase() {
		
        LiveSpeechRecognizer recognizer = null;
        
		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        recognizer.startRecognition(true);
        
        SpeechResult result;
        
        result = recognizer.getResult();
        return result.getHypothesis();
	}

	public String getAcousticModelPath() {
		return acousticModelPath;
	}

	public void setAcousticModelPath(String acousticModelPath) {
		this.acousticModelPath = acousticModelPath;
	}

}
