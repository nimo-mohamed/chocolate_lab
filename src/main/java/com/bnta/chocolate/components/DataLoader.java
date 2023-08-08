package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.naming.Name;
import java.util.Arrays;
import java.util.List;
    @Component

    public class DataLoader implements ApplicationRunner {

        @Autowired
        ChocolateRepository chocolateRepository;

        @Autowired
        EstateRepository estateRepository; // need to autowire this in too so that we can reference the Estate class

        @Override
        public void run(ApplicationArguments args) throws Exception {

            Estate defaultEstate = new Estate("Default Estate", "Unknown"); // Create a default estate: we need this for the new Chocolate on line 43 as it takes in an Estate object as a parameter

            estateRepository.save(defaultEstate); // saves default estate

            List<String> chocolateTypes = Arrays.asList(

                    "snickers",
                    "mars",
                    "twix",
                    "galaxy",
                    "bounty",
                    "milkyway"
            );

            for (String chocolateType : chocolateTypes) { // loop through the chocolate types (snickers, mars etc.)
                Chocolate chocolate = new Chocolate(chocolateType, 70, defaultEstate);  // creates a new instance of the Chocolate class and initializes its properties using the provided values
                chocolateRepository.save(chocolate); // saves chocolate
            }
        }
    }

