package com.user.service;

import com.user.model.Skills;
import com.user.repository.ISkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements ISkillService{

    private ISkillRepository skillRepository;

    @Autowired
    public void setSkillRepository(ISkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skills addSkill(Skills skills) {
        return skillRepository.save(skills);
    }

    @Override
    public Skills getSkillById(int skillsId) {
        return skillRepository.getById(skillsId);
    }
}
