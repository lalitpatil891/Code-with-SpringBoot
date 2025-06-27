package com.nit.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;
import com.nit.sbeans.SeasonFinder;

public class DependencyInjectionTest {

    public static void main(String[] args) {
        FileSystemXmlApplicationContext fac = new FileSystemXmlApplicationContext("src/com/nit/cfgs/applicationContext.xml");

        SeasonFinder season = (SeasonFinder) fac.getBean("cmonth");

        String currentSeason = season.showSeasonMessage("Lalit");
        // PRACTICE cOMMIT
        System.out.println(currentSeason);

        fac.close();
    }
}
