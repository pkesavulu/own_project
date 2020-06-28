package com.dumbu.ai.ai;

import com.lotontech.speech.Talker;

public class HelloWorldTalk {
	public static void main(String[] args) {
        System.out.println("Hello World");
        Talker talker = new Talker();
        talker.sayPhoneWord("h|e|l|oo");
    }
}
