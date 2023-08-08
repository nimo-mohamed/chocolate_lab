package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
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

        @Override
        public void run(ApplicationArguments args) throws Exception {

            List<String> rawWords = Arrays.asList(

                    "snickers",
                    "mars",
                    "twix",
                    "galaxy",
                    "bounty",
                    "milkyway"
            );

            for (String rawWord : rawWords) {
                Chocolate chocolate = new Chocolate(rawWord);
                chocolateRepository.save(chocolate);
            }

        }
    }

