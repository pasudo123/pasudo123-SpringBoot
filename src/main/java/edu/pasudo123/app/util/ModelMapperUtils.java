package edu.pasudo123.app.util;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ModelMapperUtils {

    private final ModelMapper modelMapper;

    /**
     * Mapping, source object map to destinationType
     *
     * @param source object to map from
     * @param destinationType type to map to
     * @param <D> destination type
     * @return object 리턴
     */
    public <D> D map(final Object source, final Class<D> destinationType){
        return modelMapper.map(source, destinationType);
    }


    /**
     *
     * @param sources objects to map from (배열데이터)
     * @param destinationType type to map to
     * @param <T> source type
     * @param <D> destination type
     * @return List 형태 리턴
     */
    public <T, D> List<D> mapAll(final List<T> sources, final Class<D> destinationType){

        return sources.stream()
                .map(source -> this.map(source, destinationType))
                .collect(Collectors.toList());
    }
}
