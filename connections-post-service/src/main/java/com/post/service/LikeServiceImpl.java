package com.post.service;

import com.post.model.Like;
import com.post.repository.ILikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements ILikeService{
    private ILikeRepository likeRepository;

    @Override
    public Like addLike(Like like) {
        return likeRepository.save(like);
    }

    @Override
    public void deleteLike(int likeId) {
        likeRepository.deleteById(likeId);
    }
}
