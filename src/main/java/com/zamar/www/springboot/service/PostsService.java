package com.zamar.www.springboot.service;

import com.zamar.www.springboot.domain.posts.Posts;
import com.zamar.www.springboot.domain.posts.PostsRepository;
import com.zamar.www.springboot.web.dto.PostsResponseDto;
import com.zamar.www.springboot.web.dto.PostsSaveRequestDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));
        return new PostsResponseDto(entity);
    }
}
