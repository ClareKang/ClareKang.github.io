package net.meshkorea.mcp.api.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

    void init();

    void store(MultipartFile file);

    void store(File file);

    Stream<Path> loadAll();

    Path load(String fileName);

    Resource loadAsResource(String fileName);

    void delete(String fileName);

    void deleteAll();

    File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException;

}
