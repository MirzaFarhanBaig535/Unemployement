package com.example.unemployement.Models;

public class SoftSkillModelHomeScreen {

    int skillLogo;
    String skillTitle;
    String skillType;
    String skillMode;

    public SoftSkillModelHomeScreen() {
    }

    public SoftSkillModelHomeScreen(int skillLogo, String skillTitle, String skillType, String skillMode) {
        this.skillLogo = skillLogo;
        this.skillTitle = skillTitle;
        this.skillType = skillType;
        this.skillMode = skillMode;
    }

    public int getSkillLogo() {
        return skillLogo;
    }

    public void setSkillLogo(int skillLogo) {
        this.skillLogo = skillLogo;
    }

    public String getSkillTitle() {
        return skillTitle;
    }

    public void setSkillTitle(String skillTitle) {
        this.skillTitle = skillTitle;
    }

    public String getSkillType() {
        return skillType;
    }

    public void setSkillType(String skillType) {
        this.skillType = skillType;
    }

    public String getSkillMode() {
        return skillMode;
    }

    public void setSkillMode(String skillMode) {
        this.skillMode = skillMode;
    }
}
