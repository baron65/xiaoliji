package com.tts.xiaoliji.startup.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import cn.openlo.gear.test.GearContextConfiguration;
import cn.openlo.gear.test.GearTestBase;

@GearContextConfiguration(boxName = "S4901", boxHome = "${user.dir}/src/test/resources/box01/", gearName = "xiaoliji-startup", gearStartTimeout = 200000)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Startup extends GearTestBase {

    @Test
    public void iz5() throws Throwable {
        try {
            System.in.read();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}