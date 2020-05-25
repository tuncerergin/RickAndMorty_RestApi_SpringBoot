package com.tuncerergin.rickandmorty.service;

import com.tuncerergin.rickandmorty.entity.report.Endpoint;

public interface ReportService {
    Endpoint getEndpoint(String uri);
}
