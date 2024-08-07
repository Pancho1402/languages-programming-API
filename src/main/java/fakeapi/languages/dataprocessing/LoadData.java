package fakeapi.languages.dataprocessing;

import com.fasterxml.jackson.databind.ObjectMapper;
import fakeapi.languages.model.Language;
import fakeapi.languages.service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @author Pancho1402
 */
@Configuration
public class LoadData {
    private static final Logger logger = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initData(LanguageService service){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("languages.json");

            var languages = objectMapper.readValue(file, new TypeReference<List<Language>>() {});
            return  args -> logger.info("Loading:", service.saveAll(languages));
        }catch (IOException e){
            return args -> logger.error(e.getMessage());
        }
    }
}
