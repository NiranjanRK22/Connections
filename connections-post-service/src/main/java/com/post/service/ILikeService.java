package com.post.service;

import com.post.model.Like;

public interface ILikeService {
    Like addLike(Like like);
    void deleteLike(int likeId);

}
