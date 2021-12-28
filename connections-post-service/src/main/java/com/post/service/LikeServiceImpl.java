package com.post.service;

import com.post.model.Like;
import com.post.repository.ILikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements ILikeService{
    private ILikeRepository likeRepository;

    /**
     *
     * @param like
     * @return
     */
    @Override
    public Like addLike(Like like) {
        return likeRepository.save(like);
    }

    /**
     *
     * @param likeId
     */
    @Override
    public void deleteLike(int likeId) {
        likeRepository.deleteById(likeId);
    }
}
