package kodlamaio.Devs.core.utitilies.mapper;

import org.modelmapper.ModelMapper;


public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequests();
}
