package com.assistant.speech.commandParsers;

public interface Parser<V, K> 
{
	public K parse(V toParse);
}
