package net.meshkorea.mcp.api.config.data;

import net.meshkorea.mcp.api.domain.model.auth.GroupToGroupDtoConverter;
import net.meshkorea.mcp.api.domain.model.auth.UserToUserDtoConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by reverof on 2017. 6. 2..
 */
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setFieldMatchingEnabled(true)
            .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
            .setMatchingStrategy(MatchingStrategies.LOOSE);
        modelMapper.addConverter(new UserToUserDtoConverter());
        modelMapper.addConverter(new GroupToGroupDtoConverter());
        return modelMapper;
    }
}
