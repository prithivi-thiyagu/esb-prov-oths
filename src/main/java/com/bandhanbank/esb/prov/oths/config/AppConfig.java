package com.bandhanbank.esb.prov.oths.config;

//import com.bandhanbank.esb.common.util.Logger.Masking.MaskConfigLoader;
//import com.bandhanbank.esb.common.util.Logger.Masking.ValueMasker;
import com.bandhanbank.esb.common.util.Logger.Masking.MaskConfigLoader;
import com.bandhanbank.esb.common.util.Logger.Masking.ValueMasker;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${maskconfig.file.path}")
    private String maskConfigPathUrl;
    @Bean
    public ObjectMapper objectMapper()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE); // Enables root wrapping
        objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE); // Enables root unwrapping
        return objectMapper;
    }

    @Bean
    public MaskConfigLoader maskConfigLoader() {
        return new MaskConfigLoader(); // Replace with actual implementation
    }

    @Bean
    public ValueMasker valueMasker(MaskConfigLoader maskConfigLoader) {
        ValueMasker valueMasker = new ValueMasker(maskConfigLoader);
        valueMasker.setConfigFilePath(maskConfigPathUrl); // Set the config file path
        return valueMasker;
    }

}
