package com.tts.xiaoliji.mavenplugin.rap;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 *@goal rap-generate
 */
public class DubboServiceBeanGenerator extends AbstractMojo {
    /** 
     * @parameter configurationFile="${configurationFile}" 
     * @required 
     */
    private File configurationFile;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

        if (configurationFile == null) {
            throw new MojoExecutionException("configurationFile is a required parameter");
        }
        if (!configurationFile.exists()) {
            throw new MojoExecutionException("configurationFile does not exist");
        }
        try {

            RapGeneratorConfig config = ParseXmlConfig.parse(configurationFile);

            DubboServiceBeanGeneratorCore.generate(config);

        }
        catch (Exception e) {
            e.printStackTrace();
            throw new MojoExecutionException(e.getMessage(), e);
        }
    }

    public File getConfigurationFile() {
        return configurationFile;
    }

    public void setConfigurationFile(File configurationFile) {
        this.configurationFile = configurationFile;
    }
}
