package com.pccc.sip.ivrtest.resolve.resolver;

public class TtsResolver implements Resolver {

    private String tts;

    public TtsResolver(String rule) {
        this.tts = rule;
    }

    @Override
    public boolean resolve(String str) {
        return false;
    }
}
