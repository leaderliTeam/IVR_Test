package com.pccc.sip.ivrtest.resolve.resolver;

public class VoiceResolver implements Resolver {

    private String voiceNo;

    public VoiceResolver(String rule) {
        this.voiceNo = rule;
    }

    @Override
    public boolean resolve(String str) {
        return false;
    }

}
