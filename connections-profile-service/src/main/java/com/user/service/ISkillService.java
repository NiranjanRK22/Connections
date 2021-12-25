package com.user.service;


import com.user.model.Skills;

public interface ISkillService {
    Skills addSkill(Skills skills);
    Skills getSkillById(int skillsId);
}
