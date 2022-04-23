package com.cgi.weatherman.service;

import com.cgi.weatherman.model.SourceApiKey;
import com.cgi.weatherman.repository.SourceApiKeyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SourceApiService {
    final SourceApiKeyRepository sourceApiKeyRepository;

    public SourceApiService(SourceApiKeyRepository sourceApiKeyRepository) {
        this.sourceApiKeyRepository = sourceApiKeyRepository;
    }

    public List<SourceApiKey> getSourceApiKeys() {
        return sourceApiKeyRepository.getAllSourceApiKeys();
    }

}
