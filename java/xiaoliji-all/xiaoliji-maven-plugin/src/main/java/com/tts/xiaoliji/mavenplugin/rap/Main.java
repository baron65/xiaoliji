package com.tts.xiaoliji.mavenplugin.rap;

import java.io.File;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

public class Main {
    public static void main(String[] args) throws MojoExecutionException, MojoFailureException {
        DubboServiceBeanGenerator gen = new DubboServiceBeanGenerator();
        
        File configurationFile = new File("E:/Svn/tt/xiaoliji/code/java/xiaoliji-all/xiaoliji-common/src/test/resources/xiaoliji/RapBeanGeneratorConfig.xml");
        gen.setConfigurationFile(configurationFile);
        
        gen.execute();
    }
}
