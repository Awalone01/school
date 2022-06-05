package ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;

import java.io.IOException;
import java.util.Collection;


public interface AvatarService {

    Long uploadAvatar(Long studentId, MultipartFile avatar) throws IOException;

    Avatar findAvatar(Long id);

    Collection<Avatar> getFiveAvatar(Integer pageNumber, Integer pageSize);
}
