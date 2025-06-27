package com.nit.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.nit.sbeans.SeasonFinder;

public class DependencyInjectionTest {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext fac = new FileSystemXmlApplicationContext("src/com/nit/cfgs/applicationContext.xml");

        SeasonFinder season = (SeasonFinder) fac.getBean("cmonth");

        String sea = season.showSeasonMessage("Lalit");

        System.out.println(sea);

        fac.close();
    }
}
