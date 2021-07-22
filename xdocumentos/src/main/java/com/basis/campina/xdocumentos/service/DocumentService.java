package com.basis.campina.xdocumentos.service;

import com.basis.campina.xdocumentos.config.ApplicationProperties;
import com.basis.campina.xdocumentos.service.dto.DocumentoDTO;
import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final MinioClient minioClient;
    private final ApplicationProperties applicationProperties;

    @SneakyThrows
    public String save(DocumentoDTO documentoDTO){
        minioClient.putObject(PutObjectArgs.builder()
                .stream(new ByteArrayInputStream(documentoDTO.getFile().getBytes()),documentoDTO.getFile().getBytes().length,0)
                .contentType(StandardCharsets.UTF_8.toString())
                .bucket(applicationProperties.getBucket())
                .object(documentoDTO.getUuid())
                .build());
        return documentoDTO.getUuid();
    }

    @SneakyThrows
    public DocumentoDTO getDocument(String uuid){
        GetObjectResponse file = minioClient.getObject(GetObjectArgs.builder()
                .bucket(applicationProperties.getBucket())
                .object(uuid)
                .build());
        return new DocumentoDTO(uuid, IOUtils.toString(file, StandardCharsets.UTF_8.toString()));
    }

    @SneakyThrows
    public void deletar(String uuid){
        minioClient.removeObject(RemoveObjectArgs.builder()
                .bucket(applicationProperties.getBucket())
                .object(uuid)
                .build());
    }
}
