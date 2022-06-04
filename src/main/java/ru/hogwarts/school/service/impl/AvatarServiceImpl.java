package ru.hogwarts.school.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;
import ru.hogwarts.school.service.AvatarService;

import javax.transaction.Transactional;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Service
@Transactional
public class AvatarServiceImpl implements AvatarService {

    private static final int IMAGE_BLOCK_BUFFER_SIZE = 1024;

    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    private final StudentServiceImpl studentService;
    private final AvatarRepository avatarRepository;

    public AvatarServiceImpl(StudentServiceImpl studentService, AvatarRepository avatarRepository) {
        this.studentService = studentService;
        this.avatarRepository = avatarRepository;
    }

    @Override
    public Long uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        Student student = studentService.findStudent(studentId);
        Path filePath = Path.of(avatarsDir, student + "." +
                getExtensions(avatarFile.getOriginalFilename()));

        Files.createDirectories(filePath.getParent());
        Files.deleteIfExists(filePath);

        try (
                BufferedInputStream bis = new BufferedInputStream(avatarFile.getInputStream(), IMAGE_BLOCK_BUFFER_SIZE);
                BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(filePath, StandardOpenOption.CREATE_NEW), IMAGE_BLOCK_BUFFER_SIZE)
        ) {
            bis.transferTo(bos);
        }

        Avatar avatar = findAvatar(studentId);
        avatar.setStudent(student);
        avatar.setFilePath(filePath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());

        return avatarRepository.save(avatar).getId();
    }

    @Override
    public Avatar findAvatar(Long id) {
        return avatarRepository.findId(id).orElse(new Avatar());
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

}
