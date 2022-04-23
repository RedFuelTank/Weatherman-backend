package com.cgi.weatherman.repository;

import com.cgi.weatherman.model.SourceApiKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SourceApiKeyRepository extends JpaRepository<SourceApiKey, Long> {
    @Modifying
    @Query("update SourceApiKey u set u.apiKey = :apiKey where u.id = :id")
    void update(Long id, String apiKey);

    @Modifying
    @Query("delete from SourceApiKey u where u.id = :id")
    void remove(Long id);

    @Query("select u.id from SourceApiKey u where u.name = :name")
    long getIdByName(String name);

    @Query("select u from SourceApiKey u where 1 = 1")
    List<SourceApiKey> getAllSourceApiKeys();
}
