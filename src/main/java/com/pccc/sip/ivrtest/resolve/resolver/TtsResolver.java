package com.pccc.sip.ivrtest.resolve.resolver;

import com.pccc.sip.ivrtest.resolve.ExecItem;

public class TtsResolver implements Resolver {

    private String tts;

    public TtsResolver(String rule) {
        this.tts = rule;
    }

    @Override
    public boolean resolve(ExecItem str) {
        return false;
    }
}
