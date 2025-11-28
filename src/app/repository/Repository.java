package app.repository;

import app.model.ContenidoAudiovisual;
import java.util.List;

public interface Repository {
    List<ContenidoAudiovisual> loadAll() throws Exception;
    void saveAll(List<ContenidoAudiovisual> items) throws Exception;
}
