package com.pccc.sip.ivrtest.resolve.resolver;

import com.pccc.sip.ivrtest.resolve.ExecItem;

public class VoiceResolver implements Resolver {

    private String voiceNo;

    public VoiceResolver(String rule) {
        this.voiceNo = rule;
    }

    @Override
    public boolean resolve(ExecItem str) {
        return false;
    }

}
