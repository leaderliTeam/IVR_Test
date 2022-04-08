package com.pccc.sip.ivrtest.resolve.resolver;

import org.apache.commons.lang3.StringUtils;

public class ResolverFactory {

    private static final String voice = "voice|";
    private static final String tts = "tts|";
    private static final String gap = "gap|";

    public Resolver createResolver(String rule) {
        if (StringUtils.startsWith(rule, voice)) {
            String vocieNo = StringUtils.replace(rule, voice, "");
            return new VoiceResolver(vocieNo);
        }
        if (StringUtils.startsWith(rule, tts)) {
            String ttsStr = StringUtils.replace(rule, tts, "");
            return new TtsResolver(ttsStr);
        }
        if (StringUtils.startsWith(rule, gap)) {
            String gap = StringUtils.replace(rule, ResolverFactory.gap, "");
            return new GapResolver(gap);
        }
        return null;
    }

}
