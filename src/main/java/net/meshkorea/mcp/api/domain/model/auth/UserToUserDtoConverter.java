package net.meshkorea.mcp.api.domain.model.auth;

import net.meshkorea.mcp.api.domain.entity.auth.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 10..
 */
public class UserToUserDtoConverter implements Converter<List<User>, List<UserDto>> {

    @Override
    public List<UserDto> convert(MappingContext<List<User>, List<UserDto>> context) {
        List<User> src = context.getSource();
        if (src != null) {
            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<UserDto>>() {}.getType();
            return modelMapper.map(src, listType);
        }
        return null;
    }

}
