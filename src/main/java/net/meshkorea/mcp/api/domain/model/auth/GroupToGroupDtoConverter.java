package net.meshkorea.mcp.api.domain.model.auth;

import net.meshkorea.mcp.api.domain.entity.auth.Group;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.spi.MappingContext;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by reverof on 2017. 6. 10..
 */
public class GroupToGroupDtoConverter implements Converter<List<Group>, List<GroupDto>> {

    @Override
    public List<GroupDto> convert(MappingContext<List<Group>, List<GroupDto>> context) {
        List<Group> src = context.getSource();
        if (src != null) {
            ModelMapper modelMapper = new ModelMapper();
            Type listType = new TypeToken<List<GroupDto>>() {}.getType();
            return modelMapper.map(src, listType);
        }
        return null;
    }
}
