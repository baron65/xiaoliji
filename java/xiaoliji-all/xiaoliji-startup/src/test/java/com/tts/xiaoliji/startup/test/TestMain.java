package com.tts.xiaoliji.startup.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import cn.openlo.dependency.DependAttrs;
import cn.openlo.dependency.maven.MavenRepository;
import cn.openlo.dependency.maven.manager.MavenDependencyManager;

public class TestMain {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        String filePath = "E:/Data/111.230.226.65/dependencymanager.properties";

        InputStream in = new BufferedInputStream(new FileInputStream(new File(filePath)));
        props.load(in);

        DependAttrs attrs = new DependAttrs(props);

        MavenDependencyManager mng = new MavenDependencyManager(attrs);
//        Map<String, MavenRepository> repositories=mng.g
        
        String url ="com/fasterxml/jackson/core/jackson-annotations/2.8.5/jackson-annotations-2.8.5.pom";

        System.out.println(mng);
    }
}
