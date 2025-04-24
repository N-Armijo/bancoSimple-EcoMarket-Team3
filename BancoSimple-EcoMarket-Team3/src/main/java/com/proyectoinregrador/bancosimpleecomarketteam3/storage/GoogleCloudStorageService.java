package com.proyectoinregrador.bancosimpleecomarketteam3.storage;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class GoogleCloudStorageService {

    private String bucketName = "ynpcet-backend";

    private String keyPath = "src/main/java/com/proyectoinregrador/bancosimpleecomarketteam3/storage/YNPCET-KEY.json";

    private final Storage storage;
    {

        try {
            System.out.println( new FileInputStream(keyPath).toString());

        storage = StorageOptions.newBuilder().setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(keyPath))).build().getService();
        } catch (IOException e) {
        throw new RuntimeException(e);
        }
    }

    public String uploadImagenProducto(MultipartFile archivoImagen) throws IOException {

        if (!archivoImagen.getContentType().startsWith("image/")) {
            throw new IllegalArgumentException("Solo se permiten archivos de imagen");
        }

        String extension = FilenameUtils.getExtension(archivoImagen.getOriginalFilename());
        String nombreArchivo = "productos/" + UUID.randomUUID() + "." + extension;

        BlobId blobId = BlobId.of(bucketName, nombreArchivo);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId)
                .setContentType(archivoImagen.getContentType())
                .build();
        storage.create(blobInfo, archivoImagen.getBytes());

        return  String.format("https://storage.googleapis.com/%s/%s", bucketName, nombreArchivo);

    }

}


